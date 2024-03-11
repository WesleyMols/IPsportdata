package sogyo.wesley.ipsportdata.domain;

import java.util.HashMap;

public class RampAnalysis implements IRampAnalyse {
    private int speed;
    private int heartrate;
    private HashMap<String, IRampAnalyse> inputCoordinates = new HashMap<>();

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
}
