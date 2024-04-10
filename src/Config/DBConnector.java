package Config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
     final private Connection cn;
     
     public DBConnector() throws SQLException{
        cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kits","root","");
    }
    
    public ResultSet getData(String sql) throws SQLException{
        return cn.createStatement().executeQuery(sql);
    }
    
     public Connection getConnection() throws SQLException{
        return cn;
    }
    
}
