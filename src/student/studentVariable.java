package student;

public class studentVariable{ 

    private String sid;
    private String sname;
    private String department;
    private String sgender;
    private String DOB;
    private String Address;
    private String Email;
    private String Contact;
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getSgender() {
        return sgender;
    }
    public void setSgender(String sgender) {
        this.sgender = sgender;
    }
    public String getDOB() {
        return DOB;
    }
    public void setDOB(String dOB) {
        DOB = dOB;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getContact() {
        return Contact;
    }
    public void setContact(String contact) {
        Contact = contact;
    }
    public studentVariable(String sid, String sname, String department, String sgender, String dOB, String address,
            String email, String contact) {
        this.sid = sid;
        this.sname = sname;
        this.department = department;
        this.sgender = sgender;
        DOB = dOB;
        Address = address;
        Email = email;
        Contact = contact;
    }
    
}