package sogyo.wesley.ipsportdata.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Analyser implements IAnalyser {
    String name;
    int power;
    double lactate_one;
    double lactate_two;
    double lt_diff;
    double weigth;
    int size;
    boolean isEnd;
    String outputMessage;
    List<String> powerInputList =new ArrayList<>(2);
    int heartrate;
    int MLSSPower;
    List<Integer> lastTwoPowerList = new ArrayList<>();
    int one;
    int two;
    double wattPerKg;
    private double aerobeFactor = 0.72;
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


    public Analyser(String name, int power2, double lactate_one2, double lactate_two2, int heartrate, double weigth, int size) {
        this.name = name;
        this.power = power2;
        this.lactate_one = lactate_one2;
        this.lactate_two = lactate_two2;
        this.heartrate = heartrate;
        this.weigth = weigth;
        this.size = size;
        getCalcLactateDifference();
    }

    @Override
    public double getWeigth() {
        return weigth;
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
        wattPerKg = MLSSPower/weigth;
        return wattPerKg;
    }

    @Override
    public List<Integer> getLastTwoPowerList() {
        return lastTwoPowerList;
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
        getAverageMLSSPower();
        speed = 15.96*Math.log(MLSSPower)-48.48;
        return speed;
    }

    @Override
    public int getHeartrate() {
        return heartrate;
    }

    public double getAerobePower() {
        getAverageMLSSPower();
        aerobePower = MLSSPower*aerobeFactor;
        return aerobePower;
    }
}
