package sogyo.wesley.ipsportdata.domain;

import java.util.List;

public interface IAnalysor {
    String getUsername();

    int getPower();

    double getLactate_two();

    double getLactate_one();
    double getCalcLactateDiff();
    List<String> getResultList();
    void setResultList(List<String> resultList);
}
