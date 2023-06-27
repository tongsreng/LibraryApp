package AllDesign;

import java.io.IOException;

// import java.io.IOException;

// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Node;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.DatePicker;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.stage.Stage;

// public class ResgistAdminController  {

//     @FXML
//     private DatePicker DOBpicker;

//     @FXML
//     private Label labelRegis;

//     @FXML
//     private TextField putAdd;

//     @FXML
//     private TextField putAdd1;

//     @FXML
//     private TextField putAdd2;

//     @FXML
//     private TextField putCont;

//     @FXML
//     private TextField putDep;

//     @FXML
//     private TextField putEmauil;

//     @FXML
//     private TextField putGender;

//     @FXML
//     private TextField putID;

//     @FXML
//     private TextField putName;

//       @FXML
//     void switchToLogin(ActionEvent event) throws IOException {
//         //System.out.println("THIS IS BACK BTN................");
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/login.fxml"));
//         Parent welcomeParent = loader.load();
//         Scene welcomeScene = new Scene(welcomeParent);
//         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
//         window.setScene(welcomeScene);
//         window.show();
//     }

// }
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ResgistAdminController {

    @FXML
    private DatePicker DOBpicker;

    @FXML
    private Label labelRegis;

    @FXML
    private TextField putAdd;

    @FXML
    private TextField putAdd1;

    @FXML
    private TextField putAdd2;

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
    void switchToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/login.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }
    //  @FXML
    // void switchTogui(ActionEvent event) throws IOException {
    //     FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
    //     Parent welcomeParent = loader.load();
    //     Scene welcomeScene = new Scene(welcomeParent);
    //     Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
    //     window.setScene(welcomeScene);
    //     window.show();
    // }
    
    @FXML
    void switchTogui(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllDesign/GUI.fxml"));
        Parent welcomeParent = loader.load();
        Scene welcomeScene = new Scene(welcomeParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        window.setScene(welcomeScene);
        window.show();
    }


}


