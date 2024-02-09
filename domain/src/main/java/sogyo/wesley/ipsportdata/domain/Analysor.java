package sogyo.wesley.ipsportdata.domain;

public class Analysor implements IAnalysor {
    String name = "";
    int power;
    double lactate_one;
    double lactate_two;
    double lt_diff;

    public Analysor(String name) {
        this.name = name;
    }

    public Analysor(int power2, double lactate_one2, double lactate_two2) {
        this.power = power2;
        this.lactate_one = lactate_one2;
        this.lactate_two = lactate_two2;
        lt_diff = lactate_one2 - lactate_two2;
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
        lt_diff = lactate_one - lactate_two;
        return lt_diff;
    }
}
