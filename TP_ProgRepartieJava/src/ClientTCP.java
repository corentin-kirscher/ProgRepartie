import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTCP  {

    private String hostname;
    private int port;

    public ClientTCP(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void lancerBW() throws IOException {

        Socket sockClient = new Socket();
        String bufSend;
        String bufReceived;

        sockClient.connect(new InetSocketAddress(hostname, port));

        BufferedReader clavier = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                sockClient.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(
                sockClient.getInputStream()));

        while (true) {
            System.out.println("Tu veux quoi chef ?  : \n");
            bufSend = clavier.readLine();
            if (bufSend.equals("quit")) {
                System.out.println("This is the end");
                break;
            }
            else {
                out.write(bufSend);
                // rajouter un saut de ligne pour pouvoir utiliser readline par la suite
                out.newLine();
                // vider le buffer
                out.flush();
                // lire la chaine envoyée par le serveur
                bufReceived = in.readLine();
                System.out.println(bufReceived);
            }
        }

        out.close();
        in.close();
    }

}