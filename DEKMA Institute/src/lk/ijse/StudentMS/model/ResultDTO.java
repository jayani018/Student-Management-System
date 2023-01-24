package lk.ijse.StudentMS.model;

public class ResultDTO {
    private String SID;
    private String SUBID;
    private String result;

    public ResultDTO() {
    }

    public ResultDTO(String SID, String SUBID, String result) {
        this.SID = SID;
        this.SUBID = SUBID;
        this.result = result;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getSUBID() {
        return SUBID;
    }

    public void setSUBID(String SUBID) {
        this.SUBID = SUBID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
