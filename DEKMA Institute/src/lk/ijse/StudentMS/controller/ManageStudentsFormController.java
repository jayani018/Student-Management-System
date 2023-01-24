package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.dao.EmployeeModelDAOImpl;
import lk.ijse.StudentMS.dao.StudentModelDAOImpl;
import lk.ijse.StudentMS.model.EmployeeDTO;
import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class ManageStudentsFormController {


    public TableColumn Stream;
    public TableColumn StudentId;
    public TableColumn NIC;
    public TableColumn Name;
    public TableColumn Address;
    public TableColumn Email;
    public TableColumn CNumber;
    public TableColumn EY;
    public AnchorPane pane;
    public TableView Student;
    public JFXTextField Search;
    public JFXTextField txtID;
    public JFXTextField txtNIC;
    public JFXTextField txtName;
    public JFXTextField txtAdress;
    public JFXTextField txtEmail;
    public JFXTextField txtCNo;
    public JFXTextField txtEY;
    public JFXTextField txtStream;
    public JFXComboBox<String> combEmployeeId;
    public TextField text;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    public void initialize() {

        Pattern patternId = Pattern.compile("^(S0)[0-9]{2,4}$");
        Pattern patternName = Pattern.compile("^[A-z ]{3,}$");
        Pattern patternAddress = Pattern.compile("^[A-z0-9 ,/]{5,}$");
        Pattern patternContact = Pattern.compile("^(071|072|077|076|078|075)[0-9]{7}$");
        Pattern patternNic = Pattern.compile("^[0-9]{9}[v]$");
        Pattern patternStream = Pattern.compile("^[A-z0-9]{3,}$");
        Pattern patternEmail = Pattern.compile("^[A-z0-9 ,/]{3,}(@gmail.com)$");

        map.put(txtID, patternId);
        map.put(txtNIC, patternNic);
        map.put(txtName, patternName);
        map.put(txtAdress, patternAddress);
        map.put(txtEmail, patternEmail);
        map.put(txtCNo, patternContact);
        map.put(txtStream, patternStream);


        StudentId.setCellValueFactory(new PropertyValueFactory<>("SID"));
        NIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        CNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        EY.setCellValueFactory(new PropertyValueFactory<>("exam_year"));
        Stream.setCellValueFactory(new PropertyValueFactory<>("stream"));

        try {
            cmbLoadData();
            LoadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }



    private Object validate() {
        for (TextField key : map.keySet()) {
            Pattern pattern = map.get(key);
            if (!pattern.matcher(key.getText()).matches()) {
                addError(key);
                return key;
            } else
                removeError(key);
        }
        return true;
    }

    public void removeError(TextField text) {
        text.setStyle("-fx-border-color: green");
//        btnModifyBooking.setDisable(false);
    }

    public void addError(TextField text) {
        if (text.getText().length() > 0) {
            text.setStyle("-fx-border-color: red");
        }
//        btnModifyBooking.setDisable(true);
    }




    private void LoadTableData() {
        ObservableList<StudentDTO> StudentList = FXCollections.observableArrayList();
        try {
            ArrayList<StudentDTO> StudentData = StudentModelDAOImpl.loadStudent();
            for (StudentDTO student : StudentData) {
                StudentList.add(student);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        Student.setItems(StudentList);
    }


    public void btnUpdateStudent(ActionEvent actionEvent) {


        StudentDTO student = new StudentDTO(combEmployeeId.getValue(), txtID.getText(), txtName.getText(), txtEmail.getText(),
                txtEY.getText(), txtNIC.getText(), txtAdress.getText(), txtCNo.getText(), txtStream.getText());


        try {
            boolean updateStudent = StudentModelDAOImpl.updateStudent(student);
            if (updateStudent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Update is successful");
                alert.show();
                LoadTableData();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    private void cmbLoadData() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> arrayList = EmployeeModelDAOImpl.loadEmployee();
        ObservableList obList = FXCollections.observableArrayList();
        for (EmployeeDTO emp : arrayList) {
            obList.add(emp.getEID());
        }
        combEmployeeId.setItems(obList);
    }


    public void btnSearch(ActionEvent actionEvent) {
        String search = Search.getText();
        StudentDTO student = new StudentDTO();
        student.setSID(search);
        try {
            boolean searchStudent = StudentModelDAOImpl.searchStudent(student);
            if (searchStudent) {
                combEmployeeId.setValue(student.getEID());
                txtID.setText(search);
                txtNIC.setText(student.getNIC());
                txtStream.setText(student.getStream());
                txtEY.setText(student.getExam_year());
                txtName.setText(student.getName());
                txtAdress.setText(student.getAddress());
                txtCNo.setText(student.getContact());
                txtEmail.setText(student.getContact());
                Search.setText("");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void clear() {
        txtID.clear();
        txtNIC.clear();
        txtStream.clear();
        txtEY.clear();
        txtName.clear();
        txtAdress.clear();
        txtCNo.clear();
        txtEmail.clear();
    }

    public void btnAddStudent() {

        StudentDTO student = new StudentDTO(combEmployeeId.getValue(), txtID.getText(), txtName.getText(), txtEmail.getText(),
                txtEY.getText(), txtNIC.getText(), txtAdress.getText(), txtCNo.getText(), txtStream.getText());

        try {
            boolean isAdded = StudentModelDAOImpl.addStudent(student);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Added!").show();
                LoadTableData();
                clear();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    public void btnDeleteStudent(ActionEvent actionEvent) {
        StudentDTO student = new StudentDTO(combEmployeeId.getValue(), txtID.getText(), txtName.getText(), txtEmail.getText(),
                txtEY.getText(), txtNIC.getText(), txtAdress.getText(), txtCNo.getText(), txtStream.getText());

        try {
            boolean isDeleted = StudentModelDAOImpl.deleteStudent(student);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted Successfully!").show();
                LoadTableData();
            }else {
                new Alert(Alert.AlertType.WARNING, "Student not Deleted!").show();
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }


    public void stuOnKeyReleased(KeyEvent keyEvent) {
        validate();

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object responds = validate();

            if (responds instanceof TextField) {
                TextField textField = (TextField) responds;
                textField.requestFocus();
            } else {
                btnAddStudent();
            }
        }
    }
}
