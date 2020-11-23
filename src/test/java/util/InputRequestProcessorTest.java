package util;

import abstractions.RequestMessage;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class InputRequestProcessorTest {
    DataBaseHelper db =  new DataBaseHelper("requests");
    InputRequestProcessor irp = new InputRequestProcessor(db.executor);
    public InputRequestProcessorTest() throws SQLException {
    }

    @Test
    public void saveRequestinDB() throws SQLException {
        RequestMessage req = new RequestMessage("555" , "must done", "{\"name\": \"roman\"}");
        irp.saveRequestinDB(req);
        ArrayList reqs = irp.loadrequests();
        assertNotEquals(0, reqs.size());


    }

    @Test
    public void loadrequests() throws SQLException {
        ArrayList reqs = irp.loadrequests();
        assertNotEquals(0, reqs.size());
    }

    @Test
    public void testSaveRequestinDB() {
    }
}