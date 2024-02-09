package sogyo.wesley.ipsportdata.domain;

public interface IFactory {
    IAnalysor createNewAnalysis(int power, double lactate_one, double lactate_two);
    IAnalysor createNewAnalysis(String name);
}