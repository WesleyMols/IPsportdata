package sogyo.wesley.ipsportdata.app;

public class InputDTO {
    private String username;
    private int power;
    private double lactate_one;
    private double lactate_two;
    private double lt_diff;
    private int heartrate;
    private double weight;
    private int size;
    
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getLactate_one() {
        return lactate_one;
    }

    public void setLactate(double lactate_one) {
        this.lactate_one = lactate_one;
    }

    public double getLactate_two() {
        return lactate_two;
    }

    public void setLactateTwo(double lactate_two) {
        this.lactate_two = lactate_two;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLt_diff() {
        return lt_diff;
    }

    public void setLt_diff(double lt_diff) {
        this.lt_diff = lt_diff;
    }
    public int getHeartrate() {
        return heartrate;
    }
    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
