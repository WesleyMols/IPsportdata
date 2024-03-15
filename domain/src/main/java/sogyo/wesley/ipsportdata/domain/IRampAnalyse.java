package sogyo.wesley.ipsportdata.domain;

import java.util.List;

public interface IRampAnalyse {
    int getSpeed();
    int getHeartrate();
    void setY(IRampAnalyse inputXY);
    void setX(IRampAnalyse inputXY);
    void setX(List<Integer> x);
    //void plot();
}
