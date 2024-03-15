package sogyo.wesley.ipsportdata.domain;

public interface IFactory {
    IAnalyser createNewAnalysis(String name, int power, double lactate_one, double lactate_two, int heartrate, double weigth, int size);

    IRampAnalyse createNewRampTest(int speed, int heartrate);
    
    DrawingGraph createNewGraph();
}