package AllDesign.Borrowing_return;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.net.URL;
import java.util.ResourceBundle;

import javax.print.attribute.standard.MediaSize.Other;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.fxml.Initializable;

// public class HistoryController implements Initializable {
    // private Stage stage;
    // private Scene scene;
   
//     @FXML
//     private TableView<SheetVeriable> listView;

//     @FXML
//     private TableColumn<SheetVeriable, String> BookID;

//     @FXML
//     private TableColumn<SheetVeriable, String> BookID1;

//     @FXML
//     private Tab Borrowing;

//     @FXML
//     private TableColumn<SheetVeriable,String> Duedate;

//     @FXML
//     private TableColumn<SheetVeriable,String> Duedate1;

//     @FXML
//     private TableColumn<SheetVeriable,String> First_name;

//     @FXML
//     private TableColumn<SheetVeriable,String> First_name1;

//     @FXML
//     private TableColumn<SheetVeriable, String> Last_name;

//     @FXML
//     private TableColumn<SheetVeriable, String> Last_name1;

//     @FXML
//     private TableColumn<SheetVeriable, ?> Name;

//     @FXML
//     private TableColumn<SheetVeriable, ?> Name1;

//     @FXML
//     private TableColumn<SheetVeriable, String> Other;

//     @FXML
//     private TableColumn<SheetVeriable, String> PhoneNumber;

//     @FXML
//     private TableColumn<SheetVeriable,String> Phonenumber1;

//     @FXML
//     private Tab Return;

//     @FXML
//     private TableColumn<SheetVeriable, String> Status;

//     @FXML
//     private TableColumn<SheetVeriable, String> Staus1;

//     @FXML
//     private TableColumn<SheetVeriable, String> StudentID;

//     @FXML
//     private TableColumn<SheetVeriable, String> StudentID1;

//     @FXML
//     private Button back;

//     private Parent root;

//     @FXML

//     public void switchToGUI(ActionEvent event) throws IOException {
//         root = FXMLLoader.load(getClass().getResource("/AllDesign/GUI.fxml"));
//         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         scene = new Scene(root);
//         stage.setScene(scene);
//         stage.show();

//     }

//     public ObservableList<SheetVeriable> getSTDList() throws SQLException {
//     ObservableList<SheetVeriable> stdList = FXCollections.observableArrayList();
//     try (Connection conn = Sheetconnector.getConnection();
//          PreparedStatement statement = conn.prepareStatement("SELECT * FROM Borrowing");
//          ResultSet rs = statement.executeQuery()) {
//         while (rs.next()) {
//             SheetVeriable borrowing = new SheetVeriable(
//                     rs.getString("id"),
//                     rs.getString("Last_name"),
//                     rs.getString("First_name"),
//                     rs.getString("BookID"),
//                     rs.getString("PhoneNumber"),
//                     rs.getString("Duedate"),
//                     rs.getString("Status"),
//                     rs.getString("Other")
//             );
//             stdList.add(borrowing);
//         }
//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
//     return stdList;
// }
    

//    public void showBook() throws SQLException {
//     ObservableList<SheetVeriable> lists = getSTDList();
//     StudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
//     Last_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//     First_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//     BookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
//     PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
//     Duedate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
//     Status.setCellValueFactory(new PropertyValueFactory<>("status"));
//     Other.setCellValueFactory(new PropertyValueFactory<>("other"));
//     listView.setItems(lists);
// }

//     @Override
//     public void initialize(URL location, ResourceBundle resources) {
//         try {
//             showBook();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
   

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HistoryController {

    @FXML
    private TableView<SheetVeriable> BorrowingTable;

    @FXML
    private TableColumn<SheetVeriable, String> StudentID;

    @FXML
    private TableColumn<SheetVeriable, String> Last_name;

    @FXML
    private TableColumn<SheetVeriable, String> First_name;

    @FXML
    private TableColumn<SheetVeriable, String> BookID;

    @FXML
    private TableColumn<SheetVeriable, String> PhoneNumber;

    @FXML
    private TableColumn<SheetVeriable, String> Duedate;

    @FXML
    private TableColumn<SheetVeriable, String> Status;

    @FXML
    private TableColumn<SheetVeriable, String> Other;

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    public void switchToGUI(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/AllDesign/GUI.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToBorrow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/Borrowing_return/borrowing.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }



    public void initialize() {
        // Set cell value factories for each column
        StudentID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    Last_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    First_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    BookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
    PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    Duedate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
    Status.setCellValueFactory(new PropertyValueFactory<>("status"));
    Other.setCellValueFactory(new PropertyValueFactory<>("other"));

       
        // For example:
        ObservableList<SheetVeriable> dataList = FXCollections.observableArrayList();
    dataList.add(new SheetVeriable("1", "Doe", "John", "B001", "1234567890", "2023-07-01", "Returned", ""));
    dataList.add(new SheetVeriable("2", "Smith", "Jane", "B002", "9876543210", "2023-07-05", "Borrowed", ""));
    BorrowingTable.setItems(dataList);
    }

    // Add event handlers or other methods here as needed
}



