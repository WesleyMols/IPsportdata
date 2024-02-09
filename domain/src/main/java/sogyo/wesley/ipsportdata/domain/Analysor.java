package sogyo.wesley.ipsportdata.domain;

public class Analysor implements IAnalysor {
    String name = "";
    int power;
    double lactate_one;
    double lactate_two;
    double lt_diff;
    boolean isEnd;

    public Analysor(String name) {
        this.name = name;
    }

    public Analysor(int power2, double lactate_one2, double lactate_two2) {
        this.power = power2;
        this.lactate_one = lactate_one2;
        this.lactate_two = lactate_two2;
        calcLactateDiff();
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public double getLactate_two() {
        return lactate_two;
    }

    @Override
    public double getLactate_one() {
        return lactate_one;
    }

    public double calcLactateDiff() {
        lt_diff = lactate_two - lactate_one;
        return lt_diff;
    }

    public boolean isAnalysisEnd() {   
        if(lt_diff > 1) {
            isEnd = true;
        } else {
            isEnd = false;
        }
        return isEnd;
    }
}
