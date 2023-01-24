package lk.ijse.StudentMS.model;

import lk.ijse.StudentMS.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModelDAOImpl {
  public static boolean addUser(UserDTO user) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("INSERT INTO User VALUES (?,?,?)");
      preparedStatement.setObject(1,user.getUserName());
      preparedStatement.setObject(2,user.getPassword());
      preparedStatement.setObject(3,user.getEID());

      int executeUpdate = preparedStatement.executeUpdate();
      if (executeUpdate>0) {
           return true;
        }
      return false;
   }


  /*  public static boolean checkUser(User user) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection()
                .prepareStatement("SELECT password,role FROM User WHERE UID=?");
        preparedStatement.setObject(1,user.getUserName());

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setPassword(resultSet.getString(1));
            user.setRole(resultSet.getString(2));
            return true;
        }
        return false;
    }*/
}
