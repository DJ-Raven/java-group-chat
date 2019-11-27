package function;

import java.util.ArrayList;
import javax.swing.JTextArea;

public class Method {

    public static int getFileID() {
        return fileID;
    }

    public static void setFileID(int aFileID) {
        fileID = aFileID;
    }

    public static JTextArea getTxt() {
        return txt;
    }

    public static void setTxt(JTextArea aTxt) {
        txt = aTxt;
    }

    public static int getClientID() {
        return clientID;
    }

    public static void setClientID(int aClientID) {
        clientID = aClientID;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static void setClients(ArrayList<Client> aClients) {
        clients = aClients;
        clientID = 1;
        fileID = 1;
    }

    public static int addClient(Client client) {
        clients.add(client);
        return clientID++;
    }
    private static int clientID;
    private static int fileID;
    private static ArrayList<Client> clients;
    private static JTextArea txt;

}
