package util;

import abstractions.ResponceMessage;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class OutputResponceProcessorTest {
    DataBaseHelper requests = new DataBaseHelper("requests");
    OutputResponceProcessor orp = new OutputResponceProcessor();


    public OutputResponceProcessorTest() throws SQLException {
        orp.executor= requests.executor;
    }

    @Test
    public void writeResponceinDB() throws SQLException {
        PreparedStatement st = orp.executor.getConn().prepareStatement( "DELETE from status ");
        st.executeUpdate();
        ResultSet res=orp.executor.submit("SELECT * FROM status");
        assertEquals(false, res.next());
        ResponceMessage responce = new ResponceMessage();
        responce.ID = "1";
        responce.approved = true;
        orp.writeResponceinDB(responce, "192.****");
        ResultSet res0=orp.executor.submit("SELECT * FROM status");
        assertEquals(true, res0.next());


    }

    @Test
    public void swap() {
        ArrayList initial = new ArrayList();
        initial.add(1);
        initial.add(2);

        ArrayList swapped = new ArrayList();
        swapped.add(2);
        swapped.add(1);

        assertEquals(swapped, orp.swap(initial));
    }
}