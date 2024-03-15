package sogyo.wesley.ipsportdata.domain;
import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.*;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawingCanvas extends JComponent {
	private final int width;
	private final int height;
	private List<Integer> x= new ArrayList<>();
    private List<Integer> y= new ArrayList<>();
	
	public DrawingCanvas(int width, int height){
	this.width = width;
	this.height = height;
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D graph2d = (Graphics2D) g;
		RenderingHints renderingHints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		graph2d.setRenderingHints(renderingHints);
		Rectangle2D.Double background = new Rectangle2D.Double(0,0,width,height);
		graph2d.setColor(new Color(0, 255, 136, 163));
		graph2d.fill(background);

		Line2D.Double xaxis = new Line2D.Double(50,50, 50,650);
		graph2d.setColor(Color.black);
		graph2d.draw(xaxis);

		Line2D.Double yaxis = new Line2D.Double(50,650, 650,650);
		graph2d.setColor(Color.black);
		graph2d.draw(yaxis);

		Path2D.Double output = new Path2D.Double();
		output.moveTo(x.get(0),y.get(0));
		for(int i = 1; i < x.size(); i++) {
		output.lineTo(x.get(i),y.get(i));}
		//output.lineTo(150,150);
		graph2d.draw(output);
	}
	public void saveCanvas(DrawingCanvas canvas) {
		System.out.println("in save plot");
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		String outputPath = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "IPsportdata" + File.separator + "Tekeningen" + File.separator + "my_image.png";
		File outputFile = new File(outputPath);
		Graphics2D graph2d = (Graphics2D)image.getGraphics();
			
		canvas.paint(graph2d);
		try {
			System.out.println("in save try");
			ImageIO.write(image, "png", outputFile);
			System.out.println("File exists: " + outputFile.exists());
			System.out.println("Image saved successfully to " + outputPath);
		} catch (Exception e) {
				
		}
	}
	public void setX(List<Integer> x) {
        x.addAll(x);
    }
  
    public void setY(List<Integer> y) {
        y.addAll(y);
    }
}
