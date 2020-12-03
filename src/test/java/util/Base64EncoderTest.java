package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class Base64EncoderTest {
    Base64Encoder enc = new Base64Encoder();
    String etalon= "{\"a\": 6, \"first_name\" : \"Sammy\", \"last_name\" : \"Shark\", \"location\" : \"Ocean\"}\n";
    String initial = "eyJhIjogNiwgImZpcnN0X25hbWUiIDogIlNhbW15IiwgImxhc3RfbmFtZSIgOiAiU2hhcmsiLCAibG9jYXRpb24iIDogIk9jZWFuIn0K";

    @Test
    public void decode() {
        assertEquals(etalon, enc.decode(initial));
    }

    @Test
    public void encode(){
        assertEquals(initial, enc.encode(etalon));

    }
}