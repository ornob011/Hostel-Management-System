package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ornob
 */
public class DBHandler {
    
    Connection con = null;

    public static Connection connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hostel_management", "root", "");
            return con;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.toString());
            return null;
        }
    }
}
