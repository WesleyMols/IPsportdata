package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalysorTest {
    //init
    
    String name = "Eline";
    Analysor test = new Analysor(name);
    double lactate_one = 3.3;
    double lactate_two = 5.2;
    double lt_diffTest = lactate_two - lactate_one;
    Analysor result = new Analysor(100, lactate_one, lactate_two);
    
    //test
    @Test
    void getUsernameTest() {
        assertEquals(test.getUsername(), "Eline");
    }

    @Test
    void calcLactateDiffTest() {
        double lt_diff = result.lactate_two - result.lactate_one;

        assertEquals(lt_diffTest, lt_diff);
    }
}
