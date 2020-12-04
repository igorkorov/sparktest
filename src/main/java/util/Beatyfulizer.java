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

    public static String schoneJSON(ParcedJSON input){
        if (input==null)
            return "--";
        StringBuilder result = new StringBuilder();
        result.append("Время: "+ input.Time +   "<br>");
        result.append("Номер накладной: "+ input.Waybill_number +    "<br>");
        result.append("Металл: "+ input.Metall +    "<br>");
        result.append("Тара: "+ input.Tara +    "<br>");
        result.append("Нетто: "+ input.Netto +   "<br>");
        result.append("Брутто: "+ input.Brutto +   "<br>");
        result.append("Засор: "+ input.Clogging +   "<br>");
        result.append("Примесь: "+ input.Trash +   "<br>");
        return result.toString();
    }
}
