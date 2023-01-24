package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.StudentMS.model.UserDTO;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFormController<userName> {

    public AnchorPane pane;
    public Label lblName;
    public JFXButton btnLogin;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPassword;

    public Label lblNameWarning;
    @FXML
    private Label lblPasswordWarning;

    private Matcher nameMatcher;
    private Matcher passwordMatcher;

    private void setPatterns() {
        Pattern namePattern = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        nameMatcher = namePattern.matcher(txtName.getText());
    }
    public void initialize() {
        setPatterns();
    }



    public void FogotPassword(ActionEvent actionEvent) {

    }

    public void CreateNAOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/StudentMS/view/CreateAccountForm.fxml"))));
        stage.show();

    }


    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        String name = txtName.getText();
        String password = txtPassword.getText();

        UserDTO employee = new UserDTO();


        if (Pattern.compile("^[a-zA-Z0-9]{0,10}$").matcher(txtName.getText()).matches()) {
            if (Pattern.compile("^[a-zA-Z0-9]{0,10}$").matcher(txtPassword.getText()).matches()) {
                if (txtName.getText().trim().equals("Admin") || txtName.getText().trim().equals("Manage"))  {
                    if (txtPassword.getText().trim().equals("1234") || txtPassword.getText().trim().equals("1234")) {
                        Stage newStage = new Stage();

                        if (txtName.getText().trim().equals("Admin")){
                            newStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/StudentMS/view/AdminForm.fxml"))));
                            newStage.show();
                            Stage window = (Stage) btnLogin.getScene().getWindow();
                            window.close();
                        }else if (txtName.getText().trim().equals("Manage")){
                            newStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/StudentMS/view/ManagerForm.fxml"))));
                            newStage.show();
                            Stage window = (Stage) btnLogin.getScene().getWindow();
                            window.close();
                        }


                    } else {
                        new Alert(Alert.AlertType.WARNING, "Wrong Password").show();
                    }
                } else {
                    new Alert(Alert.AlertType.WARNING, "Wrong User Name").show();
                }
            }
        }

    }

    public void loginAcOnKeyRelesed(KeyEvent keyEvent) {

    }
}
