package AllDesign.Books;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class bookDB {
    public static Connection getConnection() throws SQLException{
        String Url = "jdbc:sqlite:C:/Users/ASUS ROG/Documents/ITC/FG/IPE/Ano/LibraryApp/DBLibrary.db";
        Connection connection = DriverManager.getConnection(Url) ;
        return connection ;
    }

    
    // public static ObservableList <listbookVariable> getDataBook() throws SQLException{
    //     Connection con = getConnection();
    //     ObservableList<listbookVariable> list = FXCollections.observableArrayList();
    
    //     try {
    //         PreparedStatement ps = con.prepareStatement("select*from Book");
    //         ResultSet rs = ps.executeQuery();
    //         while (rs.next()) {
    //             list.add(new listbookVariable(rs.getString("bid"),rs.getString("btitle") 
    //             , rs.getString("bgenre"), rs.getString("bAuthor"), rs.getString("bQTY")
    //             , rs.getString("borrowing"), rs.getString("import"), rs.getString("publish")));
    //         }
    //     } catch (Exception e) {    
    //     }
    //     return list;
    
    // }
    
}