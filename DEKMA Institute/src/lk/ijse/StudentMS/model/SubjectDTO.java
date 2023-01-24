package lk.ijse.StudentMS.model;

public class SubjectDTO {
    private String SUBID;
    private String SubName;

    public SubjectDTO() {
    }

    public SubjectDTO(String SUBID, String subName) {
        this.SUBID = SUBID;
        SubName = subName;
    }

    public String getSUBID() {
        return SUBID;
    }

    public void setSUBID(String SUBID) {
        this.SUBID = SUBID;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }
}
