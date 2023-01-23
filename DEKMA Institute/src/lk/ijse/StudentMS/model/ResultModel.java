package lk.ijse.StudentMS.model;

import javafx.fxml.Initializable;
import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.to.Subject;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResultModel {
        public static boolean addSubject(Subject subject) throws ClassNotFoundException, SQLException {

            PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("INSERT INTO Subject VALUES (?,?)");

            preparedStatement.setObject(1, subject.getSUBID());
            preparedStatement.setObject(2, subject.getSubName());


            int executeUpdate = preparedStatement.executeUpdate();
            if (executeUpdate > 0) {
                return true;
            }
            return false;
        }


    }
