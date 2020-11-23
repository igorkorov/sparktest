package util;

import abstractions.RequestMessage;
import fr.roland.DB.Executor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class InputRequestProcessor {
    private Executor executor;
    public InputRequestProcessor(Executor executor){
        this.executor = executor;
    }
    public void saveRequestinDB(RequestMessage req) throws SQLException {
        PreparedStatement stmt = executor.getConn().prepareStatement("INSERT INTO requests  VALUES (?, ?, ?::jsonb, NULL, NULL, NULL)");
        stmt.setString(1, req.ID);
        stmt.setDate(2,  new java.sql.Date(new Date().getTime()));
        stmt.setString(3, req.JSONed);
        System.out.println("executing");
        stmt.executeUpdate();


    }

    public ArrayList<Object> loadrequests() throws SQLException {
        ResultSet res = executor.submit("select * from requests order by DATETIMEREQUEST desc;");
        ArrayList result = new ArrayList();
        while (res.next()){
            result .add(res.getObject(2));
            System.out.println(res.getObject(2));
        }
        return result;
    };


}
