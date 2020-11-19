package util;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.*;
public class LoginCheckerTest {

    @Test
    public void checklogin() throws SQLException {
        LoginChecker check = new LoginChecker(new DataBaseHelper().executor);
        assertEquals(true, check.checklogin("roman", "123"));
    }
}