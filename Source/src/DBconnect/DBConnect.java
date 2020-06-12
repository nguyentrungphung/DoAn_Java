
package DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*; 

/**
 *
 * @author Nguyen
 */
public class DBConnect {
    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try{
            return DriverManager.getConnection("jdbc:sqlserver://Phung\\SQLEXPRESS:1433;databaseName=TheCoffee;user=sb;password=123456");
            }catch(SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
             
}
