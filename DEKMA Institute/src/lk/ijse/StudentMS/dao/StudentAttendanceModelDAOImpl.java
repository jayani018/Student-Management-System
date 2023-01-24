package lk.ijse.StudentMS.dao;

import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.model.StudentAttendance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAttendanceModelDAOImpl {
    public static boolean addAttendance(StudentAttendance studentAttendance) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("INSERT INTO student_attendance VALUES (?,?,?)");

        preparedStatement.setObject(1, studentAttendance.getSID());
        preparedStatement.setObject(2, studentAttendance.getDate());
        preparedStatement.setObject(3, studentAttendance.getTime());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateAttendance(StudentAttendance studentAttendance) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("UPDATE Employee SET UID=?, NIC=?,name=?,address=?,contact=?,email=?, salary=?  WHERE EId=?");

        preparedStatement.setObject(1, studentAttendance.getSID());
        preparedStatement.setObject(2, studentAttendance.getDate());
        preparedStatement.setObject(3, studentAttendance.getTime());


        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }
    public static boolean deleteAttendance (StudentAttendance studentAttendance) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM student_attendance  WHERE SID=?");
        preparedStatement.setObject(1, studentAttendance.getSID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }


    public static ArrayList<StudentAttendance> loadStudentAttendance() throws SQLException, ClassNotFoundException {
        ArrayList<StudentAttendance> arrayList=new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM student_attendance");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            StudentAttendance studentAttendance = new StudentAttendance();
            studentAttendance.setSID(String.valueOf(resultSet.getObject(1)));
            studentAttendance.setDate(String.valueOf(resultSet.getObject(2)));
            studentAttendance.setTime(String.valueOf(resultSet.getObject(3)));

            arrayList.add(studentAttendance);
        }
        return arrayList;


    }

}
