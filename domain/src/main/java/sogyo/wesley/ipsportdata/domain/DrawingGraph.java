package sogyo.wesley.ipsportdata.domain;
import javax.swing.*;

public class DrawingGraph {
	public DrawingGraph() {
        
        int width = 700;
		int height = 700;
		JFrame jframe = new JFrame();
		DrawingCanvas dc = new DrawingCanvas(width,height);
        
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

