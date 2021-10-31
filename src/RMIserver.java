// package example.hello;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.Date;

public class RMIserver implements Hello {

    public RMIserver() {}

    public String sayHello() {
        return "Hello, world!";

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter 'time', type something or leave empty() to exit");

        String valueOne = myObj.nextLine();
        System.out.println("The value put in is: " + valueOne);
    }

    public static void main(String args[]) {

        try {
            Server obj = new Server();

            // The port number was originally 0 and it has been changed to 5000.
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 5000);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

/** Remote Interface **/

// This would go in Method.java or I have to create a new file?

/*
package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
}
 */