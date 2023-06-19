import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListBookControllerv2 implements Initializable{

    @FXML
    private Button AddBookBtn;

    @FXML
    private TableColumn<listbookVariable, String> ImportDate;

    @FXML
    private TableColumn<listbookVariable, String> author;

    @FXML
    private Button backBTN;

    @FXML
    private TableColumn<listbookVariable, String> genreBook;

    @FXML
    private TableColumn<listbookVariable, String> idbook;

    @FXML
    private TableView<listbookVariable> listPane;

    @FXML
    private TableColumn<listbookVariable, String> publish;

    @FXML
    private TableColumn<listbookVariable, String> qty;

    @FXML
    private TableColumn<listbookVariable, String> titlbook;

    @FXML
    void switchToAddBook(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/AddBook.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }
     
    
    @FXML
    void switchToGUI(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

// *******************************
    public ObservableList<listbookVariable> getBooksList() throws SQLException {
        ObservableList<listbookVariable> bookList = FXCollections.observableArrayList();
        try {
            Connection conn = bookDB.getConnection();
            String sql = "SELECT * FROM Book";
            // // Search Function
            // String search = searchField.getText();
            // if (search != "") {
            // sql += " WHERE title LIKE '%" + search + "%'";
            // }

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            listbookVariable Book;
            while (resultSet.next()) {
                Book = new listbookVariable(resultSet.getString("ID"), resultSet.getString("Title"),
                        resultSet.getString("Genre"), resultSet.getString("Author"),
                        resultSet.getString("PublishDate"), resultSet.getString("ImportDate"), resultSet.getString("QTY"));
                bookList.add(Book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void showBook() throws SQLException {
        ObservableList<listbookVariable> list = getBooksList();
        idbook.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("ID"));
        titlbook.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("Title"));
        author.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("Author"));
        genreBook.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("Genre"));
        publish.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("PublishDate"));
        ImportDate.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("ImportDate"));
        qty.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("QTY"));
        listPane.setItems(list);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showBook();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
