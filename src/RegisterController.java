import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane PaneRegist;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnRegist;

    @FXML
    private Label labelRegis;

    @FXML
    private TextField putAdd;

    @FXML
    private TextField putCont;

    @FXML
    private TextField putDOB;

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
    private AnchorPane registerPane;

    @FXML
    void toBackFromRegis(ActionEvent event) {

    }

    @FXML
    void toRegis(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert PaneRegist != null : "fx:id=\"PaneRegist\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert btnRegist != null : "fx:id=\"btnRegist\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert labelRegis != null : "fx:id=\"labelRegis\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert putAdd != null : "fx:id=\"putAdd\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert putCont != null : "fx:id=\"putCont\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert putDOB != null : "fx:id=\"putDOB\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert putDep != null : "fx:id=\"putDep\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert putEmauil != null : "fx:id=\"putEmauil\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert putGender != null : "fx:id=\"putGender\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert putID != null : "fx:id=\"putID\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert putName != null : "fx:id=\"putName\" was not injected: check your FXML file 'Registering student.fxml'.";
        assert registerPane != null : "fx:id=\"registerPane\" was not injected: check your FXML file 'Registering student.fxml'.";

    }

}
