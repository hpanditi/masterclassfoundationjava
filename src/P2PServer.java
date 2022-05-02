import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;

class P2PServer extends Thread {

    protected Socket socket;

    public P2PServer(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {

        while (true) {

            InputStream inp = null;
            BufferedReader brinp = null;
            DataOutputStream out = null;

            try {
                inp = socket.getInputStream();
                brinp = new BufferedReader(new InputStreamReader(inp));
                out = new DataOutputStream(socket.getOutputStream());

            } catch (IOException e) {
                return;
            }

            String line;
            while (true) {
                try {
                    line = brinp.readLine();
                    if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                        socket.close();
                        return;

                    } else if (line.equalsIgnoreCase("members")) {

//                  Code below must display the hostnames/IP addresses of current existing peers.

//                        int accept(int sockfd, struct sockaddr *addr, socklen_t *addrlen);

                    } else {
                        out.writeBytes(line + "\n\r");
                        out.flush();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

        try {

            while (true) {

                System.out.println("The server is running...");
                ServerSocket ss = new ServerSocket(6666);

                // Establishes connection

                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message = " + str);

                // new thread for a client

                new MyServer(s).start();

                // close

                ss.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// External Code

//public class SocketTest {
//    private boolean run = true;
//
//    public static void main(String[] args) throws IOException {
//        startServer();
//        startSender();
//    }
//
//    public static void startSender() throws UnknownHostException{
//        InetAddress aHost = InetAddress.getLocalHost();
//        (new Thread() {
//            @Override
//            public void run() {
//                byte data[] = "Hello".getBytes();
//                DatagramSocket socket = null;
//                try {
//                    socket = new DatagramSocket();
//                    socket.setBroadcast(true);
//                } catch (SocketException ex) {
//                    ex.printStackTrace();
//                    //parent.quit();
//                }
//
//                DatagramPacket packet = new DatagramPacket(
//                        data,
//                        data.length,
//                        aHost,
//                        9090);
//                int i=0;
//                while (i<10) {
//                    try {
//
//                        System.out.println("what us mmmm.."+new String(packet.getData()));
//                        socket.send(packet);
//                        Thread.sleep(50);
//                        i++;
//                        System.out.println(i);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                        // parent.quit();
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                        // parent.quit();
//                    }
//                }
//            }}).start();
//    }
//
//
//    public static void startServer() {
//        (new Thread() {
//            @Override
//            public void run() {
//
//                //byte data[] = new byte[0];
//                DatagramSocket socket = null;
//                try {
//                    socket = new DatagramSocket(9090);
//                    //socket.setBroadcast(true);;
//
//                } catch (SocketException ex) {
//                    ex.printStackTrace();
//                    //parent.quit();
//                }
//                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
//                //System.out.println("this is what has been received111"+packet.getData());
//                String temp;
//                while (true) {
//                    try {
//                        socket.receive(packet);
//                        temp=new String(packet.getData());
//                        System.out.println("Received Message"+temp);
//
//                        //System.out.println("Message received ..."+ temp);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                        //parent.quit();
//                    }
//
//                }
//            }
//
//        }).start();
//    }
//}

// Other code
// package com.basrikahveci.p2p;
//
//        import com.basrikahveci.p2p.peer.Config;
//        import com.google.common.base.Charsets;
//        import joptsimple.OptionParser;
//        import joptsimple.OptionSet;
//        import org.slf4j.Logger;
//        import org.slf4j.LoggerFactory;
//
//        import java.io.BufferedReader;
//        import java.io.File;
//        import java.io.FileInputStream;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.Properties;
//
//public class Main {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
//
//    private static final String PEER_NAME_SYSTEM_PROPERTY = "peerName";
//
//    private static final String PEER_NAME_PARAMETER = "n";
//
//    private static final String BIND_PORT_PARAMETER = "b";
//
//    private static final String CONFIG_FILE_PARAMETER = "c";
//
//    private static final String HELP_PARAMETER = "help";
//
//    private enum ConfigProperty {
//
//        MIN_NUMBER_OF_ACTIVE_CONNECTIONS("minActiveConnections") {
//            @Override
//            public void setIntValue(int val, Config config) {
//                config.setMinNumberOfActiveConnections(val);
//            }
//        },
//
//        MAX_READ_IDLE_SECONDS("maxReadIdleSeconds") {
//            @Override
//            public void setIntValue(int val, Config config) {
//                config.setMaxReadIdleSeconds(val);
//            }
//        },
//
//        KEEP_ALIVE_PING_PERIOD_SECONDS("keepAlivePingPeriodSeconds") {
//            @Override
//            public void setIntValue(int val, Config config) {
//                config.setKeepAlivePeriodSeconds(val);
//            }
//        },
//
//        PING_TIMEOUT_SECONDS("pingTimeoutSeconds") {
//            @Override
//            public void setIntValue(int val, Config config) {
//                config.setPingTimeoutSeconds(val);
//            }
//        },
//
//        AUTO_DISCOVERY_PING_FREQUENCY("autoDiscoveryPingFrequency") {
//            @Override
//            public void setIntValue(int val, Config config) {
//                config.setAutoDiscoveryPingFrequency(val);
//            }
//        },
//
//        PING_TTL("pingTTL") {
//            @Override
//            public void setIntValue(int val, Config config) {
//                config.setPingTTL(val);
//            }
//        },
//
//        LEADER_ELECTION_TIMEOUT("leaderElectionTimeoutSeconds") {
//            @Override
//            public void setIntValue(int val, Config config) {
//                config.setLeaderElectionTimeoutSeconds(val);
//            }
//        },
//
//        LEADER_REJECTION_TIMEOUT("leaderRejectionTimeoutSeconds") {
//            @Override
//            public void setIntValue(int val, Config config) {
//                config.setLeaderRejectionTimeoutSeconds(val);
//            }
//        };
//
//        public static ConfigProperty byPropertyName(final String propertyName) {
//            for (ConfigProperty prop : values()) {
//                if (prop.propertyName.equals(propertyName)) {
//                    return prop;
//                }
//            }
//
//            throw new IllegalArgumentException("Invalid config property: " + propertyName);
//        }
//
//        private final String propertyName;
//
//        ConfigProperty(String propertyName) {
//            this.propertyName = propertyName;
//        }
//
//        public abstract void setIntValue(final int val, final Config config);
//
//    }
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        if (System.getProperty(PEER_NAME_SYSTEM_PROPERTY) == null) {
//            LOGGER.error("System property peerName should be provided!");
//            System.exit(-1);
//        }
//
//        final OptionSet options = parseArguments(args);
//        final PeerRunner peerRunner = createPeerRunner(options);
//        peerRunner.start();
//
//        String line;
//        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8));
//        while ((line = reader.readLine()) != null) {
//            final PeerRunner.CommandResult result = peerRunner.handleCommand(line);
//            if (result == PeerRunner.CommandResult.SHUT_DOWN) {
//                break;
//            } else if (result == PeerRunner.CommandResult.INVALID_COMMAND && line.length() > 0) {
//                printHelp(line);
//            }
//        }
//    }
//
//    private static PeerRunner createPeerRunner(final OptionSet options) throws IOException, InterruptedException {
//        final String peerName = (String) options.valueOf(PEER_NAME_PARAMETER);
//        final int portToBind = (int) options.valueOf(BIND_PORT_PARAMETER);
//
//        final Config config = new Config();
//        config.setPeerName(peerName);
//        populateConfig(options, config);
//
//        return new PeerRunner(config, portToBind);
//    }
//
//    private static OptionSet parseArguments(final String[] args) throws IOException {
//        final OptionParser optionParser = new OptionParser();
//        optionParser.accepts(PEER_NAME_PARAMETER).withRequiredArg().ofType(String.class).describedAs("peer name");
//        optionParser.accepts(BIND_PORT_PARAMETER).withRequiredArg().ofType(Integer.class).describedAs("port to bind");
//        optionParser.accepts(CONFIG_FILE_PARAMETER).withOptionalArg().ofType(File.class).describedAs("config properties file");
//        optionParser.accepts(HELP_PARAMETER).forHelp();
//
//        final OptionSet options = optionParser.parse(args);
//        if (options.has(HELP_PARAMETER)) {
//            optionParser.printHelpOn(System.out);
//        }
//
//        if (!options.has(PEER_NAME_PARAMETER) || !options.has(BIND_PORT_PARAMETER)) {
//            if (!options.has(HELP_PARAMETER)) {
//                optionParser.printHelpOn(System.out);
//            }
//            LOGGER.error("Missing arguments!!");
//            System.exit(-1);
//        }
//
//        return options;
//    }
//
//    private static void populateConfig(final OptionSet options, final Config config) throws IOException {
//        if (options.has(CONFIG_FILE_PARAMETER)) {
//            final File file = (File) options.valueOf(CONFIG_FILE_PARAMETER);
//            loadConfig(config, file);
//        }
//
//        LOGGER.info("Using configuration: {}", config);
//    }
//
//    private static void loadConfig(final Config config, final File file) throws IOException {
//        final Properties properties = new Properties();
//        final FileInputStream fileInputStream = new FileInputStream(file);
//        properties.load(fileInputStream);
//        fileInputStream.close();
//        for (String propertyName : properties.stringPropertyNames()) {
//            final ConfigProperty configProperty = ConfigProperty.byPropertyName(propertyName);
//            final int val = Integer.parseInt(properties.getProperty(propertyName));
//            configProperty.setIntValue(val, config);
//        }
//    }
//
//    private static void printHelp(final String line) {
//        if (!"help".equalsIgnoreCase(line.trim())) {
//            System.out.println("Invalid input command:  " + line);
//        }
//
//        System.out.println(
//                "############################################## COMMANDS ###############################################");
//        System.out.println(
//                "# 1) ping                >>> Lists peers in the network                                               #");
//        System.out.println(
//                "# 2) leave               >>> Leaves the network                                                       #");
//        System.out.println(
//                "# 3) connect host port   >>> Connects to the peer specified by host:port pair                         #");
//        System.out.println(
//                "# 4) disconnect peerName >>> Disconnects from the peer specified with peerName                        #");
//        System.out.println(
//                "# 4) election            >>> Starts a new leader election                                             #");
//        System.out.println(
//                "#######################################################################################################");
//    }
//
//
//}