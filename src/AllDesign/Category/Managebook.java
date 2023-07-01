package AllDesign.Category;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Managebook {

    @FXML
    private TextField bauthortxt;

    @FXML
    private TextField bcategorytxt;

    @FXML
    private TextField bidtxt;

    @FXML
    private TextField bnametxt;

    @FXML
    private TextField breleasetxt;

    @FXML
    void gotoGUI(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

}
