package network;

import java.io.*;
import java.net.*;

public class simpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234); // connect to server

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hello from client!"); // send message

        String reply = in.readLine(); // read reply
        System.out.println("Received from server: " + reply);

        socket.close();
    }
}
