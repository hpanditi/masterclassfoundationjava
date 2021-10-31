import java.io.*;
import java.net.*;
import java.lang.*;

public class multithreadserverprogram {

    public static void main(String[] args) throws IOException {

        while (true) {
            final int port = 444;
            System.out.println("The server is running... ");
            ServerSocket ss = new ServerSocket(port);
            Socket clientSocket = ss.accept();
            //create two threads to send and recieve from client
            RecieveFromClientThread recieve = new RecieveFromClientThread(clientSocket);
            Thread thread = new Thread(recieve);
            thread.start();

            SendToClientThread send = new SendToClientThread(clientSocket);
            Thread thread2 = new Thread(send);
            thread2.start();
        }
    }
}


class RecieveFromClientThread implements Runnable
{
    Socket clientSocket=null;
    BufferedReader brBufferedReader = null;

    public RecieveFromClientThread(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }//end constructor
    public void run() {
        try{
            brBufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

            String messageString;
            while(true){
                while((messageString = brBufferedReader.readLine())!= null){//assign message from client to messageString
                    if(messageString.equals(""))
                    {
                        break;//break to close socket if EXIT
                    }
                    System.out.println("The server is running...");
                }
                this.clientSocket.close();
                System.exit(0);
            }

        }
        catch(Exception ex){System.out.println(ex.getMessage());}
    }
}//end class RecieveFromClientThread

class SendToClientThread implements Runnable
{
    PrintWriter pwPrintWriter;
    Socket clientSock = null;

    public SendToClientThread(Socket clientSock)
    {
        this.clientSock = clientSock;
    }
    public void run() {
        try{
            pwPrintWriter =new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));//get outputstream
            while(true)
            {
                String msgToClientString = null;
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//get userinput

                msgToClientString = input.readLine();//get message to send to client

                pwPrintWriter.println(msgToClientString);//send message to client with PrintWriter
                pwPrintWriter.flush();//flush the PrintWriter
                System.out.println("Please enter something to send back to client..");
            }//end while
        }
        catch(Exception ex){System.out.println(ex.getMessage());}
    }//end run
}//end class SendToClientThread