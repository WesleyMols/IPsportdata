package sogyo.wesley.ipsportdata.domain;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

public class RampAnalysis implements IRampAnalyse {
    private int speed;
    private int heartrate;
    private HashMap<String, IRampAnalyse> inputCoordinates = new HashMap<>();
    List<Double> x= Arrays.asList(1.38, 2.56, 4.3);
    List<Double> y= Arrays.asList(1.38, 2.56, 4.3);

    public RampAnalysis(int speed, int heartrate){
        this.speed = speed;
        this.heartrate = heartrate;
    }

    public int getHeartrate() {
        return heartrate;
    }
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setInputCoordinates(String key, IRampAnalyse input) {
        inputCoordinates.put(key, input);
    }
    
    public IRampAnalyse getInputCoordinates(String key) {
        return inputCoordinates.get(key);
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
