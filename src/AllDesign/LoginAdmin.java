package AllDesign;
import java.sql.*; 

public class LoginAdmin {
    Connection connection;
    public LoginAdmin() throws ClassNotFoundException, SQLException{
         connection= SQLiteConnector.getSQLiteConnection();
        
        if(connection==null){
            System.out.println("Connect not successful");
            System.exit(1);}
        }
        public boolean isDbConnected(){
            try{
                return !connection.isClosed();
            }catch (SQLException e){
                e.printStackTrace();
                return false;
            
        }
    }
    public boolean isLogin(String email , String pass) throws SQLException{
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String query = "select * from Admin where email=? and password=?";
        try{
               preparedStatement = connection.prepareStatement(query);
               preparedStatement.setString(1,email);
               preparedStatement.setString(2,pass);
               resultSet = preparedStatement.executeQuery();
               if(resultSet.next()){
                return true;
               }
               else{
                return false;
               }
            }catch (SQLException e){
                return false;

                
    }finally{
        preparedStatement.close();
        resultSet.close();
    }
    
}
}
