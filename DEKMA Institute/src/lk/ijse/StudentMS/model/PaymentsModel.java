package lk.ijse.StudentMS.model;

import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.to.Payments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentsModel {
    public static boolean addPayments(Payments payments) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("INSERT INTO Payments VALUES (?,?,?,?,?)");

        preparedStatement.setObject(1, payments.getSID());
        preparedStatement.setObject(2, payments.getCarID());
        preparedStatement.setObject(3, payments.getAmount());
        preparedStatement.setObject(4, payments.getPayment_months());
        preparedStatement.setObject(5, payments.getTime());



        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updatePayments(Payments payments) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("UPDATE Payments SET SID=?, cardNo=?,amount=?, payment_months=?,time=? WHERE SId=?");

        preparedStatement.setObject(1, payments.getSID());
        preparedStatement.setObject(2, payments.getCarID());
        preparedStatement.setObject(3, payments.getAmount());
        preparedStatement.setObject(4, payments.getPayment_months());
        preparedStatement.setObject(5, payments.getTime());


        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean deletePayments(Payments payments) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM Payments  WHERE SId=?");
        preparedStatement.setObject(1, payments.getSID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<Payments> loadPayments() throws SQLException, ClassNotFoundException {
        ArrayList<Payments> arrayList=new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Payments");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Payments payments = new Payments();
            payments.setSID(String.valueOf(resultSet.getObject(1)));
            payments.setCarID(String.valueOf(resultSet.getObject(2)));
            payments.setAmount(String.valueOf(resultSet.getObject(3)));
            payments.setPayment_months(String.valueOf(resultSet.getObject(4)));
            payments.setTime(String.valueOf(resultSet.getObject(5)));

            arrayList.add(payments);
        }
        return arrayList;


    }

}
