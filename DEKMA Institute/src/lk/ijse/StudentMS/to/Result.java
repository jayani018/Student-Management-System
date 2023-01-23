package lk.ijse.StudentMS.to;

public class Result {
    private String SID;
    private String SUBID;
    private String result;

    public Result() {
    }

    public Result(String SID, String SUBID, String result) {
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
