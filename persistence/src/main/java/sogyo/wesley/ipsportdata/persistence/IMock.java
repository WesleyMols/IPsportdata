package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

public interface IMock {

    void save(String key, IAnalysor game);
    IAnalysor get(String key);
    
} 
