package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Repository implements IRepository{
    int power;
    ArrayList<String> arrayPower = new ArrayList<String>();
    Double lactate_one;
    Double lactate_two;
    Double lt_diff;
    int heartrate;
    String insertName;
    List<String> array_lt_diff = new ArrayList<>();
    List<String> returnpower = new ArrayList<>();
    @Override
    public void MysqlSave(IAnalysor game) {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
            //insert user input in table
            insertName = game.getUsername();             
            int insertDataP = game.getPower();
            double insertDataLT1 = game.getLactate_one();
            double insertDataLT2 = game.getLactate_two();
            double insertLt_diff = game.getCalcLactateDifference();
            int insertHeartRate = game.getHeartrate();
            String query = "INSERT INTO user_input (username, power, lactate_one, lactate_two, lt_diff, heart_rate) " + "VALUES (?,?,?,?,?,?)";
            PreparedStatement runqueryData = con.prepareStatement(query);
            runqueryData.setString(1, insertName);
            runqueryData.setInt(2, insertDataP);
            runqueryData.setDouble(3, insertDataLT1);
            runqueryData.setDouble(4, insertDataLT2);
            runqueryData.setDouble(5, insertLt_diff);
            runqueryData.setInt(6, insertHeartRate);
            runqueryData.execute();
           
            }catch(Exception e){ System.out.println(e);}
        }

    @Override
    public List<String> MysqlGet(IAnalysor game) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
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
                power = rs.getInt(1);
                arrayPower.add(arrayPower.size(),String.valueOf(power));
            }
            returnpower.add(arrayPower.get(arrayPower.size()-1));
        } catch (Exception e) {
            System.out.println(e);
        }
        return returnpower;
    }    
}
