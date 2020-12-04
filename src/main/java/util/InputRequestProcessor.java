package util;

import abstractions.RequestMessage;
import fr.roland.DB.Executor;
import org.json.simple.parser.ParseException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
        PreparedStatement stmt = executor.getConn().prepareStatement("INSERT INTO requests  VALUES (?, ?, ?::jsonb, NULL, NULL, NULL, ?)");
        stmt.setString(1, req.ID);
        stmt.setTimestamp(2, new Timestamp(new Date().getTime()));///new java.sql.Date(new Date().getTime().n));
        long now = new Date().getTime();
        System.out.println();
        Date date = new java.sql.Date(now);
        System.out.println("Date = "+date.toString());
        stmt.setString(3, req.JSONed);
        stmt.setString(4, req.Description);
        System.out.println("executing");
        stmt.executeUpdate();
    }

    public ArrayList<Object> loadrequests() throws SQLException {
        ResultSet res = executor.submit("select * from requests order by DATETIMEREQUEST asc;");
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

    public ArrayList<Object> loadrequests8() throws SQLException {
        ResultSet res = executor.submit("select * from requests order by counter desc");
        ArrayList result = new ArrayList();
        while (res.next()){
         /*   result.add(res.getObject(8));
            result.add(res.getObject(2));
            result.add(res.getObject(3));
            result.add(res.getObject(4));
            result.add(res.getObject(5));
            result.add(res.getObject(6));
            result.add(res.getObject(7));  old order*/
            result.add(res.getObject(8));
            result.add(res.getObject(2));
            result.add(res.getObject(7));
            result.add(res.getObject(3));
            result.add(res.getObject(6));
            result.add(res.getObject(5));
            result.add(res.getObject(4));
        }
        return result;
    };

    public ArrayList loadrequests8inmatrix() throws SQLException {
        ResultSet res = executor.submit("select * from requests order by counter desc");
        ArrayList result = new ArrayList();
        while (res.next()){
            ArrayList _result = new ArrayList();
            _result.add(res.getObject(8));
            _result.add(res.getObject(2));
            _result.add(res.getObject(7));
            _result.add(res.getObject(3));
            _result.add(res.getObject(6));
            _result.add(res.getObject(5));
            _result.add(res.getObject(4));
            result.add(_result);
        }

        return result;
    };


    public ResultSet loadrequestsSet() throws SQLException {
        return executor.submit("select * from requests order by counter desc;");
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

    public String DumpRequestToHTMLTable8() throws SQLException {
        ArrayList data = loadrequests8();
        System.out.println("SIZE::"+data.size());
        StringBuilder sb = new StringBuilder();
        int first = 1;
        int number_row=data.size()/7;
        for (int i=0; i<data.size(); i++){
            if (i%7==0) {
                if ((first == 1) && (number_row!=1)){
                    first =0;
                    sb.append("<tr>");
                }
                else
                    sb.append("<td><approvetag number=\""+(number_row--)+"\"></approvetag></td><tr>");
            }
            sb.append("<td>"+data.get(i)+"</td>");

        };
        sb.append("<td><approvetag number=\""+(number_row--)+"\"></approvetag></td><tr>");
        return sb.toString();
    }



    public String DumpRequestToHTMLTable8usingmatrix() throws SQLException {
        ArrayList<ArrayList> data = loadrequests8inmatrix();
        System.out.println("SIZE::"+data.size());
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        int number_row=data.size();
        for (int i=0; i<data.size(); i++){
            for (int j=0; j<data.get(i).size(); j++)
                sb.append("<td>"+data.get(i).get(j)+"</td>");
            sb.append("<td><approvetag number=\""+(number_row--)+"\"></approvetag></td><tr>");
        };
        sb.append("<td><approvetag number=\""+(number_row--)+"\"></approvetag></td><tr>");
        return sb.toString();
    }

    public void processRow(StringBuilder sb, ArrayList data) throws ParseException {
        sb.append("<td>"+data.get(0)+"</td>");
        sb.append("<td>"+data.get(1)+"</td>");
        sb.append("<td>"+data.get(2)+"</td>");
        sb.append("<td>"+Beatyfulizer.schoneJSON(ParcedJSON.parse(String.valueOf(data.get(3))))+ "</td>");
        sb.append("<td>"+data.get(4)+"</td>");
        sb.append("<td>"+Beatyfulizer.compareundschoneJSON(ParcedJSON.parse(String.valueOf(data.get(5))), ParcedJSON.parse(String.valueOf(data.get(3))))+ "</td>");
        sb.append("<td>"+data.get(6)+"</td>");
    };

    public String DumpRequestToHTMLTable8usingmatrixhardcoded() throws SQLException, ParseException {
        ArrayList<ArrayList> data = loadrequests8inmatrix();
        System.out.println("SIZE::"+data.size());
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        int number_row=data.size();
        for (int i=0; i<data.size(); i++){
            processRow(sb, data.get(i));
            sb.append("<td><approvetag number=\""+(number_row--)+"\"></approvetag></td><tr>");
        };
        sb.append("<td><approvetag number=\""+(number_row--)+"\"></approvetag></td><tr>");
        return sb.toString();
    }


    public String DumpRequestToHTMLTable8new() throws SQLException, ParseException {
        ArrayList data = loadrequests8();
        System.out.println("SIZE::"+data.size());
        StringBuilder sb = new StringBuilder();
        int first = 1;
        int number_row=data.size()/7;
        for (int i=0; i<data.size(); i++){
            System.out.println("i::>>"+i+"@data::"+data.get(i));
            if (i%7==0) {
                if ((first == 1) && (number_row!=1)){
                    first =0;
                    sb.append("<tr>");
                }
                else sb.append("<td><approvetag number=\""+(number_row--)+"\"></approvetag></td><tr>");

            }
            if ((i%3==0) || (i%5==0)) {
                /////////////old        sb.append("<td>" + data.get(i) + "</td>");

                String load = String.valueOf(data.get(i));
                System.out.println("PARSING::"+load);
                sb.append("<td>"+Beatyfulizer.schoneJSON(ParcedJSON.parse(load))+ "</td>");
                continue;
            }
            sb.append("<td>"+data.get(i)+"</td>");

            // if (i%5==0)
            //     sb.append("</td>");
        };
        sb.append("<td><approvetag number=\""+(number_row--)+"\"></approvetag></td><tr>");
        return sb.toString();
    }


}
