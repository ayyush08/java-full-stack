import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer() {
        // Can also be implemented using an anonymous inner class
        // return new Consumer<Socket>() {
        // @Override
        // public void accept(Socket clientSocket) {
        // try {
        // PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
        // toClient.println("Hello, client! This is a message from the server.");
        // toClient.close();
        // clientSocket.close();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // };
        // Here we are using lambda expression to implement the Consumer interface,
        // which is more concise and easier to read
        return (clientSocket) -> {
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
                toClient.println("Hello, client! This is a message from the server.");
                toClient.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket acceptedSocket = serverSocket.accept();
                // after accepting the connection, we can create a new thread for each client to
                // handle the communication
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));

                thread.start();

            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}