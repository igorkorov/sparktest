package util;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class DataBaseHelperTest {
    //DataBaseHelper dbh = new DataBaseHelper("jdbc:MySQL://localhost/test\"", true);

    public DataBaseHelperTest() throws SQLException {
    }

    @Test
    public void DataBaseHelperTest() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user2", "123");



        assertNotEquals(null, conn);
    //    Statement stmt = conn.createStatement();
    //    ResultSet rs = stmt.executeQuery("SELECT ID FROM USERS");



    }
}