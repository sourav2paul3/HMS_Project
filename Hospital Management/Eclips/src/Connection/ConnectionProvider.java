package Connection;
import java.sql.*;
public class ConnectionProvider {
	public static Connection getCon()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mytables","root","301298");
            return con;
        }catch(Exception e)
        {
         return null;   
        }
    }

}