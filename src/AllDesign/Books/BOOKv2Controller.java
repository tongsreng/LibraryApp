package AllDesign.Books;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;


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
    void handleAddBK(ActionEvent event) throws IOException, SQLException {
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

        if (title.equals("") ||  type.equals("") || author.equals("") ||qty.equals("") || borrowing.equals("")|| publish.equals("") || date.equals("") ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("Please input all fields!!");
            alert.showAndWait();
        }else{
             try(Connection conn = bookDB.getConnection()){
            String sql = "INSERT INTO `Bookv2`(`btitle`, `bgenre`, `bAuthor`, `bQTY`, `borrowing`,`publish` ,`import`) VALUES (?,?,?,?,?,?,?)";
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
            
            }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("!! Fail !!");
                alert.setHeaderText(null);
                alert.setContentText("Fail insert!!  (1)");
                alert.showAndWait();
            }
            refreshTable();
            showBook();

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
       
    }
    listbookVariable selecListbookVariable;
    @FXML
    void selectItem(MouseEvent event) { // FROM DARA!
                // Check if the user clicked on a row
        if (event.getClickCount() == 1) {

            // Get the table view's selection model
            TableView.TableViewSelectionModel<listbookVariable> selectionModel = listPane.getSelectionModel();     
            // Get the selected row
            selecListbookVariable = selectionModel.getSelectedItem();
            addID.setText(selecListbookVariable.getID());
            addTitle.setText(selecListbookVariable.getTitle());
            addGenre.setText(selecListbookVariable.getGenre());
            addAuthor.setText(selecListbookVariable.getAuthor());
            addQty.setText(selecListbookVariable.getQTY());
            txtborrow.setText(selecListbookVariable.getBorrowing());
            addPublish.setText(selecListbookVariable.getPublishDate());
            addDate.setValue(LocalDate.parse(selecListbookVariable.getImportDate())); 
        } 
        // else if (event.getClickCount() >= 2) {
        //    // openBookDetail();
        // }
    }

    int index = -1;
    listbookVariable book = null; 
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
     @FXML
    private void refreshTable(){
        try {
           booklist.clear();
            String querry = "select from `Bookv2`";
            PreparedStatement pst = conn.prepareStatement(querry);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                booklist.add(new listbookVariable(
                    rs.getString("bid"),
                    rs.getString("btitle"),
                    rs.getString("bgenre"),
                    rs.getString("bAuthor"),
                    rs.getString("borrowing"),
                    rs.getString("bQTY"),
                    rs.getString("import"),
                    rs.getString("publish")
                ));
                listPane.setItems(booklist); 
                    
            }
        } catch (Exception e) {
            
        } 
    }

    @FXML
    void handleDelete(ActionEvent event) throws IOException, SQLException{
        //listPane.getItems().removeAll(listPane.getSelectionModel().getSelectedItem());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
             
        //------------------------------------------------------------------------------------
            Alert alert = new Alert(AlertType.CONFIRMATION);
             alert.initModality(Modality.APPLICATION_MODAL);
             alert.initOwner(window); 
             alert.getDialogPane().setContentText("This row will be deleted!");
             alert.getDialogPane().setHeaderText("Are you sure?");

             Optional<ButtonType> result = alert.showAndWait();
             if(result.get() == ButtonType.OK){
                conn = bookDB.getConnection();
                String sql = "Delete from `Bookv2` where bid = ?";
                try {
                    pst= conn.prepareStatement(sql);
                    pst.setString(1, addID.getText());
                    pst.execute();
                  //  JOptionPane.showMessageDialog(null,"Will you delete?");
                    refreshTable();
                    showBook();

                } catch (Exception e) {
                    // TODO: handle exception
                }
             }
        //---------------------------------------------------------------------------------------
    }
    @FXML
    void UpdateBookv2(ActionEvent event) throws IOException, SQLException {
        conn = bookDB.getConnection();
        String Bvalue1 = addID.getText();
        String Bvalue2 = addTitle.getText();
        String Bvalue3 = addGenre.getText();
        String Bvalue4 = addAuthor.getText();
        String Bvalue5 = addQty.getText();
        String Bvalue6 = txtborrow.getText();
        String Bvalue7 = addPublish.getText();
        String Bvalue8 = addDate.getValue().toString();

        String sql = "Update Bookv2 set bid = ' "+Bvalue1+"',btitle= '"+Bvalue2+"', bgenre ='" + Bvalue3+"', bAuthor='" + Bvalue4+"', bQTY='" + Bvalue5+"', borrowing='" + Bvalue6+"', import='" + Bvalue7+"', publish='" + Bvalue8+"'";
        
        pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Up to date.");
        refreshTable();
        showBook();
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
                Bookv2 = new listbookVariable(rs.getString("bid"),rs.getString("btitle") 
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
           
        refreshTable();
        showBook();
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

