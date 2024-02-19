package sogyo.wesley.ipsportdata.persistence;

import java.util.List;

import sogyo.wesley.ipsportdata.domain.IAnalyser;

public interface IRepository {
    void MysqlSave(IAnalyser game);
    List<String> MysqlGet(IAnalyser game);
}
