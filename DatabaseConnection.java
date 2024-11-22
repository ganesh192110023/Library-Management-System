import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/library_db"; // Replace 'library_db' with your DB name
        String user = "root"; // Replace with your MySQL username
        String password = "yourpassword"; // Replace with your MySQL password
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}
