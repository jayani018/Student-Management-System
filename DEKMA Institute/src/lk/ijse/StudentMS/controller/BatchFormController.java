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
import lk.ijse.StudentMS.dao.BatchModelDAOImpl;
import lk.ijse.StudentMS.dao.StudentModelDAOImpl;
import lk.ijse.StudentMS.model.BatchDTO;
import lk.ijse.StudentMS.model.StudentDTO;

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

    BatchModelDAOImpl batchModelDAO = new BatchModelDAOImpl();

    public void btnAddBatch(ActionEvent actionEvent) {
        String studentId = String.valueOf(combStudentId.getValue());
        String id = txtBatchId.getText();
        String year = txtYear.getText();
        BatchDTO batch = new BatchDTO(studentId,id,year);

        try {
            boolean addBatch = batchModelDAO.addBatch(batch);
            if (addBatch) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "added");
                alert.show();
                loadTableData();
                tableInit();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteBatch(ActionEvent actionEvent) {
        String batchId = txtBatchId.getText();
        BatchDTO batch = new BatchDTO();
        batch.setBID(batchId);
        try {
            boolean deleteBatch = batchModelDAO.deleteBatch(batch);
            if (deleteBatch) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete is successful");
                alert.show();
                loadTableData();
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

        BatchDTO batch=new BatchDTO(studentId,BID,year);

        try {
            boolean updateBatch = batchModelDAO.updateBatch(batch);
            if (updateBatch) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Update is successful");
                alert.show();
                loadTableData();
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
            BatchDTO batch=new BatchDTO();
            batch.setBID(search);
            try {
                boolean searchBatch = batchModelDAO.searchBatch(batch);
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

    private void loadTableData() {
        ObservableList<BatchDTO> BatchList = FXCollections.observableArrayList();
        try {
            ArrayList<BatchDTO> batchData = batchModelDAO.loadBatch();
            for (BatchDTO batch : batchData) {
                BatchList.add(batch);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        tblStudentBatch.setItems(BatchList);
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
   /* public void initialize(){
        cmbLoadData();
    }*/


    public void txtSearchOnAction(ActionEvent actionEvent) {
    }


    private void tableInit(){

        ObservableList<BatchDTO> BatchList = FXCollections.observableArrayList();
        try {
            ArrayList<BatchDTO> BatchData = BatchModelDAOImpl.loadBatch();
            for (BatchDTO batch : BatchData) {
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
        loadTableData();
    }
}
