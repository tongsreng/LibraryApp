package AllDesign;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class borrowingController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField Book_ID1;

    @FXML
    private DatePicker Borrowdate;

    @FXML
    private DatePicker Due_Date;

    @FXML
    private TextField First_name;

    @FXML
    private TextField Last_name;

    @FXML
    private TextField StudentID;

    @FXML
    private Button Submit;

    @FXML
    private TextField phone;

    public void switchToGUI(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    

}
    @FXML
    void switchToBorrow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/borrowing.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }
}