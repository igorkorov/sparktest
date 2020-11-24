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
    public void saveUpdatingRequestinDB(RequestMessage req) throws SQLException {
        PreparedStatement stmt = executor.getConn().prepareStatement("UPDATE requests SET updateddata = ?::jsonb WHERE id = ?");
        stmt.setString(1, req.JSONed);
        stmt.setString(2,  req.ID);
        System.out.println("executing >>>"+ req.ID);
        stmt.executeUpdate();
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
            for (int i =1; i<6; i++)
          //  result .add(res.getObject(4));
            {
                System.out.print(res.getObject(i)+"  ;  ");
                result.add(res.getObject(i));

            }

            System.out.println("  ;  ");
        }
        return result;
    };

    public ResultSet loadrequestsSet() throws SQLException {
        return executor.submit("select * from requests order by DATETIMEREQUEST desc;");
    };


    public String DumpRequestToHTMLTable() throws SQLException {
        ArrayList data = loadrequests();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<data.size(); i++){
            if (i%6==0)
                sb.append("<tr>");
            sb.append("<td>"+data.get(i)+"</td>");
           // if (i%5==0)
           //     sb.append("</td>");
        };
        return sb.toString();
    }


}
