package sogyo.wesley.ipsportdata.domain;

public class AnalysisFactory implements IFactory {

    @Override
    public IAnalysor createNewAnalysis(String name) {
        return new Analysor(name);    
    }

  }
