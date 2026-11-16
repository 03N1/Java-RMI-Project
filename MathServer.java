
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MathServer {

    public static void main(String[] args) {

        try {
            // Create the remote mathematics object
            IRemoteMath remoteMath = new RemoteMathServant();

            // Start the RMI Registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Register the remote object
            registry.rebind("Compute", remoteMath);

            System.out.println("Math server ready!");
            System.out.println("Waiting for client requests...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
