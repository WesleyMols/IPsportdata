package sogyo.wesley.ipsportdata.domain;

import java.util.List;

public interface IAnalysor {
    String getUsername();
    int getPower();
    double getLactate_two();
    int getHeartrate();
    double getLactate_one();
    double getCalcLactateDifference();
    List<String> getPowerInputList();
    void setPowerInputList(List<String> powerInputList);
}
