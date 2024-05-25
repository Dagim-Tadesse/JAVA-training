package network;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AddClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        try (Scanner scanner = new Scanner(System.in)) {
            // Read welcome message
            System.out.println(in.readLine());

            // Send a number
            System.out.print("Enter a number to send: ");
            String number = scanner.nextLine();
            out.println(number);
        }

        // Print result from server
        while (true) {
            String response = in.readLine();
            if (response == null)
                break;
            System.out.println("Server: " + response);
        }

        socket.close();
    }
}
