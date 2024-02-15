package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
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
    private Analysor secondResult;
    private boolean isEnd;
    private String outputMessage;
    private int heartrate;

    @BeforeEach
    public void init() {
        name = "Elizabeth";
        power = 200;
        lactate_one = 3.3;
        lactate_two = 5.2;
        lt_diffTest = lactate_two - lactate_one;
        heartrate = 155;
        result = new Analysor(name, power, lactate_one, lactate_two, heartrate);
        next = new Analysor(name, power, lactate_one, lactate_one, heartrate);
        secondResult = new Analysor(name, 300, lactate_one +1, lactate_two+1, 170);
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
        if(isEnd) {outputMessage = "Your MLSS power lies between: " + result.power + "watt and " + secondResult.power + " ";}
        assertEquals(outputMessage, "Your MLSS power lies between: 200watt and 300 ");
    }

    @Test
    void outputAnalysisTest() {
        isEnd = false;
        outputMessage = next.getOutputAnalysis();
        assertEquals(outputMessage, "please input next measurement");
    }

    @Test
    void isEndFalseTest() {
        next.isAnalysisEnd();
        assertFalse(isEnd);
        next.getOutputAnalysis();
        outputMessage = "please input next measurement";
        assertEquals(outputMessage, next.outputMessage);
    }

    @Test
    void setHeartrateTest() {
        assertEquals(secondResult.heartrate, 170);
    }
}
