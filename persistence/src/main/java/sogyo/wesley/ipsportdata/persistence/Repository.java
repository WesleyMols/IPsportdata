package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Repository implements IRepository{
    int power;
    List<String> arpower = new ArrayList<String>();
    Double lactate_one;
    Double lactate_two;
    Double lt_diff;
    String insertName;
    @Override
    public void MysqlSave(IAnalysor game) {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
            Statement statement = con.createStatement();
            //insert user input in table
            insertName = game.getUsername();             
            int insertDataP = game.getPower();
            double insertDataLT1 = game.getLactate_one();
            double insertDataLT2 = game.getLactate_two();
            double insertLt_diff = game.getCalcLactateDiff();
            String query = "INSERT INTO user_input (username, power, lactate_one, lactate_two, lt_diff) " + "VALUES (?,?,?,?,?)";
            PreparedStatement runqueryData = con.prepareStatement(query);
            runqueryData.setString(1, insertName);
            runqueryData.setInt(2, insertDataP);
            runqueryData.setDouble(3, insertDataLT1);
            runqueryData.setDouble(4, insertDataLT2);
            runqueryData.setDouble(5, insertLt_diff);
            runqueryData.execute();
           
            }catch(Exception e){ System.out.println(e);}
        }

    @Override
    public void MysqlGet(IAnalysor game) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
            Statement statement = con.createStatement();
            //set username for view
            String setQuery = "set @username := ?";
            PreparedStatement setname = con.prepareStatement(setQuery);
            setname.setString(1, insertName);
            setname.execute();
            //create view with input
            CallableStatement callableStatement = con.prepareCall("{call create_view()}" );
            callableStatement.execute();
            //select view
            String queryView = "SELECT * FROM db_ip_wesley.output;";
            ResultSet rs = statement.executeQuery(queryView);
            while(rs.next()){
                power = rs.getInt(1);
                arpower.add(0,String.valueOf(power));       
                lactate_one = rs.getDouble(2);
                lactate_two = rs.getDouble(3);
                lt_diff = rs.getDouble(4);
            }
            System.out.println(arpower);
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
