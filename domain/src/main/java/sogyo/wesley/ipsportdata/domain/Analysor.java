package sogyo.wesley.ipsportdata.domain;

import java.util.List;

public class Analysor implements IAnalysor {
    String name;
    int power;
    double lactate_one;
    double lactate_two;
    double lt_diff;
    boolean isEnd;
    String outputMessage;
    List<String> resultList;

    @Override
    public List<String> getResultList() {
        return resultList;
    }

    @Override
    public void setResultList(List<String> resultList) {
        this.resultList = resultList;
    }


    public Analysor(String name, int power2, double lactate_one2, double lactate_two2) {
        this.name = name;
        this.power = power2;
        this.lactate_one = lactate_one2;
        this.lactate_two = lactate_two2;
        getCalcLactateDiff();

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
    public double getCalcLactateDiff() {
        lt_diff = lactate_two - lactate_one;
        return lt_diff;
    }

    public boolean isAnalysisEnd() {   
        if(lt_diff > 1) {
           return isEnd = true;
        } else {
            return isEnd = false;
        }
       
    }

    public String getOutputAnalysis() {
        if(isEnd==true) {
            outputMessage = "Your MLSS power: " + power;
            return outputMessage;
            } else {
            outputMessage = "please input next measurement";
            return outputMessage;
        }
    
    } 
}
