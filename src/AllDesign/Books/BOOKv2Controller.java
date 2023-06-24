package AllDesign.Books;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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


public class BOOKv2Controller implements Initializable{

    @FXML
    private Button AddBookBtn;

    @FXML
    private Button DeleteBookBtn;

    @FXML
    private TableColumn<listbookVariable, String> ImportDate;

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
    private TableColumn<listbookVariable, String> author;

    @FXML
    private Button backBTN;

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
    private AnchorPane tableViewList;

    @FXML
    private TableColumn<listbookVariable, String> titlbook;

    @FXML
    private TextField txtborrow;

    @FXML
    private Button updatebtn;

    @FXML
    void autoGenerate(MouseEvent event) throws SQLException {
         int id = 0;
        Connection conn = bookDB.getConnection();
        String sql = "SELECT * FROM Bookv2";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            id = rs.getInt("bid") + 1;
        }
        String convert = Integer.toString(id);
        addID.setText(convert);
    }

    @FXML
    void handleAddBK(ActionEvent event) throws IOException {
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
            alert.setTitle("Fail!!!");
            alert.setHeaderText(null);
            alert.setContentText("Please input all field.");
            alert.showAndWait();
            return;
        }
        try(Connection conn = bookDB.getConnection()){
            String sql = "INSERT INTO `Bookv2`(`btitle`, `bgenre`, `bAuthor`, `bQTY`, `borrowing` ,`import`,`publish`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, title );
            pst.setString(2, type);
            pst.setString(3, author);
            pst.setString(4, qty);
            pst.setString(5, borrowing);
            pst.setString(6, publish);              
            pst.setString(7, date);
            
            int CountRow = pst.executeUpdate();
            if(CountRow >0){
                System.out.println("Insert DONE...");
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("** Saved **");
                alert.setHeaderText(null);
                alert.setContentText("Insert Success.");
                alert.showAndWait();

                // FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/BOOKv2.fxml"));
                // Parent welComeParent = loader.load();
                // Scene welScene = new Scene(welComeParent);
                // Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // window.setScene(welScene);
                // window.show();
            
            }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("!! Fail !!");
                alert.setHeaderText(null);
                alert.setContentText("Fail insert!!  (1)");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("Fail insert");
            alert.showAndWait();
        }
    }
    // @FXML
    // private void refreshTable(){
    //     try {
    //         booklist.clear();
    //         String querry = "select from `Bookv2`";
    //         PreparedStatement pst = conn.prepareStatement(querry);
    //         ResultSet rs = pst.executeQuery();
    //         while(rs.next()){
    //             booklist.add(new listbookVariable(
    //                 rs.getInt("bid"),
    //                 rs.getString("btitle"),
    //                 rs.getString("bgenre"),
    //                 rs.getString("bAuthor"),
    //                 rs.getString("borrowing"),
    //                 rs.getString("bQTY"),
    //                 rs.getString("import"),
    //                 rs.getString("publish")
    //             ));
    //             listPane.setItems(booklist); 
                    
    //         }
    //     } catch (Exception e) {
            
    //     } 
    // }

    listbookVariable book = null;
    Connection conn = null;
    PreparedStatement pst = null;
    @FXML
    void handleDelete(ActionEvent event) throws IOException, SQLException{
        conn = bookDB.getConnection();
        String sql = "Delete from `Bookv2` where bid = ?";
        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1, addID.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Deleted!");

        } catch (Exception e) {
            // TODO: handle exception
        }

        //listPane.getItems().removeAll(listPane.getSelectionModel().getSelectedItem());
        // book = listPane.getSelectionModel().getSelectedItem();
        // conn = bookDB.getConnection();
        // String sql = "Delete from `Bookv2` where bid = ?";
        // System.out.println("Not deleting.......");
        // try {
        //     PreparedStatement pst = conn.prepareStatement(sql);
        //     pst.setString(1, addID.getText());
        //     int i = pst.executeUpdate();
        //     if(i==1){
        //         Alert alert = new Alert(AlertType.INFORMATION);
        //         alert.setTitle("Info,** Deleted! **");
        //         //getBooksList();      
        //         listPane.setItems(getBooksList());
        //     }
            
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     System.out.println(e);
        // }
    }
    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        System.out.println("fdsfjkdsfjdfk");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }
    //------------------------------ Connect sqlite to TableView    -----------------------------
        ObservableList<listbookVariable> booklist = FXCollections.observableArrayList();
        public ObservableList<listbookVariable> getBooksList() throws SQLException{
            
            try {
                Connection conn = bookDB.getConnection();
                String sql  ="select * from Bookv2";

                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                listbookVariable Bookv2;
                while(rs.next()){
                    Bookv2 = new listbookVariable(rs.getInt("bid"),rs.getString("btitle") 
                    , rs.getString("bgenre"), rs.getString("bAuthor"), rs.getString("bQTY")
                    , rs.getString("borrowing"), rs.getString("import"), rs.getString("publish"));
                    booklist.add(Bookv2);
                }
                
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return booklist;
        }

    public void showBook() throws SQLException {
        ObservableList<listbookVariable> list = getBooksList();
        idbook.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("ID"));
        titlbook.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("title"));
        genreBook.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("genre"));
        author.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("author"));
        borrowing.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("borrowing"));
        publish.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("publishDate"));
        ImportDate.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("importDate"));
        qty.setCellValueFactory(new PropertyValueFactory<listbookVariable, String>("QTY"));
        
        listPane.setItems(list);
        
    }
    
    public void initialize(URL url, ResourceBundle rb){ 
        try {
            showBook();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

