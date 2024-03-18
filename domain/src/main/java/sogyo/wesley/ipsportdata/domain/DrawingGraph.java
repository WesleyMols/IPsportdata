package sogyo.wesley.ipsportdata.domain;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class DrawingGraph {
	private List<Integer> x = new ArrayList<>();
    private List<Integer> y= new ArrayList<>();
	public void setX(List<Integer> x) {
        this.x = x;
    }
    
    public void setY(List<Integer> y) {
        this.y = y;
    }
	public DrawingGraph(List<Integer>  x, List<Integer>  y) {
        
        int width = 700;
		int height = 700;
		JFrame jframe = new JFrame();
		DrawingCanvas dc = new DrawingCanvas(width,height,x,y);
        
		jframe.setSize(width, height);
		jframe.add(dc);

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
        System.out.println("drawinggraph");
        dc.saveCanvas(dc);
    }
    public int getWidth() {
        return 1;
    }
}

