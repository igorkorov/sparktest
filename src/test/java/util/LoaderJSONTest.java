package util;

import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoaderJSONTest {
    DataBaseHelper db =  new DataBaseHelper("requests");
    LoaderJSON ljson = new LoaderJSON(db.executor);
    public LoaderJSONTest() throws SQLException {
    }

    @Test
    public void loaderJSON() throws SQLException {

        assertNotEquals(null, ljson.loaderJSON());
        ArrayList res = ljson.loaderJSON();
        res.forEach(a->System.out.println(a));
    }

    @Test
    public void writeJSON() throws SQLException {
        ArrayList res = ljson.loaderJSON();
        int s1 = res.size()+1;
        String data = "{\"body\": \"they are on to us\", \"sender\": \"pablo\"}";
        PreparedStatement stmt = db.executor.getConn().prepareStatement("INSERT INTO test  VALUES (?, ?::jsonb)");
        stmt.setInt(1, s1);
        stmt.setString(2, data);
        stmt.executeUpdate();
        res = ljson.loaderJSON();
        int s2 = res.size();
        System.out.println(s2);
        assertTrue(s2>(--s1));
        res.forEach(a->System.out.println(a));

    }
}