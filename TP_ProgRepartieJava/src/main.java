import java.io.IOException;


public class main {
    public static void main(String[] args) throws IOException {
        //ClientTCP clientTCP = new ClientTCP("10.203.9.99", 50007);
        //clientTCP.lancerBW();
        ServeurTCP serveurTCP = new ServeurTCP();
        serveurTCP.lancerServ();
    }
}
