import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    
    @FXML
    private DatePicker datePick;

    @FXML
    private Label labelRegis;

    @FXML
    private TextField putAdd;

    @FXML
    private TextField putCont;

    @FXML
    private TextField putDep;

    @FXML
    private TextField putEmauil;

    @FXML
    private TextField putGender;

    @FXML
    private TextField putID;

    @FXML
    private TextField putName;

    @FXML
    void switchToStudentList(ActionEvent event) throws IOException{   // Register btn
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/Student lists.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }

    @FXML
  
    void switchToLogin(ActionEvent event) throws IOException {
        //System.out.println("THIS IS BACK BTN................");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/login.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }
   // After regist information 
    //    void switchToListbook(ActionEvent event) throws IOException {
    //     String title = addTitle.getText();
    //     String genre = addGenre.getText();
    //     String author = addAuthor.getText();
    //     String qty = addQty.getText();
    //     String publish = addPublish.getText();
    //     String date;
    //     if(addDate.getValue() != null){
    //         date = addDate.getValue().toString();
    //     }else{
    //         Alert alert = new Alert(AlertType.WARNING);
    //         alert.setTitle("Fail");
    //         alert.setHeaderText(null);
    //         alert.setContentText("Please input all fields!!!!!");
    //         alert.showAndWait();
    //         return;
    //     }
    //     System.out.println("kfdskfj f=d=fdf=="+title+ " ====fdksfjsdkfksdf");
    //     if (title.equals("") ||  genre.equals("") || genre.equals("") || author.equals("")|| qty.equals("") || publish.equals("") ) {
    //         Alert alert = new Alert(AlertType.WARNING);
    //         alert.setTitle("Fail");
    //         alert.setHeaderText(null);
    //         alert.setContentText("Please input all fields!!");
    //         alert.showAndWait();
    //     } else {
    //         try (Connection conn = bookDB.getConnection()) {
    //             String sqlInsert = "INSERT INTO `Book`(`Title`, `Genre`, `Author`, `PublishDate`, `ImportDate` ,`QTY`) VALUES (?,?,?,?,?,?)";
    //             PreparedStatement statement = conn.prepareStatement(sqlInsert);
    //             statement.setString(1, title);
    //             statement.setString(2, genre);
    //             statement.setString(3, author);
    //             statement.setString(4, publish);
    //             statement.setString(5, date);
    //             statement.setString(6, qty);

    //             int rowsInserted = statement.executeUpdate();
    //             if (rowsInserted > 0) {
    //                 Alert alert = new Alert(AlertType.INFORMATION);
    //                 alert.setTitle("DONE!! ");
    //                 alert.setHeaderText(null);
    //                 alert.setContentText("Insert success.");
    //                 alert.showAndWait();

    //                 FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/BOOK.fxml"));
    //                 Parent welcomeParent = loader.load();
    //                 Scene welcomeScene = new Scene(welcomeParent);

    //                 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //                 window.setScene(welcomeScene);
    //                 window.show();

    //             } else {
    //                 Alert alert = new Alert(AlertType.WARNING);
    //                 alert.setTitle("Fail");
    //                 alert.setHeaderText(null);
    //                 alert.setContentText("Fail insert!!");
    //                 alert.showAndWait();
    //             }

    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //             Alert alert = new Alert(AlertType.WARNING);
    //             alert.setTitle("Fail");
    //             alert.setHeaderText(null);
    //             alert.setContentText("Fail insert!!");
    //             alert.showAndWait();
    //         }
    //     }
    // }


}

