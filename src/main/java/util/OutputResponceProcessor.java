package util;

import Message.abstractions.BinaryMessage;
import abstractions.ResponceMessage;
import impl.JAktor;
import servers.ServerAktor;
import util.readfile.Readfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputResponceProcessor {
    public ServerAktor jaktor;
    public Readfile Incomming;
    public void approve(String ID) throws IOException {
        System.out.println("ID=>>>"+ID);
        ResponceMessage res = new ResponceMessage();
        res.ID = ID;
        res.approved = true;

        jaktor.sendResponce(res);
    };

}
