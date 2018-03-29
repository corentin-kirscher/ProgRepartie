import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP {
    public Socket socketServeur = new Socket();

    public ServeurTCP() throws IOException {}

    public void lancerServ() throws IOException {
        int nbClient = 10;
        int port = 50008;
        Socket client;
        BufferedReader in;
        BufferedWriter out;
        String chaine;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Serveur lancé sur le port : " + port);
        for(int i = 0; i<= nbClient ; ++i){
            client = serverSocket.accept();
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while((chaine = in.readLine()) != null){
                if(chaine.equals("quit")){
                    break;
                }
                out.write(chaine.toUpperCase());
                in.readLine();
                out.flush();
            }
            out.close();
            client.close();
        }
        serverSocket.close();
    }


}
