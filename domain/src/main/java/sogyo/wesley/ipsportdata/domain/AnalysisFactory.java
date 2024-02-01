package sogyo.wesley.ipsportdata.domain;

public class AnalysisFactory implements IFactory {

    @Override
    public IAnalysor createNewAnalysis() {
        return (IAnalysor) new Analysor();
    }
    
}
