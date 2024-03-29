package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnalyserTest {
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
    private double weight;
    private int size;
    private double speed;

    @BeforeEach
    public void init() {
        name = "Elizabeth";
        power = 200;
        lactate_one = 3.3;
        lactate_two = 5.2;
        heartrate = 155;
        weight = 50;
        result = new Analyser(name, power, lactate_one, lactate_two, heartrate, weight, size);
        next = new Analyser(name, power, lactate_one, lactate_one, heartrate,weight, size);
        secondResult = new Analyser(name, power+100, lactate_one +1, lactate_two+1, heartrate+15, weight, size);
        resultTestList = result.getPowerInputList();
        resultTestList.add(String.valueOf(next.getPower()));
        resultTestList.add(String.valueOf(secondResult.getPower()));
  
    }

    @Test
    void calcLactateDiffTest() { 
        double lt_diff = lactate_two - lactate_one;
        assertEquals(lt_diff, result.getCalcLactateDifference());
    }

    @Test
    void calclactateDiffnegativeTest() {
        Analyser test = new Analyser(name, power, lactate_one, 0, heartrate, weight, size);
        double testDiff = 0 - lactate_one;
        assertEquals(testDiff, test.getCalcLactateDifference());
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
        assertEquals(outputMessage, next.getOutputAnalysis());
    }

    @Test
    void getPowerInputListTest() {
        assertEquals(2, resultTestList.size());
        assertEquals(resultTestList.get(0), String.valueOf(result.getPower()));
        assertEquals(resultTestList.get(1), String.valueOf(secondResult.getPower()));
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
        assertEquals(180, aerobePower);
    }

    @Test
    void zeroweightTest() {
        Analyser test = new Analyser(name, power, lactate_one, lactate_two, heartrate, 0, size);
        List<String> listtest = new ArrayList<>();
        listtest.add("200");
        listtest.add("300");
        test.setPowerInputList(listtest);
        double wattPerkg = test.getWattPerKg();
        assertEquals(0, wattPerkg);
    }
    @Test
    void calcWattPerKgtest() {
        double expected = result.getAverageMLSSPower()/result.getWeight();
        assertEquals(expected, result.getWattPerKg());
    }
    @Test
    void getSizeTest() {
        assertEquals(size, result.getSize());
    }
    @Test
    void calcSpeedPowerTest() {
        result.getOutputAnalysis();
        speed = result.getSpeedFromMLSSPower();
        double actual = 15.96*Math.log(250)-48.48;
        assertEquals(1, Math.log(Math.E));
        actual = Analyser.round(actual, 2);
        speed = Analyser.round(speed, 2);
        assertEquals(speed, actual);
    }

    @Test 
    void speedIfisEndFalse() {
        speed = next.getSpeedFromMLSSPower();
        assertEquals(0, speed);
    }

    @Test
    void roundExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {Analyser.round(lactate_one,-2);});
    }
}
