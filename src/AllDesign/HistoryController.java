package AllDesign;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class HistoryController {
    private Stage stage;
    private Scene scene;
   

    @FXML
    private TableColumn<?, ?> BookID;

    @FXML
    private TableColumn<?, ?> BookID1;

    @FXML
    private Tab Borrowing;

    @FXML
    private TableColumn<?, ?> Duedate;

    @FXML
    private TableColumn<?, ?> Duedate1;

    @FXML
    private TableColumn<?, ?> First_name;

    @FXML
    private TableColumn<?, ?> First_name1;

    @FXML
    private TableColumn<?, ?> Last_name;

    @FXML
    private TableColumn<?, ?> Last_name1;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> Name1;

    @FXML
    private TableColumn<?, ?> Other;

    @FXML
    private TableColumn<?, ?> PhoneNumber;

    @FXML
    private TableColumn<?, ?> Phonenumber1;

    @FXML
    private Tab Return;

    @FXML
    private TableColumn<?, ?> Status;

    @FXML
    private TableColumn<?, ?> Staus1;

    @FXML
    private TableColumn<?, ?> StudentID;

    @FXML
    private TableColumn<?, ?> StudentID1;

    @FXML
    private Button back;

    private Parent root;

    @FXML

    public void switchToGUI(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
