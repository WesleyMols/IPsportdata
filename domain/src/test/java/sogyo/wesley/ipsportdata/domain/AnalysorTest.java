package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AnalysorTest {
    //init
    String name = "Eline";
    Analysor test = new Analysor(name);
    
    //test
    @Test
    void getUsernameTest() {
        assertEquals(test.getUsername(), "Eline");
    }
}
