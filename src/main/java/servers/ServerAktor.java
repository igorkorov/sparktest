package servers;

import Message.abstractions.BinaryMessage;
import abstractions.Cypher;
import abstractions.RequestMessage;
import impl.JAktor;
import servers.EchoWebSocket;
import util.InputRequestProcessor;

import java.io.IOException;
import java.sql.SQLException;

public class ServerAktor extends JAktor {
    private Cypher cypher;
    public Class<EchoWebSocket> echoWebSocket;
    public InputRequestProcessor irp;
    public void setCypher(Cypher cypher) {
        this.cypher = cypher;
    }

    @Override
    public int send(byte[] message, String address) throws IOException {
        return this.client.send(this.cypher.encrypt(message), address);
    }

    @Override
    public void receive(byte[] message_) throws IOException {
        System.out.println("Catched!!!");
        byte[] message = cypher.decrypt(message_);
        RequestMessage req = (RequestMessage) BinaryMessage.restored(message);
        System.out.println(req.JSONed);
        sendWebsocketAlerts();
        try {
            saveinDB(req);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void sendWebsocketAlerts(){
        EchoWebSocket.sendall();
    };

    public void saveinDB(RequestMessage requestMessage) throws SQLException {
        irp.saveRequestinDB(requestMessage);

    };

}