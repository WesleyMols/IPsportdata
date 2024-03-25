package sogyo.wesley.ipsportdata.domain;

import java.util.List;

public interface IFactory {
    IAnalyser createNewAnalysis(String name, int power, double lactate_one, double lactate_two, int heartrate, double weight, int size);

    IRampAnalyse createNewRamp(int speed, int heartrate);
    
    DrawingGraph createNewGraph(List<Integer> x,  List<Integer> y);
}