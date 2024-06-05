package airlinereservationsystem;

import java.sql.*;

public class ConnectionDB {
    
    Connection c;
    Statement s;
    
    
    public ConnectionDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///airlinereservationsystem", "root", "tiger");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
