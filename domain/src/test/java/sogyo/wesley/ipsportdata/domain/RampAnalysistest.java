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
    private RampAnalysis two;
    private RampAnalysis three;
    private double diff;
    List<Integer> x = new ArrayList<>();
    List<Integer> y = new ArrayList<>();
    List<Integer> xy = new ArrayList<>();
    HashMap<String, IRampAnalyse> MockStorage = new HashMap<String, IRampAnalyse>();

    @BeforeEach
    void init() {
        speed1 = 14;
        speed2 = 18;
        speed3 = 22;
        heartrate1 = 120;
        heartrate2 = 140;
        heartrate3 = 160;
        one = new RampAnalysis(speed1, heartrate1);
        two = new RampAnalysis(speed2, heartrate2);
        three = new RampAnalysis(speed3, heartrate3);
        x.add(speed1);
        x.add(speed2);
        x.add(speed3);
        one.setX(one);
        one.setX(two);
        one.setX(three);
        y.add(y.size(),heartrate1);
        y.add(y.size(),heartrate2);
        y.add(y.size(),heartrate3);
        one.setY(one);
        one.setY(two);
        one.setY(three);
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
    void fillArrayXTest() {
        assertEquals(x, one.getX());
    }
    @Test
    void fillArrayYTest() {
        assertEquals(y, one.getY());
    }
    @Test // be aware that controller setXY()
    void fillArrayXYTest() {
        MockStorage.put("key", one);
        x.add(x.size(), one.getSpeed());
        one.setX(MockStorage.get("key"));
        assertEquals(x, one.getX());
    }
}
