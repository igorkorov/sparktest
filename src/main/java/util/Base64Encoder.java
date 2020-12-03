
package util;

import org.bouncycastle.util.encoders.Base64;

public class Base64Encoder {
    public String decode(String input){
        return new String(Base64.decode(input));
    }

    public String encode(String etalon) {
        return new String(Base64.encode(etalon.getBytes()));
    }
}
