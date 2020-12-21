package abstractions;

import Message.abstractions.BinaryMessage;

import java.util.Map;

public class PendingResponces implements BinaryMessage {
    public PendingResponces(){

    }
    public PendingResponces(Map<String,Condition> ReqMap){
        this.ReqMap = ReqMap;
    }
    public Map<String,Condition> ReqMap;
}
