// package student;

// import java.io.IOException;
// import java.net.URL;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ResourceBundle;

// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.event.ActionEvent;
// import javafx.fxml.FXMLLoader;
// import javafx.fxml.Initializable;
// import javafx.scene.Node;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.stage.Stage;

// public class studntTableController implements Initializable{
//      @FXML
//     private TableView<studentVariable> listView;

//     @FXML
//     private TableColumn<studentVariable, String> adrsCol;

//     @FXML
//     private Button btn_home;
//     @FXML
//     private TableColumn<studentVariable, String> genderCol;

//     @FXML
//     private TableColumn<studentVariable, String> contCol;

//     @FXML
//     private TableColumn<studentVariable, String> dobCol;

//     @FXML
//     private TableColumn<studentVariable, String> dptCol;

//     @FXML
//     private TableColumn<studentVariable, String> emailCol;

//     @FXML
//     private TableColumn<studentVariable, String> idCol;

//     @FXML
//     private Button regisSTDmore;

//     @FXML
//     private TableColumn<studentVariable, String> snameCol;
    
//     @FXML
//     void switchTOregisSTD(ActionEvent event) throws IOException {
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("registSTD.fxml"));
//         Parent welcomeParent = loader.load();
//         Scene welcomeScene = new Scene(welcomeParent);
//         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         window.setScene(welcomeScene);
//         window.show();
//     }

//     @FXML
//     void switchToLogin(ActionEvent event) throws IOException {
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/login.fxml"));
//         Parent welcomeParent = loader.load();
//         Scene welcomeScene = new Scene(welcomeParent);
//         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         window.setScene(welcomeScene);
//         window.show();
//     }
//     public ObservableList<studentVariable> getSTDList() throws SQLException {
//         ObservableList<studentVariable> stdList = FXCollections.observableArrayList();
//         try {
//             Connection conn = studentSqlConnect.getConnection();
//             String sql = "SELECT * FROM Student";

//             PreparedStatement statement = conn.prepareStatement(sql);
//             ResultSet rs = statement.executeQuery();
//             studentVariable Student;
             
//             while (rs.next()) {
//                 Student = new studentVariable(rs.getString("sid"),rs.getString("sname"),rs.getString("department"),rs.getString("sgender"),
//                 rs.getString("DOB"),rs.getString("Address"),rs.getString("Email"),rs.getString("Contact"));
//                 stdList.add(Student);
//             }
 
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return stdList;
//     }

//     public void showBook() throws SQLException {
//         ObservableList<studentVariable> lists = getSTDList();
//         idCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("sid"));
//         snameCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("sname"));
//         dptCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("department"));
//         genderCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("sgender"));
//         dobCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("DOB"));
//         adrsCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("Address"));
//         emailCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("Email"));
//         contCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("Contact"));
//         listView.setItems(lists);
    
//     }

//     @Override
//     public void initialize(URL url, ResourceBundle rb) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method 'initialize'");
//         try {
//             System.out.println("hgdetdieodgvefhrtfwerygfier");
//             showBook();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
    
     
//     }

    
    
// }
package student;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class studntTableController implements Initializable {

    @FXML
    private TableColumn<studentVariable, String> adrsCol;

    @FXML
    private Button btn_home;

    @FXML
    private TableColumn<studentVariable, String> contCol;

    @FXML
    private TableColumn<studentVariable, String> dobCol;

    @FXML
    private TableColumn<studentVariable, String> dptCol;

    @FXML
    private TableColumn<studentVariable, String> emailCol;

    @FXML
    private TableColumn<studentVariable, String> genderCol;

    @FXML
    private TableColumn<studentVariable, String> idCol;

    @FXML
    private TableView<studentVariable> listView;

    @FXML
    private Button regisSTDmore;

    @FXML
    private TableColumn<studentVariable, String> snameCol;

    @FXML
    void switchTOregisSTD(ActionEvent event) {
        System.out.println("fsdfjdkfksjfksjf");
    }

    @FXML
    void switchToLogin(ActionEvent event) {
        System.out.println("fdsfjkdsfjdfk");
    }
    public ObservableList<studentVariable> getSTDList() throws SQLException {
        ObservableList<studentVariable> stdList = FXCollections.observableArrayList();
        try {
            Connection conn = studentSqlConnect.getConnection();
            String sql = "SELECT * FROM Student";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            studentVariable Student;
             
            while (rs.next()) {
                Student = new studentVariable(rs.getString("sid"),rs.getString("sname"),rs.getString("department"),rs.getString("sgender"),
                rs.getString("DOB"),rs.getString("Address"),rs.getString("Email"),rs.getString("Contact"));
                stdList.add(Student);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stdList;
    }

    public void showBook() throws SQLException {
        ObservableList<studentVariable> lists = getSTDList();
        idCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("sid"));
        snameCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("sname"));
        dptCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("department"));
        genderCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("sgender"));
        dobCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("DOB"));
        adrsCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("Address"));
        emailCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("Email"));
        contCol.setCellValueFactory(new PropertyValueFactory<studentVariable, String>("Contact"));
        listView.setItems(lists);
    
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
