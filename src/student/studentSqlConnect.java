package student;
// import java.sql.Connection;
// import java.sql.DriverManager;

// public class studentSqlConnect { //bookDB

//     public static Connection connectStdDB(){
//         Connection conn = null;
//         try {
//             // db parameter  //https://www.javatpoint.com/java-sqlite
//             String stdUrl = "jdbc:sqlite:/D:/ITC/I3/SreypichTO/LibraryApp/DBstudent.db";
//             System.out.println("Connection to SQLite has been established."); 
            
//             conn = DriverManager.getConnection(stdUrl);

//         } catch (Exception e) {

//             System.out.println("ERROR connecting to sqslite database!!!!"); 
//             e.printStackTrace();
//         }
//         return conn;
//     }

// }

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class studentSqlConnect {
    public static Connection getConnection() throws SQLException{
       String Url = "jdbc:sqlite:/D:/ITC/I3/SreypichTO/LibraryApp/DBstudent.db";
        Connection connection = DriverManager.getConnection(Url) ;
        return connection ;
    }

}