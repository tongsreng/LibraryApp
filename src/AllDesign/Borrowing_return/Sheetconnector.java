package AllDesign.Borrowing_return;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class Sheetconnector {
    public static Connection getConnection() throws SQLException{
       String Url = "jdbc:sqlite:/C:/Users/ASUS ROG/Documents/ITC/FG/IPE/Ano/LibraryApp/DBBorrowing.db";
        Connection connection = DriverManager.getConnection(Url) ;
        return connection ;
    }

}

