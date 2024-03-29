package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalyser;
import sogyo.wesley.ipsportdata.domain.IRampAnalyse;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Repository implements IRepository{
    int insertDataP;
    ArrayList<String> arrayPower = new ArrayList<String>();
    Double insertDataLT1;
    Double insertDataLT2;
    Double insertLt_diff;
    int insertHeartRate;
    String insertName;
    double insertweight;
    int size;
    List<String> returnpower = new ArrayList<>();
    List<Integer> returnRampSpeed = new ArrayList<>();
    List<Integer> returnRampHeartrate = new ArrayList<>();

    private  HashMap<String, IRampAnalyse> MockStorage = new HashMap<String, IRampAnalyse>();

    @Override
    public void MysqlSave(IAnalyser analyser) {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "password");
            //insert user input in table
            insertName = analyser.getUsername();             
            insertDataP = analyser.getPower();
            insertDataLT1 = analyser.getLactate_one();
            insertDataLT2 = analyser.getLactate_two();
            insertLt_diff = analyser.getCalcLactateDifference();
            insertHeartRate = analyser.getHeartrate();
            insertweight = analyser.getWeight();
            size = analyser.getSize();
            String query = "INSERT INTO user_input (username, power, lactate_one, lactate_two, lt_diff, heart_rate, weight, size) " + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement runqueryData = con.prepareStatement(query);
            runqueryData.setString(1, insertName);
            runqueryData.setInt(2, insertDataP);
            runqueryData.setDouble(3, insertDataLT1);
            runqueryData.setDouble(4, insertDataLT2);
            runqueryData.setDouble(5, insertLt_diff);
            runqueryData.setInt(6, insertHeartRate);
            runqueryData.setDouble(7, insertweight);
            runqueryData.setInt(8, size);
            runqueryData.execute();
           
            }catch(Exception e){ System.out.println(e);}
        }

    @Override
    public List<String> MysqlGet(IAnalyser analyser) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "password");
            Statement statement = con.createStatement();
            //set username for view
            String setNameQuery = "set @username := ?";
            PreparedStatement setnameStatement = con.prepareStatement(setNameQuery);
            setnameStatement.setString(1, insertName);
            setnameStatement.execute();
            //create view with input
            CallableStatement callViewStatement = con.prepareCall("{call create_view()}" );
            callViewStatement.execute();
            //select view
            String queryView = "SELECT * FROM db_ip_wesley.output;";
            ResultSet rs = statement.executeQuery(queryView);
            while(rs.next()){
                insertDataP = rs.getInt(1);
                arrayPower.add(arrayPower.size(),String.valueOf(insertDataP));
            }
            returnpower.add(arrayPower.get(arrayPower.size()-1));
        } catch (Exception e) {
            System.out.println(e);
        }
        return returnpower;
    }

    @Override
    public void RampSave(String key, IRampAnalyse input) {
        MockStorage.put(key, input);
        returnRampSpeed.add(input.getSpeed());
        returnRampHeartrate.add(input.getHeartrate());
    }

    @Override
    public IRampAnalyse RampGet(String key) {
        return MockStorage.get(key);
    }
    @Override
    public List<Integer> getRampSpeed() {
        return returnRampSpeed;
    }
    @Override
    public List<Integer> getRampHeartrate() {
        return returnRampHeartrate;
    }
}
