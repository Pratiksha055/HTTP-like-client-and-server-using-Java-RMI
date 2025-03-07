package client;

import shared.HTTPService;
import java.rmi.Naming;

/**
 * RMIClient interacts with the HTTPService on the server.
 * It supports invoking GET and PUT methods.
 */
public class RMIClient {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java client.RMIClient <server-rmi-url> <GET|PUT> <filename> [content]");
            return;
        }

        try {
            String serverUrl = args[0]; // The RMI URL of the server
            String method = args[1]; // The method to invoke (GET or PUT)
            String filename = args[2]; // The filename for GET or PUT

            // Look up the remote object from the RMI registry
            HTTPService httpService = (HTTPService) Naming.lookup(serverUrl);

            if ("GET".equalsIgnoreCase(method)) {
                // Call the get method and print the response
                String response = httpService.get(filename);
                System.out.println(response);
            } else if ("PUT".equalsIgnoreCase(method)) {
                if (args.length < 4) {
                    System.out.println("Usage: java client.RMIClient <server-rmi-url> PUT <filename> <content>");
                    return;
                }
                String content = args[3]; // The content for PUT
                // Call the put method and print the response
                String response = httpService.put(filename, content);
                System.out.println(response);
            } else {
                System.out.println("Invalid method. Use GET or PUT.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
