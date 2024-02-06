package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

import java.sql.*;


// a hashmap instead of DB to store data as key-value pairs

public class Repository implements IRepository{
  
    @Override
    public void MysqlCon(IAnalysor game) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from datamlss");
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
            System.out.println("endUserStorage");
            
                //con.close();  // this leads to exception nested exception
            }catch(Exception e){ System.out.println(e);}

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
            //Statement statement = con.createStatement();
            int insertDataP = game.getPower();
            float insertDataLT1 = game.getLactate_one();
            float insertDataLT2 = game.getLactate_two();
            String query = "INSERT INTO datamlss (power, lactate_one, lactate_two) " + "VALUES (?,?,?)";
            //ResultSet resultsetData = statement.executeQuery(query);
            PreparedStatement runqueryData = con.prepareStatement(query);
            runqueryData.setInt(1, insertDataP);
            runqueryData.setFloat(2, insertDataLT1);
            runqueryData.setFloat(3, insertDataLT2);
            runqueryData.execute();
        }catch(Exception e){ System.out.println(e);}
    }
    
    
}
