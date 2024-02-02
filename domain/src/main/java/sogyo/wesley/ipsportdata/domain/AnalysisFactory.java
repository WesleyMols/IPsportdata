package sogyo.wesley.ipsportdata.domain;

public class AnalysisFactory implements IFactory {

    @Override
    public IAnalysor createNewAnalysis(String name) {
        return new Analysor(name);    
    }

   /*  @Override
    public int hashCode() {
        int result = 17;
        String name = "Julia";
        if (createNewAnalysis(name) != null) {
            result = 31 * result + createNewAnalysis(name).hashCode();
        }
        return result;
    }

     */
}
