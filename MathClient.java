
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MathClient {

    public static void main(String[] args) {

        try {
            // Connect to the RMI Registry on the server
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Find the remote mathematics object
            IRemoteMath remoteMath = (IRemoteMath) registry.lookup("Compute");

            // Call remote methods
            System.out.println("1.7 + 2.8 = " + remoteMath.add(1.7, 2.8));

            System.out.println("6.7 - 2.3 = " + remoteMath.subtract(6.7, 2.3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
