package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.model.PaymentsModel;
import lk.ijse.StudentMS.model.StudentModel;
import lk.ijse.StudentMS.to.Payments;
import lk.ijse.StudentMS.to.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagePaymentsFormController {
    public AnchorPane pane;
    public TableView Payments;
    public TableColumn cardNo;
    public TableColumn PaymentsM;
    public TableColumn Amount;
    public TableColumn Date;
    public TableColumn Time;
    public JFXTextField txtCardNo;
    public JFXTextField txtPaymentsMonth;
    public JFXTextField txtAmount;
    public JFXTextField txtDate;
    public JFXTextField txtTime;
    public JFXComboBox combStudentId;


    public void btnAddPayments(ActionEvent actionEvent) throws IOException {
        String id = String.valueOf(combStudentId.getValue());
        String cardNo = txtCardNo.getText();
        String amount = txtAmount.getText();
        String paymentsMonth = txtPaymentsMonth.getText();
        String time = txtTime.getText();
        Payments payments = new Payments(id,cardNo,amount,paymentsMonth,time);


        try {
            boolean addPayments = PaymentsModel.addPayments(payments);
            if (addPayments){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Payment add is successful");
                alert.show();
                tableLoad();
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdatePayment(ActionEvent actionEvent) {
        String studentId = String.valueOf(combStudentId.getValue());
        String cardNo = txtCardNo.getText();
        String amount = txtAmount.getText();
        String paymentsMonth = txtPaymentsMonth.getText();
        String time = txtTime.getText();

        Payments payments = new Payments(studentId,cardNo,amount,paymentsMonth,time);

        try {
            boolean updatePayments = PaymentsModel.updatePayments(payments);
            if (updatePayments) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Update is successful");
                alert.show();
                tableLoad();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnDeletePayment(ActionEvent actionEvent) {

    }

    private void cmbLoadData() throws SQLException, ClassNotFoundException {
        ArrayList<Student> arrayList = StudentModel.loadStudent();
        for (Student student: arrayList) {
            combStudentId.getItems().add(student.getSID());
        }
    }

    public void initialize(){
        cardNo.setCellValueFactory(new PropertyValueFactory<>("CarID"));
        PaymentsM.setCellValueFactory(new PropertyValueFactory<>("payment_months"));
        Amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        Time.setCellValueFactory(new PropertyValueFactory<>("time"));

        try {
            cmbLoadData();
            tableLoad();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void tableLoad() {
        ObservableList<Payments> StudentList = FXCollections.observableArrayList();
        try {
            ArrayList<Payments> StudentData = PaymentsModel.loadPayments();
            for (Payments student : StudentData) {
                StudentList.add(student);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        Payments.setItems(StudentList);
    }
}
