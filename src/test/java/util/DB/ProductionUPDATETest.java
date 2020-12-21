package util.DB;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ProductionUPDATETest {
    public DataBaseHelper dbh = new DataBaseHelper("jdbc:MySQL://192.168.0.2/avs?user=coder&password=Pf,dtybt010203", true);

    public ProductionUPDATETest() throws SQLException {
    }

    @Test
    public void testConnect(){
        assertNotEquals(null, dbh.executor.getConn());
    }

    @Test
    public void getMetalID() {
        String find = "Радиатор латунный";
        int etalon = 10;
        int index = new ProductionUPDATE().getMetalID(find);
        assertEquals(etalon, index);

    }
}