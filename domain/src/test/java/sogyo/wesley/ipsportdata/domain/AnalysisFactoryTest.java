package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalysisFactoryTest {
    private String name;
    private final AnalysisFactory test = new AnalysisFactory();
    private int power;
    private double lactate_one;
    private double lactate_two;
    private IAnalyser initMLSS;
    private IRampAnalyse initRamp;
    private DrawingGraph initGraph;
    private int heartrate;
    private int heartrateTwo;
    private int speed;
    private double weigth;
    private int size;
    private List<Integer> x = new ArrayList<>();
    private List<Integer> y= new ArrayList<>();
    
    @BeforeEach
    //given user when mlss input
    public void init() {
        name = "Julia";
        power = 200;
        lactate_one = 2.2;
        lactate_two = 3.3;
        heartrate = 142;
        initMLSS = test.createNewAnalysis(name, power, lactate_one, lactate_two, heartrate, weigth, size);
    }
    @BeforeEach
    //given user when Ramp data is put in
    public void initRamp() {
        speed = 30;
        heartrateTwo = 130;
        initRamp = test.createNewRamp(speed, heartrateTwo);

    }
    @BeforeEach
    //given user when Ramp data is submitted and create plot request is made
    public void initGraph() {
        x.add(30);
        x.add(50);
        y.add(100);
        y.add(150);
        initGraph = test.createNewGraph(x, y);
    }

    @Test
    void createNewAnalysisMLSSTest() {
        //then expect input to be used in domain (analyser.java)
        assertEquals(name, initMLSS.getUsername());
        assertEquals(power, initMLSS.getPower());
        assertEquals(lactate_one, initMLSS.getLactate_one());
        assertEquals(lactate_two, initMLSS.getLactate_two());
        assertEquals(heartrate, initMLSS.getHeartrate());
    }
    @Test
    void createNewRampTest() {
        //then expect input to be used in domain(RampAnalysis)
        assertEquals(speed, initRamp.getSpeed());
        assertEquals(heartrateTwo, initRamp.getHeartrate());
    }

    @Test
    void createNewGraphTest() {
        assertEquals(1, initGraph.getWidth());
        //cannot get into the constructor
    }
}
