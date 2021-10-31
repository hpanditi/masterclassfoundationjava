import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A server program which accepts requests from clients to capitalize strings or show current date and time.
 * When clients connect, a new thread is started to handle an interactive dialog
 * in which the client sends in a string and the server thread sends back the
 * capitalized version of the string or the current data and time depending on the client's message.
 *
 * The server program runs in an infinite loop.
 */
public class Server {

    /**
     * Run the server listening on port 9090. When a
     * client connects, the server spawns a new thread to do the servicing
     * while the old thread keeps listening.  The server keeps a unique client
     * number for each client that connects just to show interesting logging
     * messages.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("The server is running.");
        int clientNumber = 1;
        ServerSocket listener = new ServerSocket(9090);
        while (true) {
            new Request(listener.accept(), clientNumber).start();
            clientNumber++;
        }
    }
}

/**
 * A thread to handle capitalization and time requests on a particular socket.
 */
class Request extends Thread  {
    private Socket socket1;
    private int ClientNumber;

    public Request(Socket socket, int clientNumber) {
        socket1 = socket;
        ClientNumber = clientNumber;
        System.out.println("New client #" + ClientNumber + " connected" );
    }

    /**
     * Services this thread's client by first sending the client a welcome
     * message then repeatedly reading strings and sending back the capitalized
     * version of the string, or the current date and time, depending on the client's message.
     */
    public void run()  {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
            // Send a welcome message to the client.

            out.write("Hello, you are client #" + ClientNumber+"\n");
            out.flush();

            // Get messages from the client, line by line; return them capitalized or the current date and time
            String s;

            while((s = in.readLine()) != null && s.length() != 0) {
                if(s.equals("time")) {
                    out.write(new Date().toString()+"\n");
                    out.flush();
                }
                else {
                    out.write(s.toUpperCase()+"\n");
                    out.flush();
                }
            }
            socket1.close();
        } catch (IOException e) {
            System.out.println("Error handling client #" + ClientNumber);
        }
        System.out.println("Connection with client # " + ClientNumber + " closed");
    }
}
