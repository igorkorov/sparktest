package util;

import abstractions.Cypher;
import impl.JAktor;
import util.readfile.Readfile;

import java.io.IOException;
import java.sql.SQLException;

public class Deps {
    public LoginChecker loginchecker;
    public DataBaseHelper dbhelper;
    public Cypher cypher;
    public ServerAktor aktor;
    public String fileprops = "setts.ini";
    private Readfile readfile;

    public Deps() throws InterruptedException {
        readfile = new Readfile(fileprops);
        try {
            this.dbhelper = new DataBaseHelper();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            this.loginchecker = new LoginChecker(dbhelper.executor);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.cypher = new CypherImpl();
        aktor = new ServerAktor();
        aktor.setAddress(readfile.AktorPORT());
        aktor.setCypher(cypher);
        aktor.spawn();
    }

    public class ServerAktor extends JAktor {
        private Cypher cypher;

        public void setCypher(Cypher cypher) {
            this.cypher = cypher;
        }

        @Override
        public int send(byte[] message, String address) throws IOException {
            return this.client.send(this.cypher.encrypt(message), address);
        }

        @Override
        public void receive(byte[] message_) throws IOException {

            byte[] message = cypher.decrypt(message_);

        }
    }
}