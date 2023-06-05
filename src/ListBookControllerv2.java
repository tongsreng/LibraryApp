import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListBookControllerv2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> author;

    @FXML
    private TableColumn<?, ?> bestSeller;

    @FXML
    private TableColumn<?, ?> genreBook;

    @FXML
    private TableColumn<?, ?> idbook;

    @FXML
    private TableView<?> listPane;

    @FXML
    private TableColumn<?, ?> publish;

    @FXML
    private TableColumn<?, ?> qty;

    @FXML
    private TableColumn<?, ?> titlbook;

  

    @FXML
    void initialize() {
        assert author != null : "fx:id=\"author\" was not injected: check your FXML file 'BOOK.fxml'.";
        assert bestSeller != null : "fx:id=\"bestSeller\" was not injected: check your FXML file 'BOOK.fxml'.";
        assert genreBook != null : "fx:id=\"genreBook\" was not injected: check your FXML file 'BOOK.fxml'.";
        assert idbook != null : "fx:id=\"idbook\" was not injected: check your FXML file 'BOOK.fxml'.";
        assert listPane != null : "fx:id=\"listPane\" was not injected: check your FXML file 'BOOK.fxml'.";
        assert publish != null : "fx:id=\"publish\" was not injected: check your FXML file 'BOOK.fxml'.";
        assert qty != null : "fx:id=\"qty\" was not injected: check your FXML file 'BOOK.fxml'.";
        assert titlbook != null : "fx:id=\"titlbook\" was not injected: check your FXML file 'BOOK.fxml'.";

    }

}