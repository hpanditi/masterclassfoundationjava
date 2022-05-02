import java.io.*;
import java.util.Scanner; // This imports the Scanner class

public class Peer {

    public static void main(String[] args) throws IOException {

//        Streams for conversing with server
//        BufferedReader in = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Peer #");

        String[] setupValues = bufferedReader.readLine().split(" ");

        ServerThread serverThread = new ServerThread(setupValues[1]);

        serverThread.start();

        while (true) {

            Scanner myObj = new Scanner(System.in); // This creates a Scanner object

            System.out.println("Enter 'neighbors' to show neighbors or 'quit' to quit");

            String neighborName = myObj.nextLine(); // Reads user input

            if (neighborName == "neighbors") {

                System.out.println("Identification of Neighbors: " + neighborName); // Output user input

                // Code here should display hostnames/IP addresses

            }

//            Code to send to the server

//            System.out.println("\nEnter a string to send to the server (empty to quit):");
//            String s;
//            while((s = br.readLine()) != null && s.length() != 0) {
//                out.write(s+"\n");
//                out.flush();
//                String response = in.readLine();
//                System.out.println(response);
//                System.out.println("\nEnter a string to send to the server (empty to quit):");

            // Code that allows communication between peer to peer

            // Code here should display a series of 'if' statement

            int numberOfPeers = 5;

            int A;

            A = 1;

            int B;

            B = 1;

            int C;

            C = 1;

            if (A <= numberOfPeers) {

                // Code to show that A accepts the connection request from B.

            } else {

                // Code to decline the connection request from B
            }

            if (C <= numberOfPeers) {


            } else {


            }

//            @Override
//            public void onReceive(Context context, Intent intent) {
//                String action = intent.getAction();
//                if (P2PManager.P2P_STATE_CHANGED_ACTION.equals(action)) {
//                    // Determine if P2P mode is enabled or not, alert the activity.
//                    int state = intent.getIntExtra(P2PManager.EXTRA_WIFI_STATE, -1);
//                    if (state == P2PManager.WIFI_P2P_STATE_ENABLED) {
//                        activity.setIsP2PEnabled(true);
//                    } else {
//                        activity.setIsP2PEnabled(false);
//                    }
//                } else if (P2PManager.P2P_PEERS_CHANGED_ACTION.equals(action)) {
//
//                    // The peer list has changed and action needs to be taken
//
//                } else if (P2PManager.P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
//
//                    // Connection state changed and action needs to be taken
//
//                } else if (P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
//                    DeviceListFragment fragment = (DeviceListFragment) activity.getFragmentManager()
//                            .findFragmentById(R.id.frag_list);
//                    fragment.updateThisDevice((WifiP2pDevice) intent.getParcelableExtra(
//                           P2PManager.EXTRA_P2P_DEVICE));
//
//                }
//            }

            // The code below will terminate the peer if 'quit' is entered

            if (neighborName == "quit") {

                System.out.println("Peer" + neighborName + " disconnected");

                System.exit(0);

            }
        }
    }
}