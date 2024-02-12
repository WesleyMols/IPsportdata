package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

import java.sql.*;

public class Repository implements IRepository{
  
    @Override
    public void MysqlCon(IAnalysor game) {
        ResultSet resultSet;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
            Statement statement = con.createStatement();
  
            String insertName = game.getUsername();             
            int insertDataP = game.getPower();
            double insertDataLT1 = game.getLactate_one();
            double insertDataLT2 = game.getLactate_two();
            double insertLt_diff = game.getCalcLactateDiff();
            String query = "INSERT INTO user_input (username, power, lactate_one, lactate_two, lt_diff) " + "VALUES (?,?,?,?,?)";
            //ResultSet resultsetData = statement.executeQuery(query);
            PreparedStatement runqueryData = con.prepareStatement(query);
            runqueryData.setString(1, insertName);
            runqueryData.setInt(2, insertDataP);
            runqueryData.setDouble(3, insertDataLT1);
            runqueryData.setDouble(4, insertDataLT2);
            runqueryData.setDouble(5, insertLt_diff);
            runqueryData.execute();

            resultSet = statement.executeQuery("select * from user_input");
            while (resultSet.next()) 
                System.out.println(resultSet.getInt(3)+"  "
                +resultSet.getString(2)+"  "
                +resultSet.getDouble(4)+"  "
                +resultSet.getDouble(5)+"  "
        
                );
        }catch(Exception e){ System.out.println(e);}
    }    
}
