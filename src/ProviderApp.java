/*
The following steps take place during a RPC :

1. A client invokes a client stub procedure, passing parameters in the usual way. The client stub resides within the client’s own address space.

2. The client stub marshalls(pack) the parameters into a message.
 Marshalling includes converting the representation of the parameters into a standard format,
  and copying each parameter into the message.

3. The client stub passes the message to the transport layer,
 which sends it to the remote server machine.

4. On the server, the transport layer passes the message to a server stub,
 which demarshalls(unpack) the parameters and calls the desired server routine using the regular procedure call mechanism.

5. When the server procedure completes, it returns to the server stub (e.g., via a normal procedure call return),
 which marshalls the return values into a message. The server stub then hands the message to the transport layer.

6. The transport layer sends the result message back to the client transport layer,
 which hands the message back to the client stub.

7. The client stub demarshalls the return parameters and execution returns to the caller.
 */

// This is from the RPC-Server file

import java.util.Date;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class ProviderApp {
//    private Calculator calculator = new CalculatorImpl();
//
//    public static void main(String[] args) throws IOException {
//        new ProviderApp().begin();
//    }
//
//    private void begin() throws IOException {
//        ServerSocket listener = new ServerSocket(9090);
//        System.out.println("The server is running...");
//
//    }
//
//     while (true) {
//        Socket socket = listener.accept();
//        try {
//            //
//            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//            Object object = objectInputStream.readObject();
//
//            //
//            String result = "";
//            if (object instanceof CalculateRpcRequest) {
//                CalculateRpcRequest calculateRpcRequest = (CalculateRpcRequest) object;
//                if ("".equals(calculateRpcRequest.getMethod())) {
//                    result = calculator.toString(calculateRpcRequest.getA());
//                } else {
//                    throw new UnsupportedOperationException();
//                }
//            }
//
//            //
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//            objectOutputStream.writeObject(new Integer(result));
//        } catch (Exception e) {
//            System.out.println("error!");
//        }
//    }
//}

///*
//Server code
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Date;
//
///**
// * A server program which accepts requests from clients to capitalize strings or show current date and time.
// * When clients connect, a new thread is started to handle an interactive dialog
// * in which the client sends in a string and the server thread sends back the
// * capitalized version of the string or the current data and time depending on the client's message.
// *
// * The server program runs in an infinite loop.
//
//public class Server {
//
//    /**
//     * Run the server listening on port 9090. When a
//     * client connects, the server spawns a new thread to do the servicing
//     * while the old thread keeps listening.  The server keeps a unique client
//     * number for each client that connects just to show interesting logging
//     * messages.
//     */
//    public static void main(String[] args) throws Exception {
//        System.out.println("The server is running.");
//        int clientNumber = 1;
//        ServerSocket listener = new ServerSocket(9090);
//        while (true) {
//            new Request(listener.accept(), clientNumber).start();
//            clientNumber++;
//        }
//    }
//}
///**
// * A thread to handle capitalization and time requests on a particular socket.
// */
//class Request extends Thread  {
//    private Socket socket1;
//    private int ClientNumber;
//
//    public Request(Socket socket, int clientNumber) {
//        socket1 = socket;
//        ClientNumber = clientNumber;
//        System.out.println("New client #" + ClientNumber + " connected" );
//    }
//
//    /**
//     * Services this thread's client by first sending the client a welcome
//     * message then repeatedly reading strings and sending back the capitalized
//     * version of the string, or the current date and time, depending on the client's message.
//     */
//    public void run()  {
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
//            // Send a welcome message to the client.
//
//            out.write("Hello, you are client #" + ClientNumber+"\n");
//            out.flush();
//
//            // Get messages from the client, line by line; return them capitalized or the current date and time
//            String s;
//
//            while((s = in.readLine()) != null && s.length() != 0) {
//                if(s.equals("time")) {
//                    out.write(new Date().toString()+"\n");
//                    out.flush();
//                }
//                else {
//                    out.write(s.toUpperCase()+"\n");
//                    out.flush();
//                }
//            }
//            socket1.close();
//        } catch (IOException e) {
//            System.out.println("Error handling client #" + ClientNumber);
//        }
//        System.out.println("Connection with client # " + ClientNumber + " closed");
//    }
//}
