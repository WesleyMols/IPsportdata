package sogyo.wesley.ipsportdata.domain;

import java.util.ArrayList;
import java.util.List;

public class Analyser implements IAnalyser {
    String name;
    int power;
    double lactate_one;
    double lactate_two;
    double lt_diff;
    boolean isEnd;
    String outputMessage;
    List<String> powerInputList =new ArrayList<>(2);
    int heartrate;
    int MLSSPower;
    List<Integer> lastTwoPowerList = new ArrayList<>();

    @Override
    public List<String> getPowerInputList() {
        return powerInputList;
    }

    @Override
    public void setPowerInputList(List<String> powerInputList) {
        this.powerInputList = powerInputList;
    }


    public Analyser(String name, int power2, double lactate_one2, double lactate_two2, int heartrate) {
        this.name = name;
        this.power = power2;
        this.lactate_one = lactate_one2;
        this.lactate_two = lactate_two2;
        this.heartrate = heartrate;
        getCalcLactateDifference();

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

    public List<Integer> getLastTwoPowerList() {
        return lastTwoPowerList;
    }
    public void setLastTwoPowerList() {
        lastTwoPowerList.add(Integer.parseInt(powerInputList.get(powerInputList.size()-1)));
        lastTwoPowerList.add(Integer.parseInt(powerInputList.get(powerInputList.size()-2)));
    }
        
    public void setAverageMLSSPower() {
       
        MLSSPower = (lastTwoPowerList.get(0) + lastTwoPowerList.get(1)) /2;
    }
    public int getAverageMLSSPower() {
        return MLSSPower;
    }

    public String getOutputAnalysis() {
        isAnalysisEnd();
        if(isEnd==true) {
            outputMessage = String.format("Your MLSS power lies between : %s watt and %s watt. With an average of %d", powerInputList.get(powerInputList.size()-2), powerInputList.get(powerInputList.size()-1), MLSSPower);
            return outputMessage;
            } else {
            outputMessage = "Please input next measurement";
            return outputMessage;
        }
    
    }

    @Override
    public int getHeartrate() {
        return heartrate;
    }
}
