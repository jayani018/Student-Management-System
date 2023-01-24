package lk.ijse.StudentMS.model;

public class StudentDTO {
    private String SID;
    private String EID;
    private String NIC;
    private String stream;
    private String exam_year;
    private String name;
    private String address;
    private String contact;
    private String email;

    public StudentDTO() {
    }


    public StudentDTO(String EID, String SID, String NIC, String stream, String exam_year, String name, String address, String contact, String email) {
        this.SID = SID;
        this.EID = EID;
        this.NIC = NIC;
        this.stream = stream;
        this.exam_year = exam_year;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
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

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getExam_year() {
        return exam_year;
    }

    public void setExam_year(String exam_year) {
        this.exam_year = exam_year;
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
}
