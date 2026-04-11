import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void run() throws UnknownHostException, IOException {
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);
        PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromServer = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );
        toServer.println("Hello from client");
        String line = fromServer.readLine();
        System.out.println("Message from server: " + line);
        toServer.close();
        fromServer.close();
        socket.close();
    }
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.run();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
