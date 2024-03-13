package sogyo.wesley.ipsportdata.domain;

import java.util.List;

public interface IRampAnalyse {
    int getSpeed();
    int getHeartrate();
    void setY(List<Integer> y);
    void setX(List<Integer> x);
    //void plot();
}
