
package AllDesign;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void switchToGUI(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        LoginAdmin loginAdmin = new LoginAdmin();
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean isLogin = loginAdmin.isLogin(email, password);

        if (isLogin) {
            System.out.println("login success");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
            Parent welcomeParent = loader.load();
            Scene welcomeScene = new Scene(welcomeParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(welcomeScene);
            window.show();
        } else {
            System.out.println("fail login ");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect Email or Password");
            alert.showAndWait();
        }
    }

    @FXML
    void switchToregisterAdmin(ActionEvent event) throws IOException {
          
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/Register_Admin.fxml"));
                    Parent welcomeParent = loader.load();
                    Scene welcomeScene = new Scene(welcomeParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(welcomeScene);
                    window.show();
    }

}