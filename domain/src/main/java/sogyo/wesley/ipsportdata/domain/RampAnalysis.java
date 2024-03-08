package sogyo.wesley.ipsportdata.domain;

public class RampAnalysis implements IRampAnalyse {
    private int speed;
    private int heartrate;

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
}
