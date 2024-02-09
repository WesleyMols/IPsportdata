package sogyo.wesley.ipsportdata.domain;

public class Analysor implements IAnalysor {
    String name = "";
    int power;
    float lactate_one;
    float lactate_two;
    float lt_diff;

    public Analysor(String name) {
        this.name = name;
    }

    public Analysor(int power2, float lactate_one2, float lactate_two2) {
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
    public float getLactate_two() {
        return lactate_two;
    }

    @Override
    public float getLactate_one() {
        return lactate_one;
    }

    public float calcLactateDiff() {
        lt_diff = lactate_one - lactate_two;
        return lt_diff;
    }
}
