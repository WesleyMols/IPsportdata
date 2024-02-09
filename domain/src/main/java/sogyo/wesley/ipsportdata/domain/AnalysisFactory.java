package sogyo.wesley.ipsportdata.domain;

public class AnalysisFactory implements IFactory {

    @Override
    public IAnalysor createNewAnalysis(int power, double lactate_one, double lactate_two) {
        return new Analysor(power, lactate_one, lactate_two);
    }

    @Override
    public IAnalysor createNewAnalysis(String name){
        return new Analysor(name);
    }

  }
  