package AllDesign.Borrowing_return;

public class SheetVeriable {
    private String ID;
    private String Last_Name;
    private String First_Name;
    private String BookID;
    private String PhoneNumber;
    private String Due;
    private String Status;
    private String Other;

    public SheetVeriable(String ID, String lastName, String firstName, String bookID, String phoneNumber,
            String dueDate, String status, String other) {
        this.ID = ID;
        this.Last_Name =lastName;
        this.First_Name = firstName;
        this.BookID = bookID;
        this.PhoneNumber = phoneNumber;
        this.Due = dueDate;
        this.Status = status;
        this.Other = other;
    }

    public String getID() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    public String getLastName() {
        return Last_Name;
    }

    public void setLastName(String lastName) {
        this.Last_Name = lastName;
    }

    public String getFirstName() {
        return First_Name;
    }

    public void setFirstName(String firstName) {
        this.First_Name = firstName;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        this.BookID = bookID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getDueDate() {
        return Due;
    }

    public void setDueDate(String dueDate) {
        this.Due = dueDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        this.Other = other;
    }
}