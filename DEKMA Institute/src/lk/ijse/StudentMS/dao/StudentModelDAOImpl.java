package lk.ijse.StudentMS.dao;

import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.model.StudentDTO;
import lk.ijse.StudentMS.util.CrudUtil;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentModelDAOImpl {
    public static boolean addStudent (StudentDTO student) throws SQLException, ClassNotFoundException {

        String sql="INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,student.getSID(),student.getEID(),student.getNIC(),
                student.getStream(),student.getExam_year(),student.getName(),student.getAddress(),student.getContact(),student.getEmail());



    }

    public static boolean updateStudent (StudentDTO student) throws SQLException, ClassNotFoundException {


        String sql = "UPDATE Student SET EId=?, NIC=?, subject=?,exam_year=?,name=?,address=?,contact=?,email=? WHERE SID=?";
        return CrudUtil.execute(sql,student.getEID(),student.getNIC(),
                student.getStream(),student.getExam_year(),student.getName(),student.getAddress(),student.getContact(),student.getEmail(),student.getSID());
    }

    public static boolean deleteStudent(StudentDTO student) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM Student  WHERE SID=?");
        preparedStatement.setObject(1,student.getSID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean searchStudent(StudentDTO student) throws SQLException, ClassNotFoundException {
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

    public static ArrayList<StudentDTO> loadStudent() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDTO> arrayList=new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Student");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            StudentDTO student = new StudentDTO();
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

    public void initialize(URL location, ResourceBundle resources) {
// tableLoad();
    }
    private void tableInit(){}


}
