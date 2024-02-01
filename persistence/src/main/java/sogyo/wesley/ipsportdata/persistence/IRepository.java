package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

public interface IRepository {
    /**
     * @param key  The key under which the game should be saved
     * @param game The game to be saved
     */
    void save(String key, IAnalysor game);

    /**
          * @param key The key for retrieval
     * @return The game saved under the key
     */
    IAnalysor get(String key);

    void MysqlCon(); 

}
