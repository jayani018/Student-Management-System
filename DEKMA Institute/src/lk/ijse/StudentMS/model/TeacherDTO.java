package lk.ijse.StudentMS.model;

public class TeacherDTO {
    private String TID;
    private String SUBID;
    private String NIC;
    private String name;
    private String address;
    private String Contact;
    private String email;
    private Double salary;

    public TeacherDTO() {
    }

    public TeacherDTO(String TID, String SUBID, String NIC, String name, String address, String contact, String email, Double salary) {
        this.TID = TID;
        this.SUBID = SUBID;
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        Contact = contact;
        this.email = email;
        this.salary = salary;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getSUBID() {
        return SUBID;
    }

    public void setSUBID(String SUBID) {
        this.SUBID = SUBID;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "TID='" + TID + '\'' +
                ", SUBID='" + SUBID + '\'' +
                ", NIC='" + NIC + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", Contact='" + Contact + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}