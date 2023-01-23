package lk.ijse.StudentMS.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class ManagerFormController {


    public AnchorPane fullPane;
    public AnchorPane dashBordPane;
    public AnchorPane pane;

    @FXML
    void btnLogout(ActionEvent event) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/LoginForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    @FXML
    void btnMPayments(ActionEvent event) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/ManagePaymentsForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);

    }

    @FXML
    void btnMResult(ActionEvent event) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/ManageResults.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);

    }

    @FXML
    void btnMStudent(ActionEvent event) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/ManageStudentsForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);

    }

    @FXML
    void btnMSubject(ActionEvent event) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/ManageSubject.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);

    }

    @FXML
    void btnMTeacher(ActionEvent event) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/ManageTeacherForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);

    }

    @FXML
    void btnSAttendance(ActionEvent event) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/StudentAttendanceForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);

    }

    @FXML
    void btnTimeSM(ActionEvent event) throws IOException {
       /* Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/StudentMS/view/"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);*/

    }

}
