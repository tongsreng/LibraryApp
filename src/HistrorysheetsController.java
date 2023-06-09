package samples.db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;

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
    void search(ActionEvent event) {

    }

}

