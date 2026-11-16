
import java.sql.Connection;

public class TestDatabase {

    public static void main(String[] args) {

        try {
            Connection conn = DatabaseConnection.getConnection();

            System.out.println("Database connection successful!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
