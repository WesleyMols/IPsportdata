package sogyo.wesley.ipsportdata.persistence;

import java.util.HashMap;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

public class Mock implements IMock {
     private  HashMap<String, IAnalysor> database = new HashMap<String, IAnalysor>();

    @Override
    public void save(String key, IAnalysor game) {
        database.put(key, game);
    }

    @Override
    public IAnalysor get(String key) {
       return database.get(key);
    }
}