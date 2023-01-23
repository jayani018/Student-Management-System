package lk.ijse.StudentMS.model;

import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.to.Student;
import lk.ijse.StudentMS.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModel {
    public static boolean addStudent (Student student) throws SQLException, ClassNotFoundException {

        String sql="INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,student.getSID(),student.getEID(),student.getNIC(),
                student.getStream(),student.getExam_year(),student.getName(),student.getAddress(),student.getContact(),student.getEmail());



    }

    public static boolean updateStudent (Student student) throws SQLException, ClassNotFoundException {


        String sql = "UPDATE Student SET EId=?, NIC=?, subject=?,exam_year=?,name=?,address=?,contact=?,email=? WHERE SID=?";
        return CrudUtil.execute(sql,student.getEID(),student.getNIC(),
                student.getStream(),student.getExam_year(),student.getName(),student.getAddress(),student.getContact(),student.getEmail(),student.getSID());
    }

    public static boolean deleteStudent(Student student) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM Student  WHERE SID=?");
        preparedStatement.setObject(1,student.getSID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean searchStudent(Student student) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Student WHERE SID=?");
        preparedStatement.setObject(1,student.getSID());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            student.setEID(String.valueOf(resultSet.getObject(2)));
            student.setNIC(String.valueOf(resultSet.getObject(3)));
            student.setStream(String.valueOf(resultSet.getObject(4)));
            student.setExam_year(String.valueOf(resultSet.getObject(5)));
            student.setName(String.valueOf(resultSet.getObject(6)));
            student.setAddress(String.valueOf(resultSet.getObject(7)));
            student.setContact(String.valueOf(resultSet.getObject(8)));
            student.setEmail(String.valueOf(resultSet.getObject(9)));
            return true;
        }
        return false;
    }

    public static ArrayList<Student> loadStudent() throws SQLException, ClassNotFoundException {
        ArrayList<Student> arrayList=new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Student");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Student student = new Student();
            student.setSID(String.valueOf(resultSet.getObject(1)));
            student.setEID(String.valueOf(resultSet.getObject(2)));
            student.setNIC(String.valueOf(resultSet.getObject(3)));
            student.setStream(String.valueOf(resultSet.getObject(4)));
            student.setExam_year(String.valueOf(resultSet.getObject(5)));
            student.setName(String.valueOf(resultSet.getObject(6)));
            student.setAddress(String.valueOf(resultSet.getObject(7)));
            student.setContact(String.valueOf(resultSet.getObject(8)));
            student.setEmail(String.valueOf(resultSet.getObject(9)));

            arrayList.add(student);
        }
        return arrayList;


    }



}
