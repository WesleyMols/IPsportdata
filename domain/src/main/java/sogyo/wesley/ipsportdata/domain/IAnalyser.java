package sogyo.wesley.ipsportdata.domain;

import java.util.List;

public interface IAnalyser {
    String getUsername();
    double getWeigth();
    int getSize();
    int getPower();
    double getLactate_two();
    int getHeartrate();
    double getLactate_one();
    double getCalcLactateDifference();
    List<String> getPowerInputList();
    void setPowerInputList(List<String> powerInputList);
    List<Integer> getLastTwoPowerList();
    int getAverageMLSSPower();
    double getWattPerKg();
}
