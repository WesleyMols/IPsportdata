package sogyo.wesley.ipsportdata.domain;

import java.util.ArrayList;
import java.util.List;

public class Analysor implements IAnalysor {
    String name;
    int power;
    double lactate_one;
    double lactate_two;
    double lt_diff;
    boolean isEnd;
    String outputMessage;
    List<String> powerInputList =new ArrayList<>(2);
    int heartrate;

    @Override
    public List<String> getPowerInputList() {
        return powerInputList;
    }

    @Override
    public void setPowerInputList(List<String> powerInputList) {
        this.powerInputList = powerInputList;
    }


    public Analysor(String name, int power2, double lactate_one2, double lactate_two2, int heartrate) {
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
    
    public String getOutputAnalysis() {
        isAnalysisEnd();
        if(isEnd==true) {
            outputMessage = "Your MLSS power lies between: " + powerInputList.get(powerInputList.size()-2) +"watt and "+ powerInputList.get(powerInputList.size()-1) + " ";
            return outputMessage;
            } else {
            outputMessage = "please input next measurement";
            return outputMessage;
        }
    
    }

    @Override
    public int getHeartrate() {
        return heartrate;
    }
}
