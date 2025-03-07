package server;

import shared.HTTPService;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * HTTPServiceImpl is the implementation of the HTTPService interface.
 * It provides the functionality for the GET and PUT methods.
 */
public class HTTPServiceImpl extends UnicastRemoteObject implements HTTPService {
    protected HTTPServiceImpl() throws RemoteException {
        super();
    }

    /**
     * Simulates the HTTP GET method.
     * 
     * @param filename The name of the file to be retrieved.
     * @return The content of the file or an error message.
     * @throws RemoteException If there is a remote communication error.
     */
    @Override
    public String get(String filename) throws RemoteException {
        File file = new File(filename);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return "200 OK\n" + content.toString();
            } catch (IOException e) {
                return "500 Internal Server Error\n" + e.getMessage();
            }
        } else {
            return "404 Not Found";
        }
    }

    /**
     * Simulates the HTTP PUT method.
     * 
     * @param filename The name of the file to be created.
     * @param content The content to be written to the file.
     * @return A success or error message.
     * @throws RemoteException If there is a remote communication error.
     */
    @Override
    public String put(String filename, String content) throws RemoteException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(content);
            return "200 OK File Created";
        } catch (IOException e) {
            return "500 Internal Server Error\n" + e.getMessage();
        }
    }
}
