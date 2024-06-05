package airlinereservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, tfsource, tfdest, tffname, tffcode, tfdate;
    JButton fetchdetails;
    
    public BoardingPass(){
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("SKY WAVE");
        heading.setBounds(420, 15, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(420, 65, 500, 35);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.DARK_GRAY);
        add(subheading);
        
        JLabel lblpnr = new JLabel("PNR Number");
        lblpnr.setBounds(60, 130, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 130, 150, 25);
        add(tfpnr);
        
        fetchdetails = new JButton("Enter");
        fetchdetails.setBounds(380, 130, 150, 25);
        fetchdetails.setForeground(Color.LIGHT_GRAY);
        fetchdetails.setBackground(Color.BLUE);
        fetchdetails.addActionListener(this);
        add(fetchdetails);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 180, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 180, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 230, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 230, 150, 25);
        add(tfnationality);
        
        JLabel lblsource = new JLabel("SOURCE");
        lblsource.setBounds(60, 280, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        tfsource = new JLabel();
        tfsource.setBounds(220, 280, 150, 25);
        add(tfsource);
        
        JLabel lbldest = new JLabel("DESTINATION");
        lbldest.setBounds(380, 280, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        tfdest = new JLabel();
        tfdest.setBounds(550, 280, 150, 25);
        add(tfdest);
        
        JLabel lblfname = new JLabel("FLIGHT NAME");
        lblfname.setBounds(60, 330, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        tffname = new JLabel();
        tffname.setBounds(220, 330, 150, 25);
        add(tffname);
        
        JLabel lblfcode = new JLabel("FLIGHT CODE");
        lblfcode.setBounds(380, 330, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        tffcode = new JLabel();
        tffcode.setBounds(550, 330, 150, 25);
        add(tffcode);
        
        JLabel lbldate = new JLabel("DATE");
        lbldate.setBounds(60, 380, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        tfdate = new JLabel();
        tfdate.setBounds(220, 380, 150, 25);
        add(tfdate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinereservationsystem/icons/skywave.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(570, 10, 500, 400);
        add(lblimage);
        
        
        setSize(1000, 480);
        setLocation(300, 150);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String pnr = tfpnr.getText();
        try{
            ConnectionDB c = new ConnectionDB();
            ResultSet rs = c.s.executeQuery("select * from reservation where PNR='"+pnr+"'");

            if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfsource.setText(rs.getString("src"));
                    tfdest.setText(rs.getString("dest"));
                    tffname.setText(rs.getString("flightname"));
                    tffcode.setText(rs.getString("flightcode"));
                    tfdate.setText(rs.getString("dateTravel"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid PNR Number!, Enter Correctly");
                }
        }catch(Exception e){
            e.printStackTrace();
        }
                    
    }
    
    public static void main(String[] args){
        new BoardingPass();
    }
}
