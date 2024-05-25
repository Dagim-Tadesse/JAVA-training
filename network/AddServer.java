package network;

import java.io.*;
import java.net.*;
import java.util.*;

public class AddServer {
    private static Set<ClientHandler> clientHandlers = Collections.synchronizedSet(new HashSet<>());
    private static int totalSum = 0;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started...");

            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);
                clientHandlers.add(handler);
                new Thread(handler).start();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }

        public void run() {
            try {
                out.println("Connected to AddServer! Send a number:");
                String input = in.readLine();
                int number = Integer.parseInt(input);

                synchronized (AddServer.class) {
                    totalSum += number;
                }

                broadcast("New number received: " + number + " | Total sum: " + totalSum);
            } catch (Exception e) {
                System.out.println("Client disconnected or error: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                    clientHandlers.remove(this);
                } catch (IOException ignored) {
                }
            }
        }

        private void broadcast(String message) {
            synchronized (clientHandlers) {
                for (ClientHandler handler : clientHandlers) {
                    handler.out.println(message);
                }
            }
        }
    }
}
