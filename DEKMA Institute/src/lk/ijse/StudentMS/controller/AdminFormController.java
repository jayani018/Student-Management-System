package lk.ijse.StudentMS.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class AdminFormController {


    public AnchorPane fullPane;
    public AnchorPane dashBordPane;
    public AnchorPane pane;

    @FXML
    void btnLogout(ActionEvent event) throws IOException {
       /* Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/StudentMS/view/LoginForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);*/
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(new Scene(load(getClass().getResource("/lk/ijse/StudentMS/view/LoginForm.fxml"))));
        stage.show();

    }

    @FXML
    void btnMEmployee(ActionEvent event) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/ManageEmployeeForm.fxml"));
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
   /*void btnMTeacher(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/lk/ijse/StudentMS/view/ManageTeacherForm.fxml")));
        pane.getChildren().clear();
        pane.getChildren().add(parent);

    }
*/

    void btnSystemReports(ActionEvent event) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/SystemReports.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);

    }

    public void btnMBatch(ActionEvent actionEvent) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/BatchForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    public void btnMTeacher(ActionEvent actionEvent) throws IOException {
        Parent parent = load(getClass().getResource("/lk/ijse/StudentMS/view/ManageTeacherForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }
}
