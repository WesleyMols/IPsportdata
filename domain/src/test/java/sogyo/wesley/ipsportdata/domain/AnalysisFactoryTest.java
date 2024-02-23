package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalysisFactoryTest {
    private String name;
    private AnalysisFactory test;
    private int power;
    private double lactate_one;
    private double lactate_two;
    private IAnalyser init;
    private int heartrate;
    private double weigth;
    private int size;
    
    @BeforeEach
    public void init() {
    name = "Julia";
    test = new AnalysisFactory();
    power = 200;
    lactate_one = 2.2;
    lactate_two = 3.3;
    heartrate = 142;
    init = test.createNewAnalysis(name, power, lactate_one, lactate_two, heartrate, weigth, size);
    }

    @Test
    void createNewAnalysisMLSSTest() {
        assertEquals(name, init.getUsername());
        assertEquals(power, init.getPower());
        assertEquals(lactate_one, init.getLactate_one());
        assertEquals(lactate_two, init.getLactate_two());
        assertEquals(heartrate, init.getHeartrate());
    }
}
