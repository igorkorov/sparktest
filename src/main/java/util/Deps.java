package util;

import abstractions.Cypher;
import servers.EchoWebSocket;
import servers.ServerAktor;
import util.readfile.Readfile;
import java.sql.SQLException;

public class Deps {
    public LoginChecker loginchecker;
    public DataBaseHelper dbhelper;
    public Cypher cypher;
    public ServerAktor aktor;
    public InputRequestProcessor irp;
    public String fileprops = "setts.ini";
    private Readfile readfile;
    public Class<EchoWebSocket> echoWebSocket;

    public Deps() throws InterruptedException, SQLException {
        readfile = new Readfile(fileprops);
        try {
            this.loginchecker = new LoginChecker( new DataBaseHelper().executor);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        irp = new InputRequestProcessor(new DataBaseHelper("requests").executor);
        this.cypher = new CypherImpl();
        aktor = new ServerAktor();
        aktor.irp=irp;
        aktor.setAddress(readfile.AktorPORT());
        aktor.echoWebSocket = echoWebSocket;

        aktor.setCypher(cypher);
        System.out.println("\n\n\n*************************\n****Spawning JAKtor******\n*************************\n\n\n\n");
        aktor.spawn();
    }


}