# HTTP-like-client-and-server-using-Java-RMI

This program simulates the behaviour of HTTP GET and PUT methods using Java RMI (Remote Method Invocation). It consists of three main components:

Shared Interface: Defines the remote methods.
Server-Side Implementation: Implements the remote methods.
Client: Interacts with the remote server to invoke the methods.

Program Design

Shared Interface (HTTPService):
•	Location: shared/HTTPService.java
•	Description: Defines the remote methods get and put.

•	Methods:
String get(String filename): Simulates the HTTP GET method. Takes a filename as an argument and returns the file content or an error message.
String put(String filename, String content): Simulates the HTTP PUT method. Takes a filename and content as arguments and writes the content to the file. Returns a success or error message.

Server-Side Implementation (HTTPServiceImpl):
•	Location: server/HTTPServiceImpl.java
•	Description: Implements the HTTPService interface.

•	Methods:
String get(String filename): Reads the file and returns its content if the file exists, or returns a "404 Not Found" message if the file does not exist.
String put(String filename, String content): Writes the content to the file and returns a success message, or an error message if the operation fails.



Server Setup (RMIServer):
•	Location: server/RMIServer.java
•	Description: Set up the RMI registry and bind the HTTPServiceImpl instance to the registry.

•	Steps:
Create an instance of HTTPServiceImpl.
Start the RMI registry on port 1099.
Bind the remote object to the RMI registry with the name "HTTPService".

Client (RMIClient):
•	Location: client/RMIClient.java
•	Description: Connects to the RMI server and invokes the get or put methods based on command-line arguments.

•	Steps:
Parse command-line arguments.
Look up the HTTPService object from the RMI registry using the provided URL.
Based on the method specified (GET or PUT), invoke the corresponding method on the remote object and display the response.
