package sogyo.wesley.ipsportdata.domain;

public class Analysor implements IAnalysor {
    String name = "";
    String power = "";
    float lactate_one;
    float lactate_two;

    public Analysor(String name) {
        this.name = name;
    }

    public Analysor(String power, float lactate_one, float lactate_two) {
        this.power = power;
        this.lactate_one = lactate_one;
        this.lactate_two = lactate_two;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public Object getPower() {
        return power;
    }

    @Override
    public Object getLT2() {
        return lactate_two;
    }

    @Override
    public Object getLT1() {
        return lactate_one;
    }
}
