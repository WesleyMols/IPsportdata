package sogyo.wesley.ipsportdata.domain;

public interface IRampAnalyse {
    int getSpeed();
    int getHeartrate();
    void setInputCoordinates(String key, IRampAnalyse input);
}
