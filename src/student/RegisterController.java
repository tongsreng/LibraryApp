package student;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private DatePicker DOBpicker;

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
    void switchToLogin(ActionEvent event) throws IOException {
        //System.out.println("THIS IS BACK BTN................");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/login.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }
//   copied from AddBookController.java
    @FXML
    void autoGenerate(MouseEvent event) throws SQLException {
        int id = 0;
        Connection conn = studentSqlConnect.getConnection();
        String sql = "SELECT * FROM Admin";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            id = rs.getInt("sid") + 1;
        }
        String convert = Integer.toString(id);
        putID.setText(convert);
    }
    @FXML
    void switchToStudentList(ActionEvent event) throws IOException{   // Register btn
        String stname = putName.getText();
        String gender = putGender.getText();
        String stid = putID.getText();
         String department = putDep.getText();
        String address = putAdd.getText();
        String contact = putCont.getText();   
        String email = putEmauil.getText();
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


        if (stname.equals("") ||  gender.equals("") || stid.equals("") ||department.equals("") || address.equals("")|| contact.equals("") || email.equals("") ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("Please input all fields!!");
            alert.showAndWait();
        } else {
            try (Connection conn = studentSqlConnect.getConnection()) {
                String sqlInsert = "INSERT INTO `Student`(`sid`, `sname`, `department`,`sgender` , `DOB`,`Address`,`Email`,`Contact`) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement statement = conn.prepareStatement(sqlInsert);
                statement.setString(1, stid);
                statement.setString(2, stname);
                statement.setString(3, department);
                statement.setString(4, gender);
                statement.setString(5, dateOfBirth);
                statement.setString(6, address);
                statement.setString(7, email);
                statement.setString(8, contact);                 
                

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("** Saved ** ");
                    alert.setHeaderText(null);
                    alert.setContentText("Insert success.");
                    alert.showAndWait();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/AdminList.fxml"));
                    Parent welcomeParent = loader.load();
                    Scene welcomeScene = new Scene(welcomeParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(welcomeScene);
                    window.show();

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
                alert.setContentText("Fail insert ");
                alert.showAndWait();
            }
        }
    }
}

