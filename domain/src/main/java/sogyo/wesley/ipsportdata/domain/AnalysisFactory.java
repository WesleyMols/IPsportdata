package sogyo.wesley.ipsportdata.domain;

import java.util.List;

public class AnalysisFactory implements IFactory {

    @Override
    public IAnalyser createNewAnalysis(String name, int power, double lactate_one, double lactate_two, int heartrate, double weight, int size) {
        return new Analyser(name, power, lactate_one, lactate_two, heartrate, weight, size);
    }

    @Override
    public IRampAnalyse createNewRamp(int speed, int heartrate) {
        return new RampAnalysis(speed, heartrate);
    }

    @Override
    public DrawingGraph createNewGraph(List<Integer> x,  List<Integer> y) {
        return new DrawingGraph(x, y);
    }
}
