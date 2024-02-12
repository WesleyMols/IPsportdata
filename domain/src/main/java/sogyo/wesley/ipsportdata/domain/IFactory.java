package sogyo.wesley.ipsportdata.domain;

public interface IFactory {
    IAnalysor createNewAnalysis(String name, int power, double lactate_one, double lactate_two);
}