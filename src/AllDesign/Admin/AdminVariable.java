package AllDesign.Admin;
public class AdminVariable {
    private String id;
    private String name;
    private String gender;
    private String department;
    private String contact;
    private String address;
    private String email;
    private String dob;
    private String password;  
    private String repassword;
    public AdminVariable(String id, String name, String gender, String department, String contact, String address,
            String email, String dob, String password, String repassword) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.repassword = repassword;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRepassword() {
        return repassword;
    }
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

        

    

}
