package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class BeatyfulizerTest {
    public  String  initialjson = "{\"user\":\"123\",\"metal\":\"alum\"}";
    public String etalonhtml = "user:123<br>metal:alum<br>";
    @Test
    public void beatyfulizerJSON() {
       Beatyfulizer bf = new Beatyfulizer();
       assertEquals(etalonhtml, bf.beatyfulizerJSON(initialjson));
    }
}