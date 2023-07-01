package AllDesign.Admin;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class AdminSQlConnect{
    public static Connection getConnection() throws SQLException{

        String Url = "jdbc:sqlite:/D:/Introduction/LibraryApp/DBadmin.db";
        Connection connection = DriverManager.getConnection(Url);
        return connection;
        
    }
}


