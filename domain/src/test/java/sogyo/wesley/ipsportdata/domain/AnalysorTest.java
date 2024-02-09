package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalysorTest {
    //init
    
    private String name = "Eline";
    private Analysor test = new Analysor(name);
    private double lactate_one = 3.3;
    private double lactate_two = 5.2;
    private double lt_diffTest = lactate_two - lactate_one;
    private Analysor result = new Analysor(100, lactate_one, lactate_two);
    private boolean isEnd;
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

    @Test
    void isAnalysisEndTest() {
        isEnd = result.isAnalysisEnd();
        assertTrue(isEnd);
    }
}
