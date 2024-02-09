package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

import java.sql.*;


// a hashmap instead of DB to store data as key-value pairs

public class Repository implements IRepository{
  
    @Override
    public void MysqlCon(IAnalysor game) {
        ResultSet resultSet;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
            Statement statement = con.createStatement();
            
            resultSet = statement.executeQuery("select * from datamlss");
            while (resultSet.next()) 
                System.out.println(resultSet.getInt(1)+"  "
                                    +resultSet.getString(2)+"  "
                                    +resultSet.getString(3)+"  "
                                    +resultSet.getString(4)+"  "
                                    +resultSet.getString(5)+"  "
                                    +resultSet.getString(6)+"  "
                                    +resultSet.getString(7)+"  ");
            
            String insert = game.getUsername().toString();
            String query = "INSERT INTO user (username) " + "VALUES (?)";
            PreparedStatement runquery = con.prepareStatement(query);
            runquery.setString(1, insert);
            runquery.execute();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            System.out.println("endUserStorage");
             
            int insertDataP = game.getPower();
            double insertDataLT1 = game.getLactate_one();
            double insertDataLT2 = game.getLactate_two();
            resultSet = statement.getGeneratedKeys();
            int insertNameId = 2;
            query = "INSERT INTO datamlss (power, lactate_one, lactate_two) " + "VALUES (?,?,?)";
            //ResultSet resultsetData = statement.executeQuery(query);
            PreparedStatement runqueryData = con.prepareStatement(query);
            runqueryData.setInt(1, insertDataP);
            runqueryData.setDouble(2, insertDataLT1);
            runqueryData.setDouble(3, insertDataLT2);
            //runqueryData.setInt(4, insertNameId);
            runqueryData.execute();  
        }catch(Exception e){ System.out.println(e);}
    }
    @Override
    public void MysqlCon(IAnalysor game, String id) {
        try {
           /*  Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
            Statement statement = con.createStatement();
            String
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            int insertDataP = game.getPower();
            float insertDataLT1 = game.getLactate_one();
            float insertDataLT2 = game.getLactate_two();
            ResultSet resultSet = statement.getGeneratedKeys();
            int insertNameId = 1;
            String query = "INSERT INTO datamlss (power, lactate_one, lactate_two, name_id) " + "VALUES (?,?,?,?)";
            //ResultSet resultsetData = statement.executeQuery(query);
            PreparedStatement runqueryData = con.prepareStatement(query);
            runqueryData.setInt(1, insertDataP);
            runqueryData.setFloat(2, insertDataLT1);
            runqueryData.setFloat(3, insertDataLT2);
            runqueryData.setInt(4, insertNameId);
            runqueryData.execute();  */
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
