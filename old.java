

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
