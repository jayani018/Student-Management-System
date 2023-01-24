package lk.ijse.StudentMS.dao;

import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.model.BatchDTO;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BatchModelDAOImpl {
    public static boolean addBatch(BatchDTO batch) throws SQLException, ClassNotFoundException {
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

    public static boolean updateStudent(BatchDTO batch) throws SQLException, ClassNotFoundException {
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

    public static boolean deleteBatch(BatchDTO batch) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM Batch  WHERE BId=?");
        preparedStatement.setObject(1, batch.getBID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean searchBatch(BatchDTO batch) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Batch WHERE BID=?");
        preparedStatement.setObject(1, batch.getBID());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            batch.setYear(String.valueOf(resultSet.getObject(2)));
            return true;
        }
        return false;

    }

    public static boolean updateBatch(BatchDTO batch) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("UPDATE Batch SET year =?  WHERE BID=?");
        preparedStatement.setObject(1, batch.getYear());
        preparedStatement.setObject(2, batch.getBID());
        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<BatchDTO> loadBatch() throws SQLException, ClassNotFoundException {
        ArrayList<BatchDTO> arrayList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Batch");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            BatchDTO batch = new BatchDTO();
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
