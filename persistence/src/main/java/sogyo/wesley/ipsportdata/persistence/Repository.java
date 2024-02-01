package sogyo.wesley.ipsportdata.persistence;
import sogyo.wesley.ipsportdata.domain.IAnalysor;
import java.util.*;

// a hashmap instead of DB to store data as key-value pairs

public class Repository implements IRepository{
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
