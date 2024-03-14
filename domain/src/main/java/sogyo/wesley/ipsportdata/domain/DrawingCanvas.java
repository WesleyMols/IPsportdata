package sogyo.wesley.ipsportdata.domain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawingCanvas extends JComponent {
	private final int width;
	private final int height;
	
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
		output.moveTo(100,550);
		output.lineTo(150,450);
		output.lineTo(200,200);
		graph2d.draw(output);
	}
	public void saveCanvas(DrawingCanvas canvas) {
		System.out.println("in save plot");
		BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(),BufferedImage.TYPE_INT_RGB);
			
		Graphics2D g2 = (Graphics2D)image.getGraphics();
			
		canvas.paint(g2);
		try {
			System.out.println("in save try");
			ImageIO.write(image, "png", new File("/figure/plot.png"));
		} catch (Exception e) {
				
		}
	}
}
