package AllDesign;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import AllDesign.Admin.AdminSQlConnect;

// import java.io.IOException;

// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Node;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.DatePicker;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.stage.Stage;

// public class ResgistAdminController  {

//     @FXML
//     private DatePicker DOBpicker;

//     @FXML
//     private Label labelRegis;

//     @FXML
//     private TextField putAdd;

//     @FXML
//     private TextField putAdd1;

//     @FXML
//     private TextField putAdd2;

//     @FXML
//     private TextField putCont;

//     @FXML
//     private TextField putDep;

//     @FXML
//     private TextField putEmauil;

//     @FXML
//     private TextField putGender;

//     @FXML
//     private TextField putID;

//     @FXML
//     private TextField putName;

//       @FXML
//     void switchToLogin(ActionEvent event) throws IOException {
//         //System.out.println("THIS IS BACK BTN................");
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/login.fxml"));
//         Parent welcomeParent = loader.load();
//         Scene welcomeScene = new Scene(welcomeParent);
//         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
//         window.setScene(welcomeScene);
//         window.show();
//     }

// }
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ResgistAdminController {

   @FXML
    private DatePicker DOBpicker;

    @FXML
    private Label labelRegis;

    @FXML
    private TextField putAdd;

    @FXML
    private PasswordField putAdd1;

    @FXML
    private PasswordField putAdd2;

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
    void autoGenerate(MouseEvent event) throws SQLException {
        int id = 0;
        Connection conn = AdminSQlConnect.getConnection();
        String sql = "SELECT * FROM Admin";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            id = rs.getInt("id") + 1;
        }
        String convert = Integer.toString(id);
        putID.setText(convert);
    }

    @FXML
    void switchToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/login.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }
    
    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        String id = putID.getText();
        String name = putName.getText();
        String gender = putGender.getText();
        String department = putDep.getText();
        String contact = putCont.getText();
        String address = putAdd.getText();
        String email = putEmauil.getText();
        String password = putAdd1.getText();
        String repassword = putAdd2.getText();
        
        String dateOfBirth;
        if(DOBpicker.getValue() != null){
            dateOfBirth = DOBpicker.getValue().toString();
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("Please input all fields!!!!!");
            alert.showAndWait();
            return;
        }


        if (name.equals("") ||  gender.equals("") || id.equals("") ||department.equals("") || contact.equals("")|| address.equals("") || email.equals("") || password.equals("") || repassword.equals("") ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("Please input all fields!!");
            alert.showAndWait();

        } else {
            try (Connection conn = AdminSQlConnect.getConnection()) {
                String sqlInsert = "INSERT INTO `Admin`(`id`, `name`, `gender`,`department` , `contact`,`address`,`email`,`dob`,`password`,`repassword`) VALUES (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = conn.prepareStatement(sqlInsert);
                statement.setString(1, id);
                statement.setString(2, name);
                statement.setString(3, gender);
                statement.setString(4, department);
                statement.setString(5, contact);
                statement.setString(6, address);
                statement.setString(7, email);
                statement.setString(8, dateOfBirth);                 
                statement.setString(9, password); 
                statement.setString(10, repassword); 
                System.out.println("hhhhhhhhhhhhhhhh");
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("** Saved ** ");
                    alert.setHeaderText(null);
                    alert.setContentText("Insert success.");
                    alert.showAndWait();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
                    Parent welcomeParent = loader.load();
                    Scene welcomeScene = new Scene(welcomeParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(welcomeScene);
                    window.show();
                    System.out.println("mmmmmmmmmmmmmmmmm");
                } else {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("!! Fail !!");
                    alert.setHeaderText(null);
                    alert.setContentText("Fail insert!!  (1)");
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Fail");
                alert.setHeaderText(null);
                alert.setContentText("Failllllllllllll insert ");
                alert.showAndWait();
            }
        }
    




        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
        // Parent welcomeParent = loader.load();
        // Scene welcomeScene = new Scene(welcomeParent);
        // Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        // window.setScene(welcomeScene);
        // window.show();
    }


}


