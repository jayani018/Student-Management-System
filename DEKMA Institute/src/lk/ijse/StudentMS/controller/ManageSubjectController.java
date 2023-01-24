package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.dao.SubjectModelDAOImpl;
import lk.ijse.StudentMS.tm.SubjectTm;
import lk.ijse.StudentMS.model.SubjectDTO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageSubjectController {
    public AnchorPane pane;
    public TableView tblStudents;
    public TableColumn SubId;
    public TableColumn Name;
    public JFXTextField Search;
    public JFXTextField txtSubId;
    public JFXTextField txtName;
    public TableColumn Name1;

    public void btnAddSubject(ActionEvent actionEvent) throws IOException {
        String id = txtSubId.getText();
        String name = txtName.getText();
        SubjectDTO subject = new SubjectDTO(id,name);

        try {
            boolean addSubject = SubjectModelDAOImpl.addSubject(subject);
            if (addSubject){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Subject add is successful");
                alert.show();
                tableInit();
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
       /* Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/StudentMS/view/SuccessfullForm.fxml.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);*/
    }

    public void btnUpdateSubject(ActionEvent actionEvent) {
        String subId = txtSubId.getText();
        String name = txtName.getText();

        SubjectDTO subject=new SubjectDTO(subId,name);

        try {
            boolean updateSubject = SubjectModelDAOImpl.updateSubject(subject);
            if (updateSubject) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Update is successful");
                alert.show();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnDeleteSubject(ActionEvent actionEvent) {
        String subId = txtSubId.getText();
       /* Subject subject=new Subject();
        subject.setSUBID(subId);*/
        try {
            boolean deleteSubject = SubjectModelDAOImpl.deleteSubject(subId);//(subject);
            if (deleteSubject) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete is successful");
                alert.show();
                txtSubId.setText(null);
                txtName.setText(null);
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

  /*  public void search(){

    }*/
    public void txtSearchOnAction(ActionEvent actionEvent) {
        String search = Search.getText();
        SubjectDTO subject=new SubjectDTO();
        subject.setSUBID(search);
        try {
            boolean searchSubject = SubjectModelDAOImpl.searchSubject(subject);
            if (searchSubject) {
                txtSubId.setText(search);
                txtName.setText(subject.getSubName());
                Search.setText("");
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnSearch(ActionEvent actionEvent) {
        String search = Search.getText();
        SubjectDTO subject=new SubjectDTO();
        subject.setSUBID(search);
        try {
            boolean searchSubject = SubjectModelDAOImpl.searchSubject(subject);
            if (searchSubject) {
                txtSubId.setText(search);
                txtName.setText(subject.getSubName());
                Search.setText("");
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    ObservableList<SubjectTm> obs = FXCollections.observableArrayList();
    private ObservableList tableLoad(ObservableList<SubjectTm> obs) {
        try {
            Connection connection = DBConnection.getdBConnection().getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from Subject");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                this.obs.add(new SubjectTm(
                                resultSet.getString(1),
                                resultSet.getString(2)
                        )

                );
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return obs;
    }
    private void tableInit(){
        SubId.setCellValueFactory(new PropertyValueFactory<>("SUBID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("subName"));
        tblStudents.setItems(tableLoad(obs));
    }
    public void initialize(){
        tableInit();
    }
}
