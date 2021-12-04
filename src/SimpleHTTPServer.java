import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.lang.Runnable;
import java.io.*;
import java.util.StringTokenizer;

class Request extends Thread {

    private Socket socket1;

    public Request(Socket socket) {
        socket1 = socket;
    }

    public void run() {

        try {

            String curDir = System.getProperty("user.dir");   // We get our current working directory so we can find html files to write back.

            BufferedReader in = new BufferedReader(new InputStreamReader(socket1.getInputStream()));

            PrintStream out = new PrintStream(socket1.getOutputStream());

            String line = in.readLine(); // read the first line of the HTTP request.

            System.out.println("Got a request: [" + line + "]");

//            StringTokenizer toks = new StringTokenizer(line);
//
//            String verb = toks.nextToken();
//
//            String url = toks.nextToken();

            StringTokenizer toks = new StringTokenizer(line);

            String verb = toks.nextToken();

            String url = toks.nextToken();

            if (verb.equalsIgnoreCase("get")) {

                File f = new File(curDir + url);

                if (f.exists()) {   // let's write an HTML file back to the client.

                    BufferedReader responseFile = new BufferedReader(new FileReader(curDir + url));

                    String str;

                    out.println("HTTP/1.0 200 OK\n");    //print the status OK; We have to include "HTTP/1.0" or "HTTP/1.1".

//If "/1.0" or "/1.1" is not there, the web browser cannot show the web page, instead it shows something like "<html> <head>...".


//to do: use a while loop to read the file content and send to the client

//                  String line = null;

                    while ((str = responseFile.readLine()) != null) {
                        out.println(str);
//                        for(int i = 0; i < line.length(); i++)
//                        {
//                            if(Character.isLetter(line.charAt(i)))
//                                System.out.println(line.charAt(i));
//                        }
                    }

                    responseFile.close();

                } else {

                    //to do: show 404 not found

                    out.println("404 Not Found");
////                    String error = "404 Error Not Found";
//                    String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + error;
//                    socket.getOutputStream()
//                            .write(httpResponse.getBytes("UTF-8"));

                }

                out.close();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}

//    public void run() {
//
//        while (true) {
//            InputStream inp = null;
//            BufferedReader brinp = null;
//            DataOutputStream out = null;
//            try {
//                inp = socket.getInputStream();
//                brinp = new BufferedReader(new InputStreamReader(inp));
//                out = new DataOutputStream(socket.getOutputStream());
//
//            } catch (IOException e) {
//                return;
//            }
//        }
//    }

    public static class SimpleHTTPServer {

        public static void main(String[] args) throws Exception {

            ServerSocket listener = new ServerSocket(8088);

            System.out.println("The server is running...");

            while (true) {
                new Request(listener.accept()).start();
            }
        }
    }
}

//                System.out.println("The server is running...");
//                ServerSocket ss = new ServerSocket(8080);
//
//                // Establishes connection
//
//                Socket s = ss.accept();
//                DataInputStream dis = new DataInputStream(s.getInputStream());
//                String str = (String) dis.readUTF();
//                System.out.println("message = " + str);
//
//                // new thread for a client
//
//                new MyServer(s).start();
//
//                // close
//
//                ss.close();

                // code from other program: httpResponse

//                ServerSocket server = new ServerSocket(8080);

//                while (true) {
//
//                    try (Socket socket = server.accept()) {
//
//                        String today = "Hello World!";
//                        String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
//                        socket.getOutputStream()
//                                .write(httpResponse.getBytes("UTF-8"));
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            }
//        }
//    }
//}

//public class SimpleHTTPServer {
//
//    public static void main(String[] args) throws IOException {
//
//        ServerSocket server = new ServerSocket(8080);
//        System.out.println("Listening for connection on port 8080 ...");
//        while (true) {
//            // spin forever
//
//            try (Socket socket = server.accept()) {
//
//                String today = "Hello World!";
//                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
//                socket.getOutputStream()
//                        .write(httpResponse.getBytes("UTF-8"));
//
//            }
//        }
//    }
//}

//import java.io.*;
//import java.net.*;
//
//class ServerOne implements Runnable {
//    public static final int port = 8080;
//
//    public void run() {
//        try{
//            ServerSocket server = new ServerSocket(8080);
//
//            while (true)
//            {
//                final Socket client = server.accept();
//                new Thread() {
//                    public void run() {
//                        try{
//                            ObjectInputStream in =
//                                    new ObjectInputStream( client.getInputStream() );
//                            String msg = (String) in.readObject();
//                            System.out.println(msg);
//                        }
//                        catch(Exception e){System.err.println(e);}
//
//                    }}.start();
//            }
//        }
//        catch(IOException e){System.err.println(e);}
//    }
//}
//
//class Client {
//
//    public void writeMessage(String msg) throws IOException {
//        new ObjectOutputStream((new Socket("localhost",Server.port).getOutputStream())).writeObject(msg);
//    }
//}
//
//public class ClientServer{
//    public static void main(String[] args) throws IOException{
//        Server server = new Server("My Multithreaded Server");
//        new Thread(server).start();
//        Client client1 = new Client();
//        Client client2 = new Client();
//        client1.writeMessage("Hello !");
//        client2.writeMessage("Give me five !");
//    }
//}
//
// Example of other program below:
//
//public class Server {
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(80);
//        System.out.println("Server started at " + new Date() + "\n");
//        try {
//            while (true) {
//                / / Communication Socket
//                Socket socket = serverSocket.accept();
//                new Thread(new Handler(socket)).start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            serverSocket.close();
//        }
//    }
//}
//public class Handler implements Runnable {
//
//    public Socket socket;
//    public static int BUFFERSIZE = 2048;
//
//    public Handler(Socket socket) {
//        this.socket = socket;
//    }
//
//    public void run() {
//        try {
//            InputStream in = socket.getInputStream();
//            OutputStream out = socket.getOutputStream();
//            byte[] buf = new byte[BUFFERSIZE];
//
//            // read data
//            int len = in.read(buf);
//            String s = new String(buf, 0, len);
//            Request request = new Request(s);
//            Logger logger = new Logger(System.out);
//            logger.writelog(request.toString()+"\n");
//
//            // Return to data
//            String path = request.path;
//            if (path.equals("/"))
//                path = "index.html";
//            if (path.equals("/favicon.ico"))
//                path = "favicon.ico";
//            File file = new File(path);
//            InputStream fin = new FileInputStream(file);
//            out.write(("HTTP/1.1 200 OK\n" + "Content-Type: text/html" + "\n\n").getBytes());
//            while ((len = fin.read(buf)) > 0)
//                out.write(buf, 0, len);
//
//            // Close connection
//            socket.close();
//            fin.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}