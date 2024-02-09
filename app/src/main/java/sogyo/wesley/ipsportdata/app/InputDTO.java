package sogyo.wesley.ipsportdata.app;

public class InputDTO {
    private String username;
    private int power;
    private float lactate_one;
    private float lactate_two;
    private float lt_diff = 100;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getLactate_one() {
        return lactate_one;
    }

    public void setLactate(float lactate_one) {
        this.lactate_one = lactate_one;
    }

    public float getLactate_two() {
        return lactate_two;
    }

    public void setLactateTwo(float lactate_two) {
        this.lactate_two = lactate_two;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getLt_diff() {
        return lt_diff;
    }

    public void setLt_diff(float lt_diff){
        this.lt_diff = lt_diff;
    }
    
}
