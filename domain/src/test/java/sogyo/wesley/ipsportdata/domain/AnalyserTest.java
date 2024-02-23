package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalyserTest {
    //init
    private String name;
    private int power;
    private double lactate_one;
    private double lactate_two;
    private Analyser result;
    private Analyser next;
    private Analyser secondResult;
    private boolean isEnd;
    private String outputMessage;
    private int heartrate;
    private List<String> resultTestList;
    private double weigth;
    private int size;
    private double speed;

    @BeforeEach
    public void init() {
        name = "Elizabeth";
        power = 200;
        lactate_one = 3.3;
        lactate_two = 5.2;
        heartrate = 155;
        weigth = 50;
        result = new Analyser(name, power, lactate_one, lactate_two, heartrate, weigth, size);
        next = new Analyser(name, power, lactate_one, lactate_one, heartrate,weigth, size);
        secondResult = new Analyser(name, power+100, lactate_one +1, lactate_two+1, heartrate+15, weigth, size);
        resultTestList = result.powerInputList;
        resultTestList.add(String.valueOf(next.power));
        resultTestList.add(String.valueOf(secondResult.power));
  
    }

    @Test
    void calcLactateDiffTest() { 
        double lt_diff = result.lactate_two - result.lactate_one;
        assertEquals(lt_diff, result.lt_diff);
    }

    @Test
    void isAnalysisEndTest() {
        isEnd = result.isAnalysisEnd();
        assertTrue(isEnd);
    }

    @Test
    void outputAnalysisConcatTest() {
        result.setPowerInputList(resultTestList);
        result.getAverageMLSSPower();
        result.getWattPerKg();
        outputMessage = "Your MLSS power lies between : 200 watt and 300 watt. With an average of 250watt, or 5,0 watt/kg";
        assertEquals(outputMessage, result.getOutputAnalysis());
    }

    @Test
    void isEndFalseTest() {
        next.isAnalysisEnd();
        assertFalse(isEnd);
    }
    @Test
    void isEndMessageTest() {
        next.getOutputAnalysis();
        outputMessage = "Please input next measurement";
        assertEquals(outputMessage, next.outputMessage);
    }

    @Test
    void getPowerInputListTest() {
        assertEquals(resultTestList.size(), 2);
        assertEquals(resultTestList.get(0), String.valueOf(result.power));
        assertEquals(resultTestList.get(1), String.valueOf(secondResult.power));
    }

    @Test
    void setPowerInputListTest() {
        result.setPowerInputList(resultTestList);
        assertEquals(resultTestList, result.getPowerInputList());
    }

    @Test
    void setAverageMLSSPower() {
        result.setPowerInputList(resultTestList);
        int avg = result.getAverageMLSSPower();
        assertEquals(250, avg);
    }
    @Test
    void calcAerobePowerTest() {
        result.setPowerInputList(resultTestList);
        double aerobePower = result.getAerobePower();
        assertEquals(aerobePower, 180);
    }

    @Test
    void zeroWeigthTest() {
        result.setPowerInputList(resultTestList);
        result.weigth = 0;
        double wattPerkg = result.getWattPerKg();
        assertEquals(wattPerkg, 0);
    }
    @Test
    void calcSpeedPowerTest() {
        result.getOutputAnalysis();
        speed = result.getSpeedFromMLSSPower();
        double actual = 15.96*Math.log(250)-48.48;
        assertEquals(Math.log(Math.E), 1);
        actual = result.round(actual, 2);
        speed = result.round(speed, 2);
        assertEquals(speed, actual);
    }

    @Test 
    void speedIfisEndFalse() {
        speed = next.getSpeedFromMLSSPower();
        assertEquals(speed, 0);
    }

    @Test
    void roundExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {result.round(lactate_one,-2);});
    }
}
