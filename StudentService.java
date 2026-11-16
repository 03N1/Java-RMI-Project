
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentService extends UnicastRemoteObject implements IStudentService {

    public StudentService() throws RemoteException {
        super();
    }

    @Override
    public boolean addStudent(Student student) throws RemoteException {

        StudentDAO dao = new StudentDAO();
        return dao.addStudent(student);
    }

    @Override
    public List<Student> getAllStudents() throws RemoteException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"));

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
}
