package sogyo.wesley.ipsportdata.persistence;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

import java.sql.*;
import java.util.*;

// a hashmap instead of DB to store data as key-value pairs

public class Repository implements IRepository{
    private  HashMap<String, IAnalysor> database = new HashMap<String, IAnalysor>();

    @Override
    public void save(String key, IAnalysor game) {
        database.put(key, game);
    }

    @Override
    public IAnalysor get(String key) {
       return database.get(key);
    }

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
            //System.out.println(insert);
            System.out.println("end");
                //con.close();  // this leads to exception nested exception
            }catch(Exception e){ System.out.println(e);} 
    }
    
    
}
