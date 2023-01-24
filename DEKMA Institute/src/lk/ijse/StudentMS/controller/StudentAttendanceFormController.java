package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.dao.StudentAttendanceModelDAOImpl;
import lk.ijse.StudentMS.dao.StudentModelDAOImpl;
import lk.ijse.StudentMS.model.StudentDTO;
import lk.ijse.StudentMS.model.StudentAttendance;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAttendanceFormController {
    public AnchorPane pane;
    public TableView tblStudentAttendance;
    public TableColumn Date;
    public TableColumn Time;
    public JFXComboBox combStudentId;
    public JFXTextField txtTime;
    public JFXTextField txtDate;
    public JFXTextField Search;
    public JFXDatePicker txtdate;


    public void btnAddSA(ActionEvent actionEvent) {
        String studentId = String.valueOf(combStudentId.getValue());
        String date = txtDate.getText();
        String time = txtTime.getText();
        StudentAttendance studentAttendance = new StudentAttendance(studentId,date,time);
        try {
            boolean addAttendance = StudentAttendanceModelDAOImpl.addAttendance(studentAttendance);
            if (addAttendance) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"added");
                alert.show();
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateSA(ActionEvent actionEvent) {
    }

    public void btnDeleteSA(ActionEvent actionEvent) {
    }

    private void cmbLoadData() {
        try {

            ArrayList<StudentDTO> arrayList = StudentModelDAOImpl.loadStudent();

            String[] Student = new String[arrayList.size()];

            for (int i = 0; i < arrayList.size(); i++) {
                Student[i] = arrayList.get(i).getSID();
            }

            combStudentId.getItems().setAll(Student);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public void initialize(){
        cmbLoadData();
    }
}
