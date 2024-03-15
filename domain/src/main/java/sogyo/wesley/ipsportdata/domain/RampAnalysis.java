package sogyo.wesley.ipsportdata.domain;

import java.util.ArrayList;
import java.util.List;


public class RampAnalysis implements IRampAnalyse {
    private int speed;
    private int heartrate;
    private List<Integer> x= new ArrayList<>();
    private List<Integer> y= new ArrayList<>();
    private double diff;
    private double Yintersection;


    public RampAnalysis(int speed, int heartrate){
        this.speed = speed;
        this.heartrate = heartrate;
    }
    @Override
    public void setX(IRampAnalyse inputXY) {
        x.add(x.size(), inputXY.getSpeed());
    }
    @Override
    public void setX(List<Integer> x) {
        this.x = x;
    }
    @Override
    public void setY(IRampAnalyse inputXY) {
        //y.add(5);
        y.add( inputXY.getHeartrate());
    }

    @Override
    public int getHeartrate() {
        return heartrate;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void setGraph() {
        DrawingCanvas dc = new DrawingCanvas(700, 700);
        dc.setX(x);
    }

    public double calcDifferenceY() {
        if(y.size() > 1){
       return diff = y.get(1) - y.get(0);
        } else { return 0;}
    }

    public double calcYintersection() {
        return Yintersection = y.get(0) - diff;
    }
    public List<Integer> getY() {
        return y;
    }
    public List<Integer> getX() {
        return x;
    }

}
