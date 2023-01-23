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
import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.model.BatchModel;
import lk.ijse.StudentMS.model.StudentModel;
import lk.ijse.StudentMS.to.Batch;
import lk.ijse.StudentMS.to.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BatchFormController {
    public AnchorPane pane;
    public TableView tblStudentBatch;
    public TableColumn BID;
    public TableColumn Year;
    public TableColumn SID;
    public JFXTextField Search;
    public JFXComboBox combStudentId;
    public JFXTextField txtBatchId;
    public JFXTextField txtYear;


    public void btnAddBatch(ActionEvent actionEvent) {
        String studentId = String.valueOf(combStudentId.getValue());
        String id = txtBatchId.getText();
        String year = txtYear.getText();
        Batch batch = new Batch(studentId,id,year);

        try {
            boolean addBatch = BatchModel.addBatch(batch);
            if (addBatch) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "added");
                alert.show();
                tableInit();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteBatch(ActionEvent actionEvent) {
        String batchId = txtBatchId.getText();
        Batch batch = new Batch();
        batch.setBID(batchId);
        try {
            boolean deleteBatch = BatchModel.deleteBatch(batch);
            if (deleteBatch) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete is successful");
                alert.show();
                txtBatchId.setText(null);
                txtYear.setText(null);
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnUpdateBatch(ActionEvent actionEvent) {
        String studentId = String.valueOf(combStudentId.getValue());
        String BID = txtBatchId.getText();
        String year = txtYear.getText();

        Batch batch=new Batch(studentId,BID,year);

        try {
            boolean updateBatch = BatchModel.updateBatch(batch);
            if (updateBatch) {
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

    public void btnSearch(ActionEvent actionEvent) {
            String search = Search.getText();
            Batch batch=new Batch();
            batch.setBID(search);
            try {
                boolean searchBatch = BatchModel.searchBatch(batch);
                if (searchBatch) {
                    txtBatchId.setText(search);
                    txtYear.setText(batch.getYear());
                    Search.setText("");
                }else{
                    Alert alert=new Alert(Alert.AlertType.ERROR,"error");
                    alert.show();
                }

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }


   /* public void txtSearchOnAction(ActionEvent actionEvent) {
    }
*/
    private void cmbLoadData() {
        try {

            ArrayList<Student> arrayList = StudentModel.loadStudent();

            String[] Student = new String[arrayList.size()];

            for (int i = 0; i < arrayList.size(); i++) {
                Student[i] = arrayList.get(i).getSID();
            }

            combStudentId.getItems().setAll(Student);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
   /* public void initialize(){
        cmbLoadData();
    }*/


    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    ObservableList<Batch> obs = FXCollections.observableArrayList();
    private ObservableList tableLoad(ObservableList<Batch> obs) {
        try {
            Connection connection = DBConnection.getdBConnection().getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from Batch");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                this.obs.add(new Batch(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3)


                        )

                );
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return obs;
    }

    private void tableInit(){

        ObservableList<Batch> BatchList = FXCollections.observableArrayList();
        try {
            ArrayList<Batch> BatchData = BatchModel.loadBatch();
            for (Batch batch : BatchData) {
                BatchList.add(batch);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        tblStudentBatch.setItems(BatchList);

    }

    public void initialize(){
        BID.setCellValueFactory(new PropertyValueFactory<>("BID"));
        Year.setCellValueFactory(new PropertyValueFactory<>("year"));
        SID.setCellValueFactory(new PropertyValueFactory<>("SID"));
        cmbLoadData();
        tableInit();
    }
}
