package util;
import fr.roland.DB.Executor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginChecker {
    private Executor executor;
    public LoginChecker(Executor executor) throws SQLException {
        this.executor = executor;
    }
    public LoginChecker() throws SQLException {

    }
    public boolean checklogin(String login, String password) throws SQLException {
        String pass="____";
        ArrayList list = new ArrayList<String>() {{
            add(login);
        }};

        ResultSet  res = executor.executePrepared("SELECT * from users where login = ?", list);
        if (res.next())
            pass =res.getString("pass");
        if (password.equals(pass))
            return true;
        return false;
    }
}
