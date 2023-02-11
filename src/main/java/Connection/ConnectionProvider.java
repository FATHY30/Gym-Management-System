package Connection;
import java.sql.*;
public class ConnectionProvider {
    public static Connection getCon()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gms","root","kimoKIMO12@");
            return con;
        }catch(Exception e)
        {
            return null;
        }
    }
}
