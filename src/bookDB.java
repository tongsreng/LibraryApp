import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class bookDB {
    public static Connection getConnection() throws SQLException{
        String Url = "jdbc:sqlite:/D:/ITC/I3/SreypichTO/LibraryApp/DBLibrary.db";
        Connection connection = DriverManager.getConnection(Url) ;
        return connection ;
    }

}
