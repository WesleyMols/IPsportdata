package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

public interface IRepository {
    void MysqlCon(IAnalysor game); 
    void MysqlCon(IAnalysor game, String id);
}
