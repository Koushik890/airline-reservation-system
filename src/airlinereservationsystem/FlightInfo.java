package airlinereservationsystem;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {
 
    public FlightInfo(){
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        
        JTable flightDetails = new JTable();
        
        try{
            
            ConnectionDB c = new ConnectionDB();
            
            ResultSet rs = c.s.executeQuery("select * from flight");
            flightDetails.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(flightDetails);
        jsp.setBounds(0, 0, 800, 500);
        jsp.getViewport().setBackground(Color.ORANGE);
        add(jsp);
        
        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new FlightInfo();
    }
}
