package sogyo.wesley.ipsportdata.domain;

public class AnalysisFactory implements IFactory {

    @Override
    public IAnalysor createNewAnalysis(String name, int power, double lactate_one, double lactate_two) {
        return new Analysor(name, power, lactate_one, lactate_two);
    }
}
