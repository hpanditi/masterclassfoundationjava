import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.lang.Runnable;
import java.io.*;

class ClientHandler implements Runnable {
    private Socket clientSocket;

    ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        // create input buffer and output buffer
        // wait for input from client and send response back to client
        // close all streams and sockets

        public class MainMalinaServer {

            private static final int PORT_NUMBER = 5000;
            private static ServerSocket serverSocket;
            private static ClientHandler clientHandler;
            private static Thread thread;

            public static void main(String[] args) throws IOException {
                serverSocket = new ServerSocket(5000);

                while (true) {
                    clientHandler = new ClientHandler(serverSocket.accept());
                    thread = new Thread(clientHandler);
                    thread.start();
                }
            }

            protected void finalize() throws IOException {
                serverSocket.close();
            }
        }
    }
}