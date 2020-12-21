package util.DB;

import Message.abstractions.BinaryMessage;
import abstractions.Condition;
import abstractions.PendingResponces;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MapDBTest {

    String temp = "dump.temp";

    @Test
    public void restored() throws IOException {
        PendingResponces req = new PendingResponces();
        assertEquals(null, req.ReqMap);
        Map<String, Condition> map = new HashMap<>();
        map.put("1", Condition.APPROVED);
        map.put("2", Condition.DECLINED);

        req.ReqMap = map;
        byte[] arr = BinaryMessage.savedToBLOB((BinaryMessage) req);
        assertNotEquals(null, arr);
        BinaryMessage.write(arr, temp);
        PendingResponces restored =(PendingResponces) BinaryMessage.restored(BinaryMessage.readBytes(temp));

        assertEquals(restored.ReqMap, req.ReqMap);
        assertEquals(restored.ReqMap.size(), req.ReqMap.size());
        assertTrue(restored.ReqMap.size()>0);

    }
}