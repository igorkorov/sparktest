package servers;

import Message.abstractions.BinaryMessage;
import abstractions.Cypher;
import abstractions.RequestMessage;
import abstractions.ResponceMessage;
import impl.JAktor;
import servers.threadMessager.ThreadMessager;
import util.IDHelper;
import util.InputRequestProcessor;

import java.io.*;
import java.net.ConnectException;
import java.sql.SQLException;

public class ServerAktor extends JAktor {
    public String incomingFolder;
    private Cypher cypher;
    public Class<EchoWebSocket> echoWebSocket;
    public InputRequestProcessor irp;
    public void setCypher(Cypher cypher) {
        this.cypher = cypher;
    }
    public ThreadMessager msg ;
    public ServerAktor(){
        msg = new ThreadMessager();
        msg.start();
    };
    @Override
    public int send(byte[] message, String address) throws IOException {
        System.out.println("SENDING to>>"+address);
        return this.client.send(this.cypher.encrypt(message), address);
    }

    @Override
    public void receive(byte[] message_) throws IOException {
        System.out.println("Catched!!!");
        byte[] message = cypher.decrypt(message_);
        RequestMessage req = (RequestMessage) BinaryMessage.restored(message);
        if (req.type.equals(RequestMessage.Type.request)) {
            saveRequest(req);
            System.out.println(req.JSONed);
            sendWebsocketAlerts();
            try {
                saveinDB(req);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return;
        }
        if (req.type.equals(RequestMessage.Type.update)) {
            try {
                irp.saveUpdatingRequestinDB(req);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(req.JSONed);
            sendWebsocketAlerts();

            return;
        }
    }

    public void saveRequest(RequestMessage req) throws IOException {
        System.out.println("Save request");
        FileWriter fw = new FileWriter(incomingFolder+"/"+req.ID, false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(req.addressToReply);
        bw.newLine();
        bw.close();
    }

    public void sendResponce(ResponceMessage res) throws IOException {
        String address = IDHelper.getaddress(incomingFolder, res.ID);
        System.out.println("SENDING responce to"+address);
        send(BinaryMessage.savedToBLOB(res), address);
    };

    public void sendWebsocketAlerts(){
        EchoWebSocket.sendall();
    };

    public void saveinDB(RequestMessage requestMessage) throws SQLException {
        irp.saveRequestinDB(requestMessage);

    };

}