package sogyo.wesley.ipsportdata.persistence;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import sogyo.wesley.ipsportdata.domain.Analysor;
import sogyo.wesley.ipsportdata.domain.IAnalysor;

public class RepositoryTest {
    //init
    private  HashMap<String, IAnalysor> database = new HashMap<String, IAnalysor>();
    String key = "key  string";
    IAnalysor game = new Analysor(key);

    @Test
    public void saveAndGetTest(){
        database.put(key, game);
        assertTrue(database.get(key) != null && database.containsKey(key));
    }

    // tests for database
    // dbunit?
    // eigen db voor testen
}
