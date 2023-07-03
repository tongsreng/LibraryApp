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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

// import java.sql.DriverManager;
// import java.sql.Statement;
// import java.time.LocalDate;
import java.util.Optional;

//import javax.swing.JOptionPane;

//import javafx.beans.Observable;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TextField;

//import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;

public class TableControler implements Initializable {
    @FXML
    private DatePicker DOBpicker;

    @FXML
    private Label labelRegis;

    @FXML
    private TextField putAdd;

    @FXML
    private PasswordField putAdd1;

    @FXML
    private PasswordField putAdd2;

    @FXML
    private TextField putCont;

    @FXML
    private TextField putDep;

    @FXML
    private TextField putEmauil;

    @FXML
    private TextField putGender;

    @FXML
    private TextField putID;

    @FXML
    private TextField putName;

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
    private TableColumn<AdminVariable, String> genderCol;

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

    // ObservableList<AdminVariable> AdminList =
    // FXCollections.observableArrayList();

    public ObservableList<AdminVariable> getAdminList() throws SQLException {
        ObservableList<AdminVariable> AdminList = FXCollections.observableArrayList();
        try {
            Connection conn = AdminSQlConnect.getConnection();
            String sql = "select * from Admin";

PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            AdminVariable Admin;
            while (rs.next()) {
                Admin = new AdminVariable(rs.getString("id"), rs.getString("name"), rs.getString("gender"),
                        rs.getString("department"), rs.getString("contact"), rs.getString("address"),
                        rs.getString("email"), rs.getString("dob"), rs.getString("password"),
                        rs.getString("repassword"));
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
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showAdmin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /// Delect Admin
    // @FXML
    // AdminVariable Adminlist;

    // void selectItem(MouseEvent event) { // FROM DARA!
    // // Check if the user clicked on a row
    // if (event.getClickCount() == 1) {

    // // Get the table view's selection model
    // TableView.TableViewSelectionModel<AdminVariable> selectionModel =
    // listView.getSelectionModel();
    // // Get the selected row
    // Adminlist = selectionModel.getSelectedItem();
    // contCol.setText(Adminlist.getContact());
    // idCol.setText(Adminlist.getId());
    // snameCol.setText(Adminlist.getName());
    // genderCol.setText(Adminlist.getGender());
    // dptCol.setText(Adminlist.getDepartment());
    // adrsCol.setText(Adminlist.getAddress());
    // emailCol.setText(Adminlist.getEmail());
    // dobCol.setText(Adminlist.getDob());
    // pass.setText(Adminlist.getPassword());
    // repass.setText(Adminlist.getRepassword());

    // }
    // // else if (event.getClickCount() >= 2) {
    // // // openBookDetail();
    // }

    int index = -1;
    // AdminVariable book = null;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
    * 
    */
    // @FXML
    // private void refreshTable() {
    // try {
    // AdminList.clear();
    // String querry = "select * from Admin";
    // PreparedStatement pst = conn.prepareStatement(querry);
    // ResultSet rs = pst.executeQuery();
    // while (rs.next()) {
    // AdminList.add(new AdminVariable(
    // rs.getString("id"),
    // rs.getString("name"),
    // rs.getString("gender"),
    // rs.getString("department"),
    // rs.getString("contact"),
    // rs.getString("address"),
    // rs.getString("email"),
    // rs.getString("password"),
    // rs.getString("dob"),
    // rs.getString("repassword")));
    // listView.setItems(AdminList);

    // }
    // } catch (Exception e) {

    // }
    // }


@FXML
    void handleDelete(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        // listView.getItems().removeAll(listView.getSelectionModel().getSelectedItem());

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // ------------------------------------------------------------------------------------
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(window);
        alert.getDialogPane().setHeaderText("This Admin will be deleted!");
        alert.getDialogPane().setContentText("Are you want to delect?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("kfkdsfjksfjskdfjl");
            String Id = idField.getText();
            System.out.println("ID: " + Id);
            Connection conn = AdminSQlConnect.getConnection();
            String sql = "Delete FROM Admin where id = ?";

            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, Id);
                pst.executeUpdate();
                // JOptionPane.showMessageDialog(null,"Will you delete?");
                // refreshTable();

                showAdmin();

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        // ---------------------------------------------------------------------------------------

    }

    @FXML
    void getItem(MouseEvent event) throws SQLException {
        Integer index = listView.getSelectionModel().getFocusedIndex();
        if (index <= -1) {
            return;
        }
        idField.setText(idCol.getCellData(index).toString());
        // showAdmin();

    }

    @FXML
    private TextField idField;
}
