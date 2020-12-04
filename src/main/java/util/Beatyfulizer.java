package util;

public class Beatyfulizer {
    public Beatyfulizer(){

    };
    public String beatyfulizerJSON(String input){
        StringBuilder sb = new StringBuilder();
        input = input.replace("{", "");
        input = input.replace("\"","");
        input = input.replace("}","");
        int initial =0;

        int pos = input.indexOf(",", initial);
        sb.append(input.substring(0, pos));


        System.out.println("INITIAL:"+input.substring(0, pos));
        initial = pos;
        pos = input.indexOf(",", initial);
        String current = input.substring(pos+1, input.length());
        while (current.indexOf(",")!=-1) {
            System.out.println("current" + current);
            System.out.println(current.indexOf(","));
            sb.append("<br>");
            sb.append(current);
            sb.append("<br>");
            initial = pos;
            pos = input.indexOf(",", initial);
            current = input.substring(pos+1, input.length());
        }
   /*     while (input.indexOf(",",initial)>0){
            System.out.println("SUBSTRING:"+input);
            pos = input.indexOf(",", initial);
            String current = input.substring(pos+1);

            sb.append(current.substring(initial, pos));
            sb.append("<br>");
            initial=pos;
        }*/
        return sb.toString();

    };


    public static String compareundschoneJSON(ParcedJSON input, ParcedJSON compare){
        String styleinject = "  style=\"background-color: yellow;\"";
        if ((input==null) || (compare==null))
            return schoneJSON(input);
        StringBuilder result = new StringBuilder();
        if ((input.Date ==null) || input.Date.equals(compare.Date))
            result.append("<p>Дата: "+ input.Date +   "<br>");
        else
            result.append("<p"+ styleinject +">Дата: "+ input.Date +   "<br>");

        if ((input.Time ==null) || input.Time.equals(compare.Time))
            result.append("<p>Время: "+ input.Time +   "<br>");
        else
            result.append("<p"+ styleinject +">Время: "+ input.Time +   "<br>");

        if ((input.Waybill_number ==null) || input.Waybill_number.equals(compare.Waybill_number))
            result.append("<p>Номер накладной: "+ input.Waybill_number +   "<br>");
        else
            result.append("<p"+ styleinject +">Номер накладной: "+ input.Waybill_number +   "<br>");

        if ((input.Metall ==null) || input.Metall.equals(compare.Metall))
            result.append("<p>Металл: "+ input.Metall +   "<br>");
        else
            result.append("<p"+ styleinject +">Металл: "+ input.Metall +   "<br>");

        if ((input.Tara ==null) || input.Tara.equals(compare.Tara))
            result.append("<p>Тара: "+ input.Tara +   "<br>");
        else
            result.append("<p"+ styleinject +">Тара: "+ input.Tara +   "<br>");


        if ((input.Netto ==null) || input.Netto.equals(compare.Netto))
            result.append("<p>Нетто: "+ input.Netto +   "<br>");
        else
            result.append("<p"+ styleinject +">Нетто: "+ input.Netto +   "<br>");

        if ((input.Brutto ==null) || input.Brutto.equals(compare.Brutto))
            result.append("<p>Брутто: "+ input.Brutto +   "<br>");
        else
            result.append("<p"+ styleinject +">Брутто: "+ input.Brutto +   "<br>");

        if ((input.Clogging ==null) || input.Clogging.equals(compare.Clogging))
            result.append("<p>Засор: "+ input.Clogging +   "<br>");
        else
            result.append("<p"+ styleinject +">Засор: "+ input.Clogging +   "<br>");

        if ((input.Trash ==null) || input.Trash.equals(compare.Trash))
            result.append("<p>Примесь: "+ input.Trash +   "<br>");
        else
            result.append("<p"+ styleinject +">Примесь: "+ input.Trash +   "<br>");

        return result.toString();


    };

    public static String schoneJSON(ParcedJSON input){
        if (input==null)
            return "--";
        StringBuilder result = new StringBuilder();
        result.append("<p>Дата: "+ input.Date +   "<br>");
        result.append("<p>Время: "+ input.Time +   "<br>");
        result.append("<p>Номер накладной: "+ input.Waybill_number +    "<br>");
        result.append("<p>Металл: "+ input.Metall +    "<br>");
        result.append("<p>Тара: "+ input.Tara +    "<br>");
        result.append("<p>Нетто: "+ input.Netto +   "<br>");
        result.append("<p>Брутто: "+ input.Brutto +   "<br>");
        result.append("<p>Засор: "+ input.Clogging +   "<br>");
        result.append("<p>Примесь: "+ input.Trash +   "<br>");
 /*       result.append("Время: "+ input.Time +   "<br>");
        result.append("Номер накладной: "+ input.Waybill_number +    "<br>");
        result.append("Металл: "+ input.Metall +    "<br>");
        result.append("Тара: "+ input.Tara +    "<br>");
        result.append("Нетто: "+ input.Netto +   "<br>");
        result.append("Брутто: "+ input.Brutto +   "<br>");
        result.append("Засор: "+ input.Clogging +   "<br>");
        result.append("Примесь: "+ input.Trash +   "<br>");  */
        return result.toString();
    }
}
