import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// Java code for thread creation by extending
// the Thread class
class Multithread extends Thread {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
//
//// Main Class
//public class Multithread {
//    public static void main(String[] args)
//    {
//        int n = 8; // Number of threads
//        for (int i = 0; i < n; i++) {
//            MultithreadingDemo object
//                    = new MultithreadingDemo();
//            object.start();
//        }
//    }
//}


public class onesimplehttpserver {

    public static void main(String args[]) throws IOException {

        //STEP 1: Create a network socket
        ServerSocket server = new ServerSocket(8082);
        System.out.println("Listening for connection on port 8082 ...");

//        while (true) {
//            //STEP 2: Accept incoming connection
//            Socket clientSocket = server.accept();
//
//            //STEP 3: Read content of the client request
//            InputStreamReader isr =  new InputStreamReader(clientSocket.getInputStream());
//            BufferedReader reader = new BufferedReader(isr);
//            String line = reader.readLine();
//            while (!line.isEmpty()) {
//                System.out.println(line);
//                line = reader.readLine();

        while (true) {
            // spin forever

            try (Socket socket = server.accept()) {

                String today = "Hello World!";
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream()
                        .write(httpResponse.getBytes("UTF-8"));

                int n = 8; // Number of threads
                for (int i = 0; i < n; i++) {
                    Multithread object = new Multithread();
                    object.start();

                }
            }
        }
    }
}