package sogyo.wesley.ipsportdata.persistence;
import java.sql.*;
public class MysqlCon {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ip_wesley", "root", "11BHL>WAX:tv");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from datamlss");
            while (resultSet.next()) 
                System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  ");  
                con.close();  
            }catch(Exception e){ System.out.println(e);} 
    }
}
