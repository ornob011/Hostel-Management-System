package Controllers.Student;

import Model.StudentDetails;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import DBConnection.DBHandler;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ornob
 */
public class All_Student_LivingController implements Initializable {

    // Initialize observable list to database
    private ObservableList<StudentDetails> data;

    @FXML
    private TableView<StudentDetails> tableStudent;
    @FXML
    private TableColumn<StudentDetails, String> col_id1;
    @FXML
    private TableColumn<StudentDetails, String> col_name1;
    @FXML
    private TableColumn<StudentDetails, String> col_reg_no1;
    @FXML
    private TableColumn<StudentDetails, String> col_email1;
    @FXML
    private TableColumn<StudentDetails, String> col_phonenumber1;
    @FXML
    private TableColumn<StudentDetails, String> col_hostel_name1;
    @FXML
    private TableColumn<StudentDetails, String> col_address1;
    @FXML
    private TableColumn<StudentDetails, String> col_g_name1;
    @FXML
    private TableColumn<StudentDetails, String> col_g_tel1;

    /**
     * Initializes the controller class.
     */
    private Connection connection;
    @FXML
    private Button btn_back;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connection = DBHandler.connectDB();
        data = FXCollections.observableArrayList();

        try {
            // Execure query
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM register_Students");

            while (rs.next()) {
                // get string from db
                data.add(new StudentDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        // set cell values
        col_id1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name1.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_reg_no1.setCellValueFactory(new PropertyValueFactory<>("reg_no"));
        col_email1.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_phonenumber1.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        col_hostel_name1.setCellValueFactory(new PropertyValueFactory<>("hostel_name"));
        col_address1.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_g_name1.setCellValueFactory(new PropertyValueFactory<>("guardName"));
        col_g_tel1.setCellValueFactory(new PropertyValueFactory<>("guardTel"));

        tableStudent.setItems(null);
        tableStudent.setItems(data);
    }

    @FXML
    private void back_btn_clicked(MouseEvent event) throws IOException {
        btn_back.getScene().getWindow().hide();

        Stage stu_Menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Student/Student_Menu.fxml"));
        Scene scene = new Scene(root);
        stu_Menu.setScene(scene);
        stu_Menu.initStyle(StageStyle.TRANSPARENT);
        stu_Menu.show();
        stu_Menu.setResizable(false);
    }
}
