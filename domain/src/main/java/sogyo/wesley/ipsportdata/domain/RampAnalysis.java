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
    public void setX2(List<Integer> x) {
        this.x = x;
    }
    @Override
    public void setY(List<Integer> y) {
        this.y = y;
    }

    @Override
    public int getHeartrate() {
        return heartrate;
    }

    @Override
    public int getSpeed() {
        return speed;
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
