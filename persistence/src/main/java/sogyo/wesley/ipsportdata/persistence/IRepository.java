package sogyo.wesley.ipsportdata.persistence;

import java.util.List;

import sogyo.wesley.ipsportdata.domain.IAnalyser;
import sogyo.wesley.ipsportdata.domain.IRampAnalyse;

public interface IRepository {
    void MysqlSave(IAnalyser input);
    List<String> MysqlGet(IAnalyser input);
    void RampSave(String key, IRampAnalyse input);
    IRampAnalyse RampGet(String key);
    List<Integer> getRampSpeed();
    List<Integer> getRampHeartrate();
}
