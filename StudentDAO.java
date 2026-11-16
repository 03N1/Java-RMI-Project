
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // CREATE: Save a student in the database
    public boolean addStudent(Student student) {

        String sql = "INSERT INTO students (first_name, last_name, email) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.setString(3, student.getEmail());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ: Retrieve all students from the database
    public void displayStudents() {

        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("first_name") + " | " +
                                rs.getString("last_name") + " | " +
                                rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
