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

        public void run () {

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
    public class web {

        public static void main(String[] args) throws Exception {

            ServerSocket listener = new ServerSocket(8088);

            System.out.println("The server is running...");

            while (true) {
                new Request(listener.accept()).start();
            }
        }
    }



