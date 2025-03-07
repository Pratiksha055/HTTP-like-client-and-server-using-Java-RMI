package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * HTTPService interface defines the remote methods that can be invoked by the client.
 * It includes methods to simulate HTTP GET and PUT operations.
 */
public interface HTTPService extends Remote {
    /**
     * Simulates the HTTP GET method.
     * 
     * @param filename The name of the file to be retrieved.
     * @return The content of the file or an error message.
     * @throws RemoteException If there is a remote communication error.
     */
    String get(String filename) throws RemoteException;

    /**
     * Simulates the HTTP PUT method.
     * 
     * @param filename The name of the file to be created.
     * @param content The content to be written to the file.
     * @return A success or error message.
     * @throws RemoteException If there is a remote communication error.
     */
    String put(String filename, String content) throws RemoteException;
}
