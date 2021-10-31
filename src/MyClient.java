import java.io.*;
import java.net.*;
import java.util.Locale;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {

    public static void main(String[] args) {

        try{
            while(true) {

                Socket s = new Socket("localhost", 6666);
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                // Code to show which client number is present

                int clientNumber = 0;
                clientNumber++;
                System.out.println("Hello, you are client # " + clientNumber);

                //timeStamp

                SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
                String timeStamp = date.format(new Date());

                // User input for IP address

                Scanner myObj = new Scanner(System.in);
                System.out.println("What is the IP address?");
                String entryOne = myObj.nextLine();

                // User input for time

                Scanner myObj2 = new Scanner(System.in);
                System.out.println("Please enter 'time', type something or leave empty() to exit:");
                String entryTwo = myObj2.nextLine();

                // If the entry is "time" or not "time"

                if (entryTwo.equals("time")) {
                    System.out.println("Current time stamp: " + timeStamp);
                } else {
                    System.out.println(entryTwo.toUpperCase());
                }

                // If the entry is blank

                if (entryTwo.isEmpty()) {
                    System.exit(0);
                }

                // Message back to Server

                dout.writeUTF("Received");

                // Close connection

                dout.flush();
                dout.close();
                s.close();

            }
        }catch(Exception e){System.out.println(e);}
    }
}