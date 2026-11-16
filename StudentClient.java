
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class StudentClient {

    public static void main(String[] args) {

        try {
            // Connect to the RMI server
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the student service
            IStudentService service = (IStudentService) registry.lookup("StudentService");

            // Create a student record
            Student student = new Student(
                    0,
                    "John",
                    "Kamau",
                    "john.kamau@example.com");

            // Send student information to the server
            boolean saved = service.addStudent(student);

            if (saved) {
                System.out.println("Student saved successfully!");
            } else {
                System.out.println("Student could not be saved.");
            }

            // Retrieve all students from the database
            System.out.println("\nStudent records:");

            List<Student> students = service.getAllStudents();

            for (Student s : students) {
                System.out.println(
                        s.getId() + " | " +
                                s.getFirstName() + " | " +
                                s.getLastName() + " | " +
                                s.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
