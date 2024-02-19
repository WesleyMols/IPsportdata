package sogyo.wesley.ipsportdata.domain;

public interface IFactory {
    IAnalyser createNewAnalysis(String name, int power, double lactate_one, double lactate_two, int heartrate);
}