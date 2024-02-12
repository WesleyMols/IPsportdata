package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalysorTest {
    //init
    private String name;
    private int power;
    private double lactate_one;
    private double lactate_two;
    private double lt_diffTest;
    private Analysor result;
    private Analysor next;
    private boolean isEnd;
    private String outputMessage;

    @BeforeEach
    public void init() {
        name = "Eline";
        power = 200;
        lactate_one = 3.3;
        lactate_two = 5.2;
        lt_diffTest = lactate_two - lactate_one;
        result = new Analysor(name, power, lactate_one, lactate_two);
        next = new Analysor(name, power, lactate_one, lactate_one);
    }
    //test

    @Test
    void calcLactateDiffTest() { 
        double lt_diff = result.lactate_two - result.lactate_one;
        assertEquals(lt_diffTest, lt_diff);
    }

    @Test
    void getCalcLactateDiffTest() {
        assertEquals(lt_diffTest, result.lt_diff);
    }

    @Test
    void isAnalysisEndTest() {
        isEnd = result.isAnalysisEnd();
        assertTrue(isEnd);
    }

    @Test
    void outputAnalysisConcatTest() {
        isEnd = result.isAnalysisEnd();
        if(isEnd) {outputMessage = "Your MLSS power: " + result.power;}
        assertEquals(outputMessage, "Your MLSS power: 200");
    }

    @Test
    void outputAnalysisTest() {
        result.isAnalysisEnd();
        result.getOutputAnalysis();
        outputMessage = "Your MLSS power: " + result.power;
        assertEquals(outputMessage, result.outputMessage);
    }

    @Test
    void isEndFalseTest() {
        next.isAnalysisEnd();
        assertFalse(isEnd);
        next.getOutputAnalysis();
        outputMessage = "please input next measurement";
        assertEquals(outputMessage, next.outputMessage);
    }
}
