package util;

import org.junit.Test;
import util.DB.DataBaseHelper;

import java.sql.*;

public class DataBaseHelperTest {
    DataBaseHelper dbh = new DataBaseHelper("jdbc:MySQL://localhost/test?user=user2&password=123", true);

    public DataBaseHelperTest() throws SQLException {    }

    @Test
    public void DataBaseHelperTest() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user2", "123");
        ResultSet res = dbh.executor.submit("select * FROM test");
        while (res.next()) {
            System.out.println(String.valueOf(res.getObject(1)) + "<>" + String.valueOf(res.getObject(2)));
        }
    }


    ///       assertNotEquals(null, conn);
        //    Statement stmt = conn.createStatement();
        //    ResultSet rs = stmt.executeQuery("SELECT ID FROM USERS");
    }
