package Controllers.Employee;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import DBConnection.DBHandler;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.StageStyle;

public class Employee_feeController implements Initializable {

    @FXML
    private Button btn_back;
    @FXML
    private TextField emplyeeID;
     @FXML
    private TextField employeeFee;
    @FXML
    private Button submit;

 @FXML
    private ComboBox<String> month;

 @FXML
    private ComboBox<String> year;
    /**
     * Initializes the controller class.
     */
    private Connection connection;
    private PreparedStatement pst;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new DBHandler();
     


         ObservableList<String> list = FXCollections.observableArrayList("January","February","March","April","May","June","July","August","September","October","November","December");
         month.setItems(list);
         
         ObservableList<String> list2 = FXCollections.observableArrayList("2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030");
         year.setItems(list2);
    }
 @FXML
    private void back_btn_clicked(MouseEvent event) throws IOException {
     
       btn_back.getScene().getWindow().hide();

        Stage stu_Menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Employee/Employee_Menu.fxml"));
        Scene scene = new Scene(root);
        stu_Menu.initStyle(StageStyle.TRANSPARENT);
        stu_Menu.setScene(scene);
        stu_Menu.show();
        stu_Menu.setResizable(false);
    }

    @FXML
    private void submitButtonAction(MouseEvent event) {
         if (emplyeeID.equals("")) {
            JOptionPane.showMessageDialog(null, "All Fields Are Required!");
            setTExtRefresh();
        } else {
            
             
            String insert = "INSERT INTO employee_fee(employeeid,year,salary,month)" + "VALUES(?,?,?,?)";
            connection = DBHandler.connectDB();
            try {
                pst = connection.prepareStatement(insert);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                pst.setString(1, emplyeeID.getText());
                pst.setString(2, year.getValue().toString() );
                pst.setString(3, employeeFee.getText());
                pst.setString(4, month.getValue().toString());

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Done!");
                setTExtRefresh();
            } catch (SQLException ex) {
                Logger.getLogger(Employee_feeController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    private void setTExtRefresh() {
    	
    }
}