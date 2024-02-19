package sogyo.wesley.ipsportdata.domain;

public class AnalysisFactory implements IFactory {

    @Override
    public IAnalyser createNewAnalysis(String name, int power, double lactate_one, double lactate_two, int heartrate) {
        return new Analyser(name, power, lactate_one, lactate_two, heartrate);
    }
}
