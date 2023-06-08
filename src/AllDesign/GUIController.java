package AllDesign;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToGUI(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("GUI.fxml"));

        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToLogin(ActionEvent event) throws IOException{
         root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show(); 

    }
    public void switchToManageBook(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Manage Book's Categories.fxml"));
       stage =(Stage)((Node)event.getSource()).getScene().getWindow();
       scene= new Scene(root);
       stage.setScene(scene);
       stage.show(); 

   }

public void switchToListbook(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("BOOK.fxml"));
   stage =(Stage)((Node)event.getSource()).getScene().getWindow();
   scene= new Scene(root);
   stage.setScene(scene);
   stage.show(); 
}
public void switchToregisterStudent(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("registSTD.fxml"));
   stage =(Stage)((Node)event.getSource()).getScene().getWindow();
   scene= new Scene(root);
   stage.setScene(scene);
   stage.show(); 
}
public void switchToUpdate(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("Update_book.fxml"));
   stage =(Stage)((Node)event.getSource()).getScene().getWindow();
   scene= new Scene(root);
   stage.setScene(scene);
   stage.show(); 
}
public void switchToBackFromLBook(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
   stage =(Stage)((Node)event.getSource()).getScene().getWindow();
   scene= new Scene(root);
   stage.setScene(scene);
   stage.show(); 
}
public void switchToAddBook(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("AddBook.fxml"));
   stage =(Stage)((Node)event.getSource()).getScene().getWindow();
   scene= new Scene(root);
   stage.setScene(scene);
   stage.show(); 
}
public void switchTobUSINESSBook(ActionEvent event) throws IOException{
    root = FXMLLoader.load(getClass().getResource("Business Books.fxml"));
   stage =(Stage)((Node)event.getSource()).getScene().getWindow();
   scene= new Scene(root);
   stage.setScene(scene);
   stage.show(); 
}


}