package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class RampAnalysistest {
    private int speed;
    private int heartrate;
    private HashMap<String, IRampAnalyse> inputTest = new HashMap<>();
    RampAnalysis one;
    RampAnalysis two;
    RampAnalysis three;
    private final String testId = "testId";
    

    @Test
    void inputToArrayofCoordinatesTest() {
        speed = 14;
        heartrate = 160;
        one = new RampAnalysis(10, 120);
        two = new RampAnalysis(12, 140);
        three = new RampAnalysis(speed, heartrate);
        inputTest.put(testId, one);
        one.setInputCoordinates(testId, one);
        assertEquals(one, one.getInputCoordinates(testId));
    }
}
