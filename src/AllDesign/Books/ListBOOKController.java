package AllDesign.Books;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ListBOOKController {
     @FXML
    private Button AddBookBtn;

    @FXML
    private Button DeleteBookBtn;

    @FXML
    private TextField addAuthor;

    @FXML
    private DatePicker addDate;

    @FXML
    private TextField addGenre;

    @FXML
    private TextField addID;

    @FXML
    private TextField addPublish;

    @FXML
    private TextField addQty;

    @FXML
    private TextField addTitle;

    @FXML
    private Button backBTN;
    
    @FXML
    private TableColumn<listbookVariable, String> author;

    @FXML
    private TableColumn<listbookVariable, String> borrowing;

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
    private TableColumn<listbookVariable, String> ImportDate;

    @FXML
    private TableColumn<listbookVariable, String> titlbook;

    @FXML
    private AnchorPane tableViewList;

    @FXML
    private TextField txtborrow;

    @FXML
    private Button updatebtn;

    

    @FXML
    void autoGenerate(MouseEvent event) {

    }

    private Connection conn = null;
    private PreparedStatement pst = null;

    @FXML
    void handleAddBook(ActionEvent event) throws IOException, SQLException {
        
        String title = addTitle.getText();
        String type = addGenre.getText();
        String author = addAuthor.getText();
        String qty = addQty.getText();
        String borrowing = txtborrow.getText();
        String publish = addPublish.getText();
        String date;
       
        if(addDate.getValue() != null){
            date = addDate.getValue().toString();
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("Please input all fields!!!!!");
            alert.showAndWait();
            return;
        }
        try {
                 String sqlInsert = "INSERT INTO `Bookv2`(`btitle`, `bgenre`, `bAuthor`, `bQTY`, `borrowing` ,`import`,`publish`) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement pst = conn.prepareStatement(sqlInsert);
                pst.setString(1, title);
                pst.setString(2, type);
                pst.setString(3, author);
                pst.setString(4, qty);
                pst.setString(5, borrowing);
                pst.setString(6, publish);
                pst.setString(7, date);
                
                JOptionPane.showMessageDialog(null,"User Add Succes.*");
                int i = pst.executeUpdate();
                if(i==1){
                    System.out.println("\n\t\tData Insert Successfully.\n");
                }
        } catch (SQLException e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Fail");
                alert.setHeaderText(null);
                alert.setContentText("Fail insert!!");
                alert.showAndWait();
            //Logger.getLogger(ListBOOKController.class.getName()).log(Level.SEVERE, null,ex);
        }
        finally{
            pst.close();
        }

         System.out.println("\n\t*******************************y.");

    }


    ObservableList<listbookVariable> list = FXCollections.observableArrayList(
        new listbookVariable("1","AA","BB","CC","DD","ee","ff","gg"),
        new listbookVariable("1","AA","BB","CC","DD","ee","ff","gg"),
        new listbookVariable("2","AA2","BB2","CC2","DD2","ee2","ff2","gg2")
    );

    public void initialize(URL url, ResourceBundle rb){
       idbook.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("bid"));
       titlbook.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("btitle"));
       genreBook.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("bgenre"));
       author.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("bAuthor"));
       qty.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("bQTY"));
       borrowing.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("borrowing"));
       ImportDate.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("import"));
       publish.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("publish"));
        listPane.setItems(list);
        
        
    }

    
    @FXML
    void switchToHome(ActionEvent event) throws IOException{
        System.out.println("fdsfjkdsfjdfk");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }

    
}


