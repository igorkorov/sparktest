package util.processors;

import abstractions.Condition;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class InputRequestProcessorTest {
    InputRequestProcessor irp = new InputRequestProcessor();
    OutputResponceProcessor orp = new OutputResponceProcessor();
    public String filename = "temp.bin";
    public String id ="12";
    public Condition cond = Condition.APPROVED;
    @Test
    public void getStatus() throws IOException {
        orp.saveStatus(filename, id, cond);
        Condition rest =irp.getStatus(id, filename);
        assertEquals(cond, rest);
    }
}