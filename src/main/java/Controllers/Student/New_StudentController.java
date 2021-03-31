package Controllers.Student;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

import DBConnection.DBHandler;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Ornob
 */
public class New_StudentController implements Initializable {

    @FXML
    private TextField reg_txt_username;
    @FXML
    private TextField reg_txt_reg_no;
    @FXML
    private TextField reg_txt_email;
    @FXML
    private TextField reg_txt_phnmb;
    @FXML
    private TextField reg_txt_hostel_name;
    @FXML
    private TextField reg_txt_address;
    @FXML
    private TextField reg_txt_guardname;
    @FXML
    private TextField reg_txt_guardtel;


    /**
     * Initializes the controller class.
     */
    private Connection connection;
    private PreparedStatement pst;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_reg_student;
    @FXML
    private Button btn_cam_open;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new DBHandler();
    }

    @FXML
    private void registerButtonAction(MouseEvent event) {
        String userName = reg_txt_username.getText();
        String reg_no = reg_txt_reg_no.getText();
        String email = reg_txt_email.getText();
        String phoneNumber = reg_txt_phnmb.getText();
        String hostel_name = reg_txt_hostel_name.getText();
        String address = reg_txt_address.getText();
        String guardName = reg_txt_guardname.getText();
        String guardTel = reg_txt_guardtel.getText();

        if (userName.equals("")
                || reg_no.equals("")
                || email.equals("")
                || phoneNumber.equals("")
                || hostel_name.equals("")
                || address.equals("")
                || guardName.equals("")
                || guardTel.equals("")) {
            JOptionPane.showMessageDialog(null, "All Fields Are Required!");
            setTExtRefresh();
        } else {
            String insert = "INSERT INTO register_Students(name,reg_no,email,phoneNumber,hostel_name,address,guardName,guardTel)" + "VALUES(?,?,?,?,?,?,?,?)";
            connection = DBHandler.connectDB();
            try {
                pst = connection.prepareStatement(insert);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                pst.setString(1, reg_txt_username.getText());
                pst.setString(2, reg_txt_reg_no.getText());
                pst.setString(3, reg_txt_email.getText());
                pst.setString(4, reg_txt_phnmb.getText());
                pst.setString(5, reg_txt_hostel_name.getText());
                pst.setString(6, reg_txt_address.getText());
                pst.setString(7, reg_txt_guardname.getText());
                pst.setString(8, reg_txt_guardtel.getText());

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registered!");
                setTExtRefresh();
            } catch (SQLException ex) {
                Logger.getLogger(New_StudentController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    @FXML
    private void back_btn_clicked(MouseEvent event) throws IOException {
        btn_back.getScene().getWindow().hide();

        Stage stu_Menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Student/Student_Menu.fxml"));
        Scene scene = new Scene(root);
        stu_Menu.initStyle(StageStyle.TRANSPARENT);
        stu_Menu.setScene(scene);
        stu_Menu.show();
        stu_Menu.setResizable(false);
    }

    @FXML
    private void cam_open_clicked(MouseEvent event) throws IOException {


        Camera camera = new Camera();
        String id= camera.camera_Open();
        reg_txt_reg_no.setText(id);
        String name = camera.scan();
        reg_txt_username.setText(name);
    }

    @FXML
    private void setTExtRefresh() {
        reg_txt_username.setText("");
        reg_txt_reg_no.setText("");
        reg_txt_email.setText("");
        reg_txt_phnmb.setText("");
        reg_txt_hostel_name.setText("");
        reg_txt_address.setText("");
        reg_txt_guardname.setText("");
        reg_txt_guardtel.setText("");
    }
}
