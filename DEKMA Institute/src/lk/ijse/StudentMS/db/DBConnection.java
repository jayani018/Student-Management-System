package lk.ijse.StudentMS.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dBConnection;
    private Connection connection;
    DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dekmainstitute", "root", "1234");
    }
    public Connection getConnection(){
        return connection;
    }


    public static DBConnection getdBConnection() throws SQLException, ClassNotFoundException {
        if(dBConnection==null){
            dBConnection=new DBConnection();
        }
        return dBConnection;
    }
}
