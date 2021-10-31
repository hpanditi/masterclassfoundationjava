import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;

class MyServer extends Thread {
    protected Socket socket;

    public MyServer(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {

        while (true) {
            InputStream inp = null;
            BufferedReader brinp = null;
            DataOutputStream out = null;
            try {
                inp = socket.getInputStream();
                brinp = new BufferedReader(new InputStreamReader(inp));
                out = new DataOutputStream(socket.getOutputStream());

            } catch (IOException e) {
                return;
            }
            String line;
            while (true) {
                try {
                    line = brinp.readLine();
                    if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                        socket.close();
                        return;
                    } else {
                        out.writeBytes(line + "\n\r");
                        out.flush();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            while (true) {

                System.out.println("The server is running...");
                ServerSocket ss = new ServerSocket(6666);

                // Establishes connection

                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message = " + str);

                // new thread for a client

                new MyServer(s).start();

                // close

                ss.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
