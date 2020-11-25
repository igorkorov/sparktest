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
    public String incomingFolder = "requests";
    private Readfile Settings;
    private Readfile Incomming;
    public IDHelper idh;
    public Class<EchoWebSocket> echoWebSocket;
    public OutputResponceProcessor orp;
    public DataBaseHelper requests;
    public DataBaseHelper users;

    public Deps() throws InterruptedException, SQLException {
        requests = new DataBaseHelper("requests");
        users = new DataBaseHelper();
        Settings = new Readfile(fileprops);
        Incomming = new Readfile(incomingFolder);
        try {
            this.loginchecker = new LoginChecker( users.executor);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        idh = new IDHelper(requests.executor);
        irp = new InputRequestProcessor(requests.executor);
        this.cypher = new CypherImpl();
        aktor = new ServerAktor();
        aktor.irp=irp;
        aktor.incomingFolder = incomingFolder;
        aktor.setAddress(Settings.AktorPORT());
        aktor.echoWebSocket = echoWebSocket;

        aktor.setCypher(cypher);
        System.out.println("\n\n\n*************************\n****Spawning JAKtor******\n*************************\n\n\n\n");
        aktor.spawn();
        orp = new OutputResponceProcessor();
        orp.Incomming = Incomming;
        orp.jaktor=aktor;
        orp.idHelper=idh;
        orp.executor=requests.executor;
    }


}