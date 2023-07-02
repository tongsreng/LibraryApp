package AllDesign;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnector {
    public static Connection getSQLiteConnection() throws ClassNotFoundException, SQLException {
        String databasePath = "C:/Users/Techo/OneDrive/Documents/Coding/GIC/LibraryApp/DBadmin.db";
        Class.forName("org.sqlite.JDBC");

        // Define the SQLite database URL
        String url = "jdbc:sqlite:" + databasePath;

        // Establish a connection to the database
        return DriverManager.getConnection(url);
    }
}

   

