package util;

import fr.roland.DB.Executor;

import java.sql.SQLException;

public class DataBaseHelper {
    public Executor executor;
    public DataBaseHelper() throws SQLException {
        String url = "jdbc:postgresql://localhost/users?user=user2&password=123";///&ssl=true";
        this.executor = new Executor(url);
    }

}
