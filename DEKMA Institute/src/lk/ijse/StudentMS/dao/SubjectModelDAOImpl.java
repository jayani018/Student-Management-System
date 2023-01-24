package lk.ijse.StudentMS.dao;

import javafx.fxml.Initializable;
import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.model.SubjectDTO;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import lk.ijse.StudentMS.model.Student;

public class SubjectModelDAOImpl implements Initializable {
    public static boolean addSubject(SubjectDTO subject) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("INSERT INTO Subject VALUES (?,?)");

        preparedStatement.setObject(1, subject.getSUBID());
        preparedStatement.setObject(2, subject.getSubName());


        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateSubject(SubjectDTO subject) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("UPDATE Subject SET SubName=?  WHERE SUBID=?");
        preparedStatement.setObject(1, subject.getSubName());
        preparedStatement.setObject(2, subject.getSUBID());
        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean deleteSubject(String id)/*(Subject subject)*/ throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM Subject  WHERE SUBID=?");
        preparedStatement.setObject(1,id);/* subject.getSUBID());*/

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<SubjectDTO> loadSubject() throws SQLException, ClassNotFoundException {
        ArrayList<SubjectDTO> arrayList=new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Subject");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            SubjectDTO subject = new SubjectDTO();
            subject.setSUBID(String.valueOf(resultSet.getObject(1)));

            arrayList.add(subject);
        }
        return arrayList;


    }

    public static boolean searchSubject(SubjectDTO subject) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Subject WHERE SUBID=?");
        preparedStatement.setObject(1,subject.getSUBID());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            subject.setSubName(String.valueOf(resultSet.getObject(2)));
            return true;
        }
        return false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
// tableLoad();
    }
    private void tableInit(){}
}
