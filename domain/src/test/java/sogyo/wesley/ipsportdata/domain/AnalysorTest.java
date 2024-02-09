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
    private String outputMessage;
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

    @Test
    void outputAnalysisConcatTest() {
        isAnalysisEndTest();
        if(isEnd) {outputMessage = "Your MLSS power: " + result.power;}
        assertEquals(outputMessage, "Your MLSS power: 100");
    }

    @Test
    void outputAnalysisTest() {
        isAnalysisEndTest();
        result.outputAnalysis();
        outputMessage = "Your MLSS power: " + result.power;
        assertEquals(outputMessage, result.outputMessage);
    }
}
