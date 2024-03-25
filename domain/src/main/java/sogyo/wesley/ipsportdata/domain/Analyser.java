package sogyo.wesley.ipsportdata.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Analyser implements IAnalyser {
    private String name;
    private int power;
    private double lactate_one;
    private double lactate_two;
    private double lt_diff;
    private double weight;
    private int size;
    private boolean isEnd;
    private String outputMessage;
    private List<String> powerInputList =new ArrayList<>(2);
    private int heartrate;
    private int MLSSPower;
    private int one;
    private int two;
    private double wattPerKg;
    private final double aerobeFactor = 0.72;
    private double aerobePower;
    private double speed;

    @Override
    public List<String> getPowerInputList() {
        return powerInputList;
    }

    @Override
    public void setPowerInputList(List<String> powerInputList) {
        this.powerInputList = powerInputList;
    }


    public Analyser(String name, int power2, double lactate_one2, double lactate_two2, int heartrate, double weight, int size) {
        this.name = name;
        this.power = power2;
        this.lactate_one = lactate_one2;
        this.lactate_two = lactate_two2;
        this.heartrate = heartrate;
        this.weight = weight;
        this.size = size;
        getCalcLactateDifference();
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getSize() {
        return size;
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

    @Override
    public double getCalcLactateDifference() {
        lt_diff = lactate_two - lactate_one;
        return lt_diff;
    }
    
    public boolean isAnalysisEnd() {   
        if(lt_diff > 1) {
           isEnd = true;
           return isEnd;
        } else {
            isEnd = false;
            return isEnd;
        }
       
    }
    @Override
    public double getWattPerKg() {
        getAverageMLSSPower();
        if(weight != 0) {
        wattPerKg = MLSSPower/weight;
        return wattPerKg;
        } else {
            return 0;
        }

    }

    @Override
    public int getAverageMLSSPower() {
        one = Integer.parseInt(powerInputList.get(powerInputList.size()-1));
        two = Integer.parseInt(powerInputList.get(powerInputList.size()-2));
        MLSSPower = (one+two) /2;
        return MLSSPower;
    }

    public String getOutputAnalysis() {
        isAnalysisEnd();
        if(isEnd==true) {
            outputMessage = String.format(Locale.GERMAN,"Your MLSS power lies between : %s watt and %s watt. With an average of %dwatt, or %2.1f watt/kg", powerInputList.get(powerInputList.size()-2), powerInputList.get(powerInputList.size()-1), MLSSPower, wattPerKg);
            return outputMessage;
            } else {
            outputMessage = "Please input next measurement";
            return outputMessage;
        }
    
    }

    public double getSpeedFromMLSSPower() {
        isAnalysisEnd();
        if(isEnd==true) {
        getAverageMLSSPower();
        speed = 15.96*Math.log(MLSSPower)-48.48;
        speed = round(speed, 2);
        return speed;
        } else {
            return 0;
        }
    }

    @Override
    public int getHeartrate() {
        return heartrate;
    }

    public double getAerobePower() {
        getAverageMLSSPower();
        aerobePower = MLSSPower*aerobeFactor;
        aerobePower = round(aerobePower,2);
        return aerobePower;
    }

    static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(Double.toString(value));
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
}
