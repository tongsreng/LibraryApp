import com.gluonhq.charm.glisten.control.Icon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class List_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addbook;

    @FXML
    private Icon arrowBack;

    @FXML
    private TableColumn<?, ?> author;

    @FXML
    private TableColumn<?, ?> bestSeller;

    @FXML
    private TableColumn<?, ?> genreBook;

    @FXML
    private TableColumn<?, ?> idbook;

    @FXML
    private TableColumn<?, ?> publish;

    @FXML
    private TableColumn<?, ?> qty;

    @FXML
    private TableColumn<?, ?> titlbook;

    @FXML
    void initialize() {
        assert addbook != null : "fx:id=\"addbook\" was not injected: check your FXML file 'listBook_v2.fxml'.";
        assert arrowBack != null : "fx:id=\"arrowBack\" was not injected: check your FXML file 'listBook_v2.fxml'.";
        assert author != null : "fx:id=\"author\" was not injected: check your FXML file 'listBook_v2.fxml'.";
        assert bestSeller != null : "fx:id=\"bestSeller\" was not injected: check your FXML file 'listBook_v2.fxml'.";
        assert genreBook != null : "fx:id=\"genreBook\" was not injected: check your FXML file 'listBook_v2.fxml'.";
        assert idbook != null : "fx:id=\"idbook\" was not injected: check your FXML file 'listBook_v2.fxml'.";
        assert publish != null : "fx:id=\"publish\" was not injected: check your FXML file 'listBook_v2.fxml'.";
        assert qty != null : "fx:id=\"qty\" was not injected: check your FXML file 'listBook_v2.fxml'.";
        assert titlbook != null : "fx:id=\"titlbook\" was not injected: check your FXML file 'listBook_v2.fxml'.";

    }

}