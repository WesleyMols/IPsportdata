package sogyo.wesley.ipsportdata.persistence;

import java.util.List;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

public interface IRepository {
    void MysqlSave(IAnalysor game);
    List<String> MysqlGet(IAnalysor game);
}
