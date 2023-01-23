package lk.ijse.StudentMS.model;

import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.to.Batch;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BatchModel {
    public static boolean addBatch(Batch batch) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("INSERT INTO Batch VALUES (?,?,?)");
        preparedStatement.setObject(1, batch.getBID());
        preparedStatement.setObject(2, batch.getYear());
        preparedStatement.setObject(3, batch.getSID());


        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateStudent(Batch batch) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("UPDATE Batch SET BID=?,year=?  WHERE BId=?");
        preparedStatement.setObject(1, batch.getBID());
        preparedStatement.setObject(2, batch.getYear());


        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;

//
    }

    public static boolean deleteBatch(Batch batch) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM Batch  WHERE BId=?");
        preparedStatement.setObject(1, batch.getBID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean searchBatch(Batch batch) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Batch WHERE BID=?");
        preparedStatement.setObject(1, batch.getBID());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            batch.setYear(String.valueOf(resultSet.getObject(2)));
            return true;
        }
        return false;

    }

    public static boolean updateBatch(Batch batch) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("UPDATE Batch SET year =?  WHERE BID=?");
        preparedStatement.setObject(1, batch.getYear());
        preparedStatement.setObject(2, batch.getBID());
        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<Batch> loadBatch() throws SQLException, ClassNotFoundException {
        ArrayList<Batch> arrayList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Batch");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Batch batch = new Batch();
            batch.setBID(String.valueOf(resultSet.getObject(1)));
            batch.setYear(String.valueOf(resultSet.getObject(2)));
            batch.setSID(String.valueOf(resultSet.getObject(3)));


            arrayList.add(batch);
        }
        return arrayList;



    }


    public void initialize(URL location, ResourceBundle resources) {
// tableLoad();
    }
    private void tableInit(){}

}
