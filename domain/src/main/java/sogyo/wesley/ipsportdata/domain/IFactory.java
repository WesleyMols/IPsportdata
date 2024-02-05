package sogyo.wesley.ipsportdata.domain;

public interface IFactory {
    IAnalysor createNewAnalysis(String power, float lactate_one, float lactate_two);
    IAnalysor createNewAnalysis(String name);
}