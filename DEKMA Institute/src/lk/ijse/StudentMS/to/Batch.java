package lk.ijse.StudentMS.to;

public class Batch {
    private String  SID;
    private String BID;
    private String year;

    public Batch() {
    }

    public Batch(String SID, String BID, String year) {
        this.SID = SID;
        this.BID = BID;
        this.year = year;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "SID='" + SID + '\'' +
                ", BID='" + BID + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
