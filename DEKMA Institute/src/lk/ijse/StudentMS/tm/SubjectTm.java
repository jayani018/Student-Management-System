package lk.ijse.StudentMS.tm;

public class SubjectTm {
    private String SUBID;
    private String SubName;

    public SubjectTm() {
    }

    public SubjectTm(String SUBID, String subName) {
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
