package network;

import java.io.*;
import java.net.*;

public class simpleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // open port 1234
        System.out.println("Server is waiting for client...");

        Socket socket = serverSocket.accept(); // accept client connection
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = in.readLine(); // read message from client
        System.out.println("Received from client: " + message);

        out.println("Hello from server!"); // send reply

        socket.close();
        serverSocket.close();
    }
}
