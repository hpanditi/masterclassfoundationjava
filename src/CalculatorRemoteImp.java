import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class CalculatorRemoteImpl implements Calculator {
    public static final int PORT = 9090;

    public int add(int a, int b) {

        try {
            Socket socket = new Socket("127.0.0.1", PORT);

            //
            CalculateRpcRequest calculateRpcRequest = generateRequest(a, b);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            //
            objectOutputStream.writeObject(calculateRpcRequest);

            //
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object response = objectInputStream.readObject();

            if (response instanceof Integer) {
                socket.close();
                return (Integer) response;

            } else {
                socket.close();
                throw new InternalError();

            }

        } catch (Exception e) {

            throw new InternalError();
        }
    }

    private CalculateRpcRequest generateRequest(int a, int b) {
        CalculateRpcRequest calculateRpcRequest = new CalculateRpcRequest();
        calculateRpcRequest.setA(a);
        calculateRpcRequest.setB(b);
        calculateRpcRequest.setMethod("add");
        return calculateRpcRequest;
    }

}


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