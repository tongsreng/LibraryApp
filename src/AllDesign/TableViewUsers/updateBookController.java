package AllDesign.TableViewUsers;

public class updateBookController implements Intializable{
        @FXML
        private TableView<users> table_user;

        @FXML
        private TableColumn<users, Integer> col_id;

        @FXML
        private TableColumn<users, String> col_auther;

        @FXML
        private TableColumn<users, String> col_category;

        @FXML
        private TableColumn<users, Integer> col_date;

        @FXML
        private TableColumn<users, Integer> col_quantity;

        @FXML
        void table_user(ActionEvent event) {

        }
        @override
     public void initialize(URL url, ResourceBundle rb){
    }
}

