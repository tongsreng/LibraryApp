package AllDesign;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AfterCopyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void switchToGUI(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }

    @FXML
    void initialize() {

    }

}

