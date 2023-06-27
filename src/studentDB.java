import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class studentDB {
    public static Connection getConnection() throws SQLException{
        String Url = "jdbc:sqlite:/D:/ITC/I3/SreypichTO/LibraryApp/DBstudent.db";
        Connection connection = DriverManager.getConnection(Url) ;
        return connection ;
    }
}
