package AllDesign.Books;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// public class BOOKv2Controller {

//     @FXML
//     private Button AddBookBtn;

//     @FXML
//     private Button DeleteBookBtn;

//     @FXML
//     private TableColumn<?, ?> ImportDate;

//     @FXML
//     private TextField addAuthor;

//     @FXML
//     private DatePicker addDate;

//     @FXML
//     private TextField addGenre;

//     @FXML
//     private TextField addID;

//     @FXML
//     private TextField addPublish;

//     @FXML
//     private TextField addQty;

//     @FXML
//     private TextField addTitle;

//     @FXML
//     private TableColumn<?, ?> author;

//     @FXML
//     private Button backBTN;

//     @FXML
//     private TableColumn<?, ?> borrowing;

//     @FXML
//     private TableColumn<?, ?> genreBook;

//     @FXML
//     private TableColumn<?, ?> idbook;

//     @FXML
//     private TableView<?> listPane;

//     @FXML
//     private TableColumn<?, ?> publish;

//     @FXML
//     private TableColumn<?, ?> qty;

//     @FXML
//     private AnchorPane tableViewList;

//     @FXML
//     private TableColumn<?, ?> titlbook;

//     @FXML
//     private TextField txtborrow;

//     @FXML
//     private Button updatebtn;

//     @FXML
//     void autoGenerate(MouseEvent event) {

//     }
//     @FXML
//     void switchToHome(ActionEvent event) throws IOException{
//         System.out.println("fdsfjkdsfjdfk");
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
//         Parent welcomeParent = loader.load();
//         Scene welcomeScene = new Scene(welcomeParent);
//         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         window.setScene(welcomeScene);
//         window.show();

//     }

//     // void handleAddBK(ActionEvent event) throws IOException {
//     //     String title = addTitle.getText();
//     //     String type = addGenre.getText();
//     //     String author = addAuthor.getText();
//     //     String qty = addQty.getText();
//     //     String borrowing = txtborrow.getText();
//     //     String publish = addPublish.getText();
//     //     String date;

//     //     if(addDate.getValue() != null){
//     //         date = addDate.getValue().toString();
//     //     }else{
//     //         Alert alert = new Alert(AlertType.WARNING);
//     //         alert.setTitle("Fail!!!");
//     //         alert.setHeaderText(null);
//     //         alert.setContentText("Please input all field.");
//     //         alert.showAndWait();
//     //         return;
//     //     }
//     //     try(Connection conn = bookDB.getConnection()){
//     //         String sql = "INSERT INTO `Bookv2`(`btitle`, `bgenre`, `bAuthor`, `bQTY`, `borrowing` ,`import`,`publish`) VALUES (?,?,?,?,?,?,?)";
//     //         PreparedStatement pst = conn.prepareStatement(sql);
//     //         pst.setString(1, title );
//     //         pst.setString(2, type);
//     //         pst.setString(3, author);
//     //         pst.setString(4, qty);
//     //         pst.setString(5, borrowing);
//     //         pst.setString(6, publish);              
//     //         pst.setString(7, date);
            
//     //         int CountRow = pst.executeUpdate();
//     //         if(CountRow >0){
//     //             System.out.println("Insert DONE...");
//     //             // Alert alert = new Alert(AlertType.INFORMATION);
//     //             // alert.setTitle("** Saved **");
//     //             // alert.setHeaderText(null);
//     //             // alert.setContentText("Insert Success.");
//     //             // alert.showAndWait();

//     //             // FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/BOOKv2.fxml"));
//     //             // Parent welComeParent = loader.load();
//     //             // Scene welScene = new Scene(welComeParent);
//     //             // Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//     //             // window.setScene(welScene);
//     //             // window.show();
            
//     //         }else{
//     //             Alert alert = new Alert(AlertType.WARNING);
//     //             alert.setTitle("!! Fail !!");
//     //             alert.setHeaderText(null);
//     //             alert.setContentText("Fail insert!!  (1)");
//     //             alert.showAndWait();
//     //         }

//     //     } catch (SQLException e) {
//     //         // TODO: handle exception
//     //         e.printStackTrace();
//     //         Alert alert = new Alert(AlertType.WARNING);
//     //         alert.setTitle("Fail");
//     //         alert.setHeaderText(null);
//     //         alert.setContentText("Fail insert");
//     //         alert.showAndWait();
//     //     }
//     // }

//}
public class BOOKv2Controller {

    @FXML
    private Button AddBookBtn;

    @FXML
    private Button DeleteBookBtn;

    @FXML
    private TableColumn<?, ?> ImportDate;

    @FXML
    private TextField addAuthor;

    @FXML
    private DatePicker addDate;

    @FXML
    private TextField addGenre;

    @FXML
    private TextField addID;

    @FXML
    private TextField addPublish;

    @FXML
    private TextField addQty;

    @FXML
    private TextField addTitle;

    @FXML
    private TableColumn<?, ?> author;

    @FXML
    private Button backBTN;

    @FXML
    private TableColumn<?, ?> borrowing;

    @FXML
    private TableColumn<?, ?> genreBook;

    @FXML
    private TableColumn<?, ?> idbook;

    @FXML
    private TableView<?> listPane;

    @FXML
    private TableColumn<?, ?> publish;

    @FXML
    private TableColumn<?, ?> qty;

    @FXML
    private AnchorPane tableViewList;

    @FXML
    private TableColumn<?, ?> titlbook;

    @FXML
    private TextField txtborrow;

    @FXML
    private Button updatebtn;

    @FXML
    void autoGenerate(MouseEvent event) throws SQLException {
         int id = 0;
        Connection conn = bookDB.getConnection();
        String sql = "SELECT * FROM Bookv2";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            id = rs.getInt("bid") + 1;
        }
        String convert = Integer.toString(id);
        addID.setText(convert);
    }

    @FXML
    void handleAddBK(ActionEvent event) {
                String title = addTitle.getText();
        String type = addGenre.getText();
        String author = addAuthor.getText();
        String qty = addQty.getText();
        String borrowing = txtborrow.getText();
        String publish = addPublish.getText();
        String date;

        if(addDate.getValue() != null){
            date = addDate.getValue().toString();
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fail!!!");
            alert.setHeaderText(null);
            alert.setContentText("Please input all field.");
            alert.showAndWait();
            return;
        }
        try(Connection conn = bookDB.getConnection()){
            String sql = "INSERT INTO `Bookv2`(`btitle`, `bgenre`, `bAuthor`, `bQTY`, `borrowing` ,`import`,`publish`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, title );
            pst.setString(2, type);
            pst.setString(3, author);
            pst.setString(4, qty);
            pst.setString(5, borrowing);
            pst.setString(6, publish);              
            pst.setString(7, date);
            
            int CountRow = pst.executeUpdate();
            if(CountRow >0){
                System.out.println("Insert DONE...");
                // Alert alert = new Alert(AlertType.INFORMATION);
                // alert.setTitle("** Saved **");
                // alert.setHeaderText(null);
                // alert.setContentText("Insert Success.");
                // alert.showAndWait();

                // FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/BOOKv2.fxml"));
                // Parent welComeParent = loader.load();
                // Scene welScene = new Scene(welComeParent);
                // Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // window.setScene(welScene);
                // window.show();
            
            }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("!! Fail !!");
                alert.setHeaderText(null);
                alert.setContentText("Fail insert!!  (1)");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("Fail insert");
            alert.showAndWait();
        }
    }

    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        System.out.println("fdsfjkdsfjdfk");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

}

