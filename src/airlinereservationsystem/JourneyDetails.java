package airlinereservationsystem;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class JourneyDetails extends JFrame implements ActionListener{
 
    JTable journeydetails;
    JTextField tfpnr;
    JButton showInfo;
    
    public JourneyDetails(){
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(160, 50, 100, 25);
        add(tfpnr);
        
        showInfo = new JButton("Show Details");
        showInfo.setBackground(Color.BLACK);
        showInfo.setBackground(Color.WHITE);
        showInfo.setBounds(290, 50, 120, 25);
        showInfo.addActionListener(this);
        add(showInfo);
        
        journeydetails = new JTable();
        JScrollPane jsp = new JScrollPane(journeydetails);
        jsp.setBounds(0, 100, 800, 150);
        jsp.getViewport().setBackground(Color.ORANGE);
        add(jsp);
        
        setSize(810, 600);
        setLocation(400, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            ConnectionDB c = new ConnectionDB();
            
            ResultSet rs = c.s.executeQuery("select * from reservation where PNR = '"+tfpnr.getText()+"'");
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            journeydetails.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new JourneyDetails();
    }
}
