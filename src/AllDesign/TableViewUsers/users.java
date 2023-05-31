package AllDesign.TableViewUsers;
public class users {
    int id;
    String auther,category,date;
    int quantity;
    public int getId(){
        return id;
    }
    public String getAuther(){
        return auther;
    }
    public String getCategory(){
        return category;
    }
    public String getDate(){
        return date;
    }
    public int getQuantity(){
        return quantity;
    }
    public users(int id,String auther,String category,String date,int quantity){
        this.id=id;
        this.auther=auther;
        this.category=category;
        this.date=date;
        this.quantity=quantity;
    }



}