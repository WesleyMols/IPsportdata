package sogyo.wesley.ipsportdata.domain;

public interface IRampAnalyse {
    int getSpeed();
    int getHeartrate();
    void setY(IRampAnalyse inputXY);
    void setX(IRampAnalyse inputXY);
    //void plot();
}
