package lk.ijse.StudentMS.to;

public class Employee {
    private String EID;
    private String NIC;
    private String name;
    private String address;
    private String  contact;
    private String email;
    private Double salary;
    private String cashOrcard;
    private String role;

    public String getCashOrcard() {
        return cashOrcard;
    }

    public void setCashOrcard(String cashOrcard) {
        this.cashOrcard = cashOrcard;
    }



    public Employee(String EID, String NIC, String name, String address, String contact, String email, Double salary,String cashOrcard, String role) {
        this.EID = EID;
        this.NIC = NIC;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.salary = salary;
        this.cashOrcard = cashOrcard;
        this.role = role;
    }

    public Employee(String id, String nic, String name, String address, String contact, String email, double salary,String cashOrcard) {

    }

    public Employee() {

    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
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
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
        return "Employee{" +
                "EID='" + EID + '\'' +
                ", NIC='" + NIC + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", cashOrcard='" + cashOrcard + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


}





