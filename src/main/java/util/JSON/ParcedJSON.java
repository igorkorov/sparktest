package util.JSON;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParcedJSON {
    public String Date;
    public String Time;
    public String Waybill_number;
    public String Metall;
    public String Tara;
    public String Netto;
    public String Brutto;
    public String Clogging;
    public String Trash;
    public String Comment;
    public static ParcedJSON parse(String input) throws ParseException {
       //// System.out.println("PARCING JSON::=>\n\n"+input);
        if (input.length()<5)
            return null;
        Object obj = new JSONParser().parse(input);
        JSONObject jo = (JSONObject) obj;
        ParcedJSON pj = new ParcedJSON();
        pj.Date = (String) jo.get("Date");
        pj.Time = (String) jo.get("Time");
        pj.Waybill_number = (String) jo.get("Waybill_number");
        pj.Metall = (String) jo.get("Metall");
        pj.Tara = (String) jo.get("Tara");
        pj.Netto = (String) jo.get("Netto");
        pj.Brutto = (String) jo.get("Brutto");
        pj.Clogging = (String) jo.get("Clogging");
        pj.Trash = (String) jo.get("Trash");
        pj.Comment = (String) jo.get("Comment");
        return pj;
    };

}
