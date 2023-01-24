package lk.ijse.StudentMS.dao;

import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.model.EmployeeDTO;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeeModelDAOImpl {

    public static boolean addEmployee(EmployeeDTO employee) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?)");

        preparedStatement.setObject(1, employee.getEID());
//        preparedStatement.setObject(2, employee.getUID());
        preparedStatement.setObject(2, employee.getNIC());
        preparedStatement.setObject(3, employee.getName());
        preparedStatement.setObject(4, employee.getAddress());
        preparedStatement.setObject(5, employee.getContact());
        preparedStatement.setObject(6, employee.getEmail());
        preparedStatement.setObject(7, employee.getSalary());
        preparedStatement.setObject(8, employee.getRole());


        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateEmployee(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("UPDATE Employee SET NIC=?,name=?,address=?,contact=?,email=?, salary=?,role=?  WHERE EId=?");

//        preparedStatement.setObject(1, employee.getEID());
        preparedStatement.setObject(1, employee.getNIC());
        preparedStatement.setObject(2, employee.getName());
        preparedStatement.setObject(3, employee.getAddress());
        preparedStatement.setObject(4, employee.getContact());
        preparedStatement.setObject(5, employee.getEmail());
        preparedStatement.setObject(6, employee.getSalary());
        preparedStatement.setObject(7, employee.getRole());
        preparedStatement.setObject(8, employee.getEID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean deleteEmployee(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM Employee  WHERE EId=?");
        preparedStatement.setObject(1, employee.getEID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean searchEmployee(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Employee WHERE EID = ?");

        preparedStatement.setObject(1,employee.getEID());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            employee.setNIC(String.valueOf(resultSet.getObject(2)));
            employee.setName(String.valueOf(resultSet.getObject(3)));
            employee.setAddress(String.valueOf(resultSet.getObject(4)));
            employee.setContact(String.valueOf(resultSet.getObject(5)));
            employee.setEmail(String.valueOf(resultSet.getObject(6)));
            employee.setSalary(Double.parseDouble(String.valueOf(resultSet.getObject(7))));
            employee.setRole(String.valueOf(resultSet.getObject(8)));
            return true;
        }
        return false;
    }


    public static ArrayList<EmployeeDTO> loadEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> arrayList=new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM Employee");
        ResultSet rst = preparedStatement.executeQuery();

            while (rst.next()){

               EmployeeDTO employee = new EmployeeDTO(rst.getString("EID"),rst.getString("NIC"),rst.getString("name"),rst.getString("address"),rst.getString("contact"),rst.getString("email"),rst.getDouble("salary"),rst.getString("cashOrcard"),rst.getString("role"));

               // employee.setEID(String.valueOf(rst.getString(1)));
                arrayList.add(employee);
            }
            return arrayList;


    }

    public void initialize(URL location, ResourceBundle resources) {
    //  tableLoad();
    }
    private void tableInit(){}
}


