package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RampAnalysistest {
    private int speed1;
    private int speed2;
    private int speed3;
    private int heartrate1;
    private int heartrate2;
    private int heartrate3;
    private RampAnalysis one;
    private double diff;
    List<Integer> x = new ArrayList<>();
    List<Integer> y = new ArrayList<>();
    List<Integer> resultTestList;
    List<Integer> resultTestListHR;

    @BeforeEach
    void init() {
        speed1 = 14;
        speed2 = 18;
        speed3 = 22;
        heartrate1 = 120;
        heartrate2 = 140;
        heartrate3 = 160;
        one = new RampAnalysis(speed1, heartrate1);
        x.add(speed1);
        x.add(speed2);
        x.add(speed3);
        one.setX2(x);
        y.add(y.size(),heartrate1);
        y.add(y.size(),heartrate2);
        y.add(y.size(),heartrate3);
        one.setY(y);
        resultTestList = one.getX();
        resultTestListHR = one.getY();
    }

    @Test
    void calcDifferenceYTest() {
        diff = 140-120;
        assertEquals(diff, one.calcDifferenceY());
    }

    @Test
    void calcYintersectionTest() {
        calcDifferenceYTest();
        double Yintersection = heartrate1 - diff;
        assertEquals(Yintersection, one.calcYintersection());
    }

    @Test
    void fillArrayXRepoTest() {
        assertEquals(3, resultTestList.size());
        assertEquals(resultTestList.get(0), 14);
    }

    @Test
    void fillArrayYRepoTest() {
        assertEquals(3, resultTestListHR.size());
        assertEquals(resultTestListHR.get(2), 160);
    }

    @Test
    void fillArrayXTest() {
        assertEquals(x, one.getX());
    }
    @Test
    void fillArrayYTest() {
        assertEquals(y, one.getY());
    }
    
}
