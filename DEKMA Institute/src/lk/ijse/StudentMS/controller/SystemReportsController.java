package lk.ijse.StudentMS.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class SystemReportsController {

    @FXML
    private AnchorPane pane;





    public void studentPaymentOnAction(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/StudentMS/view/reports/StudentReport1.jrxml");

      //  HashMap<String,Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getdBConnection().getConnection());
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void teacherSalaryOnAction(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/StudentMS/view/reports/TeacherSalaryReports.jrxml");

        HashMap<String,Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, DBConnection.getdBConnection().getConnection());
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException | SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
