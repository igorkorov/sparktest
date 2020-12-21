package test;

import util.DB.DataBaseHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestClass {
    public static void main(String[] args) throws SQLException {
        System.out.println("TESTSTS");
       // DataBaseHelper dbh = new DataBaseHelper("jdbc:mysql://localhost/avs?user=avs&password=evbhPoU5JkW9fZyX", true);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/avs", "avs", "evbhPoU5JkW9fZyX");
        ResultSet metals = conn.createStatement().executeQuery("SELECT * FROM metal");
        while (metals.next()){
            System.out.println(String.valueOf(metals.getObject("id")) + " :::  "+ String.valueOf(metals.getObject("name")));
        }
    }
}
