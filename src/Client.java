import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the IP address of a machine running the server:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String serverAddress = br.readLine();
        Socket socket2 = new Socket(serverAddress, 9090);

        // Streams for conversing with server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));

        // Consume and display welcome message from the server
        System.out.println(in.readLine());

        System.out.println("\nEnter a string to send to the server (empty to quit):");
        String s;
        while((s = br.readLine()) != null && s.length() != 0) {
            out.write(s+"\n");
            out.flush();
            String response = in.readLine();
            System.out.println(response);
            System.out.println("\nEnter a string to send to the server (empty to quit):");
        }
        socket2.close();
        System.out.println("Connection to the server is closed!");
    }
}
