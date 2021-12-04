import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Peer {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Peer #");

        String[] setupValues = bufferedReader.readLine().split(" ");

        ServerThread serverThread = new ServerThread(setupValues[1]);

        serverThread.start();

    }
}
