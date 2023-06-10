

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HistrorysheetsController {
    @FXML
    private Button Books;

    @FXML
    private TableColumn<?, ?> Booksname;

    @FXML
    private Button Home;

    @FXML
    private Button Newborrowing;

    @FXML
    private Button Newreturn;

    @FXML
    private Tab Overdue;

    @FXML
    private Button Search;

    @FXML
    private TableColumn<?, ?> bID;

    @FXML
    private Tab due;

    @FXML
    private TableColumn<?, ?> duedate;

    @FXML
    private TableColumn<?, ?> dueedate;

    @FXML
    private TableColumn<?, ?> phone;

    @FXML
    private TableColumn<?, ?> sta;

    
    @FXML
    void newborrow(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("borrowing.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage Stage = new Stage();
                Stage.initStyle(StageStyle.TRANSPARENT);
            Stage.setTitle("Borrowing");
            Stage.setScene(new Scene(root1));
            Stage.show();
        } catch (Exception e){
            System.out.println("Can't load new window");
        }
    }
    @FXML
    void search(ActionEvent event) {

    }
    

}

