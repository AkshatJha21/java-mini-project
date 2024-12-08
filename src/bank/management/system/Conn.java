package bank.management.system;

import java.sql.*;

public class Conn {
    Connection con;
    Statement stmt;

    public Conn() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Akshat@2003");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
