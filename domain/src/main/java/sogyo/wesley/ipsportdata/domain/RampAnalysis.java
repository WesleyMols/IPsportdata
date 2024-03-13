package sogyo.wesley.ipsportdata.domain;

import java.util.ArrayList;
import java.util.List;


public class RampAnalysis implements IRampAnalyse {
    private int speed;
    private int heartrate;
    private List<Integer> y= new ArrayList<>();
    private double diff;
    private double Yintersection;

    public RampAnalysis(int speed, int heartrate){
        this.speed = speed;
        this.heartrate = heartrate;
        
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

    // @Override // no numpy error
    // public void plot() {
    //     Plot plt = Plot.create();
    //     plt.plot().add(x, y, "o").label("sin");
    //     plt.legend().loc("upper right");
    //     plt.title("scatter");
    //     try {
    //         plt.show();
    //     } catch (IOException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     } catch (PythonExecutionException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }

}
