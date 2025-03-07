package server;

import shared.HTTPService;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * RMIServer sets up the RMI registry and binds the HTTPService implementation to it.
 */
public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the HTTPServiceImpl
            HTTPService httpService = new HTTPServiceImpl();

            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to a name in the RMI registry
            Naming.rebind("rmi://localhost:1099/HTTPService", httpService);
            System.out.println("Server started...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
