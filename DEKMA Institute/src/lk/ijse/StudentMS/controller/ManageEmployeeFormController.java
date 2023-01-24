package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.dao.EmployeeModelDAOImpl;
import lk.ijse.StudentMS.model.EmployeeDTO;
import lk.ijse.StudentMS.model.UserDTO;
import lk.ijse.StudentMS.model.UserModelDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageEmployeeFormController {
    public AnchorPane pane;
    public TableView table;
    public TableColumn EID;
    public TableColumn NIC;
    public TableColumn Name;
    public TableColumn Address;
    public TableColumn Email;
    public TableColumn CNumber;
    public TableColumn Salary;
    public TableColumn cashOrCard;
    public TableColumn Role;
    public JFXTextField Search;
    public JFXTextField txtId;
    public JFXTextField txtNIC;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtSalary;
    public JFXTextField txtCashOrCard;
    public JFXRadioButton RadioButtonTeacher;
    public ToggleGroup jobRole;
    public JFXRadioButton RadioButtonManager;
    public JFXRadioButton RadioButtonOther;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    private String role;

    EmployeeModelDAOImpl employeeModelDAO = new EmployeeModelDAOImpl();

    public void btnAddEmployee(ActionEvent actionEvent) throws IOException {
        String id = txtId.getText();
        String nic = txtNIC.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String cashOrCard = txtCashOrCard.getText();
        String password = txtPassword.getText();
        String userName = txtUserName.getText();

        if (role.equals("Manager")) {
            if (!password.equals("") && !userName.equals("")) {
                EmployeeDTO employee = new EmployeeDTO(id, nic, name, address, contact, email, salary/*,cashOrCard, role*/);
                UserDTO user = new UserDTO(id, userName, password);
                try {

                    boolean addEmployee = employeeModelDAO.addEmployee(employee);
                    boolean addUser = UserModelDAOImpl.addUser(user);
                    if (addEmployee && addUser) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "added");
                        alert.show();
                    }

                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            } else {

            }

        } else {
            EmployeeDTO employee = new EmployeeDTO(id, nic, name, address, contact, email, salary/*,cashOrCard, role*/);
            try {
                boolean addEmployee = EmployeeModelDAOImpl.addEmployee(employee);
                if (addEmployee) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "added");
                    alert.show();
                }

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

    }

   public void btnUpdateEmployee(ActionEvent actionEvent) {
       String id = txtId.getText();
       String nic = txtNIC.getText();
       String name = txtName.getText();
       String address = txtAddress.getText();
       String contact = txtContact.getText();
       String email = txtEmail.getText();
       double salary = Double.parseDouble(txtSalary.getText());
       String cashOrCard = txtCashOrCard.getText();
       String userName = txtUserName.getText();
       String password = txtPassword.getText();


       if (role.equals("Manager")) {
           if (!password.equals("") && !userName.equals("")) {
               EmployeeDTO employee = new EmployeeDTO(id, nic, name, address, contact, email, salary/*,cashOrCard*/, role);
               UserDTO user = new UserDTO(id, userName, password);
               try {

                   boolean updateEmployee = employeeModelDAO.updateEmployee(employee);
                   boolean addUser = UserModelDAOImpl.addUser(user);
                   if (updateEmployee && addUser) {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION, "Update");
                       alert.show();
                   }

               } catch (ClassNotFoundException | SQLException e) {
                   e.printStackTrace();
               }
           } else {

           }

       } else {

           EmployeeDTO employee = new EmployeeDTO(id, nic, name, address, contact, email, salary,cashOrCard);

           try {
               boolean updateEmployee = EmployeeModelDAOImpl.updateEmployee(employee);
               if (updateEmployee) {
                   Alert alert = new Alert(Alert.AlertType.INFORMATION, "Update is successful");
                   alert.show();
               } else {
                   Alert alert = new Alert(Alert.AlertType.ERROR, "error");
                   alert.show();
               }

           } catch (SQLException | ClassNotFoundException throwables) {
               throwables.printStackTrace();
           }
       }
   }

    public void btnDeleteEmployee(ActionEvent actionEvent) {
       // String id = txtId.getText();

      //  EmployeeDTO employee = new EmployeeDTO(rst.getString("EID"), rst.getString("NIC"), rst.getString("name"), rst.getString("address"), rst.getString("contact"), rst.getString("email"), rst.getDouble("salary"));
        EmployeeDTO employee = new EmployeeDTO(txtId.getText(), txtNIC.getText(), txtName.getText(), txtAddress.getText(), txtContact.getText(), txtEmail.getText(), txtSalary.getText());
        //  employee.setEID(id);


        try {
            boolean deleteEmployee = employeeModelDAO.deleteEmployee(employee);
            if (deleteEmployee) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete is successful");
                alert.show();
                 txtId.setText(null);
                 txtNIC.setText(null);
                 txtName.setText(null);
                 txtAddress.setText(null);
                 txtContact.setText(null);
                 txtName.setText(null);
                 txtAddress.setText(null);
                 txtContact.setText(null);
                 txtEmail.setText(null);
                 txtSalary.setText(null);
                 txtCashOrCard.setText(null);
                 txtUserName.setText(null);
                 txtPassword.setText(null);

            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void radioButtonOnActionTeacher(ActionEvent actionEvent) {
        role = RadioButtonTeacher.getText();
        txtUserName.setVisible(false);
        txtPassword.setVisible(false);
    }


    public void radioButtonOnActionManager(ActionEvent actionEvent) {
        role = RadioButtonManager.getText();
        txtUserName.setVisible(true);
        txtPassword.setVisible(true);
    }


    public void radioButtonOnActionOther(ActionEvent actionEvent) {
        role = RadioButtonOther.getText();
        txtUserName.setVisible(false);
        txtPassword.setVisible(false);
    }

        public void initialize () {
            txtUserName.setVisible(false);
            txtPassword.setVisible(false);

        }

    public void btnSearchEmployee(ActionEvent actionEvent) {
        String search = Search.getText();
      //  EmployeeDTO employee=new EmployeeDTO(rst.getString("EID"), rst.getString("NIC"), rst.getString("name"), rst.getString("address"), rst.getString("contact"), rst.getString("email"), rst.getDouble("salary"));
        EmployeeDTO employee = new EmployeeDTO(txtId.getText(), txtNIC.getText(), txtName.getText(), txtAddress.getText(), txtContact.getText(), txtEmail.getText(), txtSalary.getText());

        employee.setEID(search);
        try {
            boolean searchEmployee = employeeModelDAO.searchEmployee(employee);
            if (searchEmployee) {
                txtId.setText(search);
                txtNIC.setText(employee.getNIC());
                txtName.setText(employee.getName());
                txtAddress.setText(employee.getAddress());
                txtContact.setText(employee.getContact());
                txtEmail.setText(employee.getEmail());
                txtSalary.setText(String.valueOf(employee.getSalary()));

             //   txtName.setText(subject.getSubName());
                Search.setText("");
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public void searchOnAction(ActionEvent actionEvent) {
    }

    ObservableList<EmployeeDTO> obs = FXCollections.observableArrayList();
    private ObservableList tableLoad(ObservableList<EmployeeDTO> obs) {
       // ArrayList<EmployeeDTO> arrayList=new ArrayList<>();
        try {
            ArrayList<EmployeeDTO> employeeList=employeeModelDAO.loadEmployee();
            for (EmployeeDTO employee :employeeList ) {
                employeeList.add(employee);

            }
//            Connection connection = DBConnection.getdBConnection().getConnection();
//            PreparedStatement pst = connection.prepareStatement("select * from Employee");
//            ResultSet resultSet = pst.executeQuery();

//            while (resultSet.next()) {
//                this.obs.add(new EmployeeDTO(
//                                resultSet.getString(1),
//                                resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getString(4),
//                        resultSet.getString(5),
//                        resultSet.getString(6),
//                        resultSet.getDouble(7),
//                        resultSet.getString(8),
//                        resultSet.getString(9)
//
//                        )
//
//                );
//            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return obs;
    }

    private void tableInit(){
        EID.setCellValueFactory(new PropertyValueFactory<>("EID"));
        NIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        CNumber.setCellValueFactory(new PropertyValueFactory<>("Contact No"));
        Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
       // cashOrCard.setCellValueFactory(new PropertyValueFactory<>("Cash/Card"));
       // Role.setCellValueFactory(new PropertyValueFactory<>("Role"));
        table.setItems(tableLoad(obs));
    }
    public void initial(){
        tableInit();
    }

}

