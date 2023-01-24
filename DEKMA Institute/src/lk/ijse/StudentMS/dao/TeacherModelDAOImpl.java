package lk.ijse.StudentMS.dao;

import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.model.TeacherDTO;
import lk.ijse.StudentMS.util.CrudUtil;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherModelDAOImpl {
    public static boolean addTeacher(TeacherDTO teacher) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("INSERT INTO Teacher VALUES (?,?,?,?,?,?,?,?)");
        preparedStatement.setObject(1, teacher.getTID());
        preparedStatement.setObject(2, teacher.getSUBID());
        preparedStatement.setObject(3, teacher.getNIC());
        preparedStatement.setObject(4, teacher.getName());
        preparedStatement.setObject(5, teacher.getAddress());
        preparedStatement.setObject(6, teacher.getContact());
        preparedStatement.setObject(7, teacher.getEmail());
        preparedStatement.setObject(8, teacher.getSalary());


        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateTeacher(TeacherDTO teacher) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Teacher SET  SubID=?,NIC=?,name=?,address=?,contact=?,email=?, salary=?  WHERE TId=?";
        return CrudUtil.execute(sql,teacher.getSUBID(),teacher.getNIC(),
                teacher.getName(),teacher.getAddress(),teacher.getContact(),teacher.getEmail(),teacher.getSalary(),teacher.getTID());

    }

    public static boolean deleteTeacher(TeacherDTO teacher) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM Teacher  WHERE TId=?");
        preparedStatement.setObject(1, teacher.getTID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean searchTeacher(TeacherDTO teacher) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Teacher WHERE TID=?");
        preparedStatement.setObject(1,teacher.getTID());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            teacher.setSUBID(String.valueOf(resultSet.getObject(2)));
            teacher.setNIC(String.valueOf(resultSet.getObject(3)));
            teacher.setName(String.valueOf(resultSet.getObject(4)));
            teacher.setAddress(String.valueOf(resultSet.getObject(5)));
            teacher.setContact(String.valueOf(resultSet.getObject(6)));
            teacher.setEmail(String.valueOf(resultSet.getObject(7)));
           teacher.setSalary(Double.parseDouble(String.valueOf(resultSet.getObject(8))));
            return true;
        }
        return false;
    }

    public static ArrayList<TeacherDTO> loadTeacher() throws SQLException, ClassNotFoundException {
        ArrayList<TeacherDTO> arrayList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Teacher");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            TeacherDTO teacher = new TeacherDTO();
            teacher.setTID(String.valueOf(resultSet.getObject(1)));
            teacher.setSUBID(String.valueOf(resultSet.getObject(2)));
            teacher.setNIC(String.valueOf(resultSet.getObject(3)));
            teacher.setName(String.valueOf(resultSet.getObject(4)));
            teacher.setAddress(String.valueOf(resultSet.getObject(5)));
            teacher.setEmail(String.valueOf(resultSet.getObject(6)));
            teacher.setContact(String.valueOf(resultSet.getObject(7)));
            teacher.setSalary(Double.parseDouble(String.valueOf(resultSet.getObject(8))));


            arrayList.add(teacher);
        }

        return arrayList;


    }

    public void initialize(URL location, ResourceBundle resources) {
// tableLoad();
    }
    private void tableInit(){}


}
