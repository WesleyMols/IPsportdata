package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalysisFactoryTest {
    private String name;
    private Analysor testObject;
    private AnalysisFactory test;
    private int power;
    private double lactate_one;
    private double lactate_two;
    private IAnalysor init;
    private IAnalysor initName;
    
    @BeforeEach
    public void init() {
    name = "Julia";
    testObject = new Analysor(name);
    test = new AnalysisFactory();
    power = 200;
    lactate_one = 2.2;
    lactate_two = 3.3;
    init = test.createNewAnalysis(power, lactate_one, lactate_two);
    initName = test.createNewAnalysis(name);
}

    @Test
    void createNewAnalysisTest() {
        assertInstanceOf(Analysor.class, testObject);
    }

    @Test
    void createNewAnalysisStringTest() {
        assertEquals(name, testObject.name);
        assertEquals(name, initName.getUsername());
    }

    @Test
    void createNewAnalysisMLSSTest() {
        assertEquals(power, init.getPower());
        assertEquals(lactate_one, init.getLactate_one());
        assertEquals(lactate_two, init.getLactate_two());
    }
}
