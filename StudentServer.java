
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StudentServer {

    public static void main(String[] args) {

        try {
            // Create the student service
            IStudentService service = new StudentService();

            // Start the RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Register the student service
            registry.rebind("StudentService", service);

            System.out.println("Student server ready!");
            System.out.println("Waiting for student requests...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
