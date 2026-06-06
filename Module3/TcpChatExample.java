import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpChatExample {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Run as: java TcpChatExample server | java TcpChatExample client");
            return;
        }

        if ("server".equalsIgnoreCase(args[0])) {
            runServer();
        } else if ("client".equalsIgnoreCase(args[0])) {
            runClient();
        } else {
            System.out.println("Unknown mode. Use 'server' or 'client'.");
        }
    }

    private static void runServer() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server listening on port 5000...");
            try (Socket client = serverSocket.accept();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
                writer.write("Welcome to the chat server!\n");
                writer.flush();
                String message = reader.readLine();
                System.out.println("Client says: " + message);
            }
        }
    }

    private static void runClient() throws Exception {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            System.out.println(reader.readLine());
            writer.write("Hello from client!\n");
            writer.flush();
        }
    }
}
