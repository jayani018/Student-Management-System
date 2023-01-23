package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManageResultsController {
    public AnchorPane pane;
    public TableView Results;
    public TableColumn SID;
    public TableColumn SubID;
    public TableColumn Result;
    public TableColumn PassORFail;
    public JFXTextField Search;

    public void btnAddResult(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/StudentMS/view/SuccessfullForm.fxml.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    public void btnUpdateResult(ActionEvent actionEvent) {
    }

    public void btnDeleteResult(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void btnSearch(ActionEvent actionEvent) {
    }
}
