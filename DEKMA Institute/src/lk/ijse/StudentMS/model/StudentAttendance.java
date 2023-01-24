package lk.ijse.StudentMS.model;

public class StudentAttendance {
    private String SID;
    private String date;
    private String time;

    public StudentAttendance() {
    }

    public StudentAttendance(String SID, String date, String time) {
        this.SID = SID;
        this.date = date;
        this.time = time;
    }



    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
