
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IStudentService extends Remote {

    boolean addStudent(Student student) throws RemoteException;

    List<Student> getAllStudents() throws RemoteException;
}
