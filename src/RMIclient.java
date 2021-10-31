// package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.Scanner;
import java.util.Date;

public class RMIclient {

    private RMIclient() {
    }

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];

        while (true) {
            try {
                Registry registry = LocateRegistry.getRegistry(host);
                Hello stub = (Hello) registry.lookup("Hello");
                String response = stub.sayHello();
                System.out.println("response: " + response);

                Date currentDate = new Date();

                if (valueOne.equals("time")) {
                    System.out.println(currentDate.toString());

                } else if (valueOne != null && valueOne != "time") {
                    System.out.println(valueOne.toUpperCase());
                } else {
                    System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }
}