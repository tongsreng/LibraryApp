package AllDesign.Admin;

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

public class AdminTableController implements Initializable{

    @FXML
    private TableColumn<AdminVariable, String> adrsCol;

    @FXML
    private Button btn_home;

    @FXML
    private TableColumn<AdminVariable, String> contCol;

    @FXML
    private TableColumn<AdminVariable, String> dobCol;

    @FXML
    private TableColumn<AdminVariable, String> dptCol;

    @FXML
    private TableColumn<AdminVariable, String> emailCol;

    @FXML
    private TableColumn<AdminVariable,String> genderCol;

    @FXML
    private TableColumn<AdminVariable, String> idCol;

    @FXML
    private TableView<AdminVariable> listView;

    @FXML
    private TableColumn<AdminVariable, String> pass;
     @FXML
    private TableColumn<AdminVariable, String> repass;

    @FXML
    private Button regisSTDmore;

    @FXML
    private TableColumn<AdminVariable, String> snameCol;

    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }

    @FXML
    void switchToRegistAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/Register_Admin.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }
    
    public ObservableList<AdminVariable> getAdminList() throws SQLException{
         ObservableList<AdminVariable> AdminList = FXCollections.observableArrayList();
        try {
            Connection conn = AdminSQlConnect.getConnection();
            String sql  ="select * from Admin";

            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            AdminVariable Admin;
            while(rs.next()){
                Admin = new AdminVariable(rs.getString("id"),rs.getString("name"),rs.getString("gender"),rs.getString("department"),rs.getString(" contact")
                , rs.getString("address"), rs.getString("email"), rs.getString("dob")
                , rs.getString("password"), rs.getString("repassword"));
              AdminList.add(Admin);
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return AdminList;
    }
    public void showAdmin() throws SQLException {
        ObservableList<AdminVariable> List = getAdminList();
        idCol.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("id"));
        snameCol.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("name"));
        genderCol.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("gender"));
        dptCol.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("department"));
        contCol.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("contact"));
         adrsCol.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("address"));
         emailCol.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("email"));
         dobCol.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("dob"));
        pass.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("password"));
        repass.setCellValueFactory(new PropertyValueFactory<AdminVariable, String>("repassword"));
        
      listView.setItems(List);
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            showAdmin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
