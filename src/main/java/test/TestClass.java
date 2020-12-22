package test;

import fr.roland.DB.Executor;
import org.jetbrains.annotations.NotNull;
import util.DB.DataBaseHelper;

import java.sql.*;
import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) throws SQLException {
        System.out.println("UU");
       // DataBaseHelper dbh = new DataBaseHelper("jdbc:mysql://localhost/avs?user=avs&password=evbhPoU5JkW9fZyX", true);
        Executor exec  = new Executor("jdbc:mysql://localhost:3306/avs", "avs", "evbhPoU5JkW9fZyX") ;


        ArrayList data = new ArrayList<>();
        data.add("АКБ ПП залитые");


        ResultSet metals = exec.executePreparedSelect("SELECT * FROM metal where name=?", data);
        while (metals.next()){
            System.out.println(String.valueOf(metals.getObject("id")) + " :::  "+ String.valueOf(metals.getObject("name")));
        }
    }
}
