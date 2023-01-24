package lk.ijse.StudentMS.model;

public class UserDTO {


    private String userName;
    private String password;
    private String EID;

    public UserDTO() {
    }

    public UserDTO(String userName, String password, String EID) {
        this.userName = userName;
        this.password = password;
        this.EID = EID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }
}
