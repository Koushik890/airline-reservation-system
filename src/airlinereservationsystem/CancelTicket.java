package airlinereservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class CancelTicket extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, cancellationno, tfdatetravel, tffname, tfsource, tfdestination;
    JButton bookFlights, fetchTicket, cancel;
    JDateChooser dcdate;
    
    public CancelTicket(){
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        
        Random randomNum = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(280, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.magenta);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinereservationsystem/icons/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(280, 60, 500, 410);
        add(image);
        
        JLabel lblpnr = new JLabel("PNR Number");
        lblpnr.setBounds(60, 80, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        fetchTicket = new JButton("Show Details");
        fetchTicket.setBounds(380, 80, 150, 25);
        fetchTicket.setForeground(Color.LIGHT_GRAY);
        fetchTicket.setBackground(Color.BLUE);
        fetchTicket.addActionListener(this);
        add(fetchTicket);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel lblcancellation = new JLabel("Cancellation No.");
        lblcancellation.setBounds(60, 180, 150, 25);
        lblcancellation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcancellation);
        
        cancellationno = new JLabel(""+randomNum.nextInt(1000000));
        cancellationno.setBounds(220, 180, 150, 25);
        add(cancellationno);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 230, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        tffname = new JLabel();
        tffname.setBounds(220, 230, 150, 25);
        add(tffname);
        
        JLabel lbldatetravel = new JLabel("Date of Travel");
        lbldatetravel.setBounds(60, 280, 150, 25);
        lbldatetravel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldatetravel);
        
        tfdatetravel = new JLabel();
        tfdatetravel.setBounds(220, 280, 150, 25);
        add(tfdatetravel);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        tfsource = new JLabel();
        tfsource.setBounds(220, 330, 150, 25);
        add(tfsource);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        tfdestination = new JLabel();
        tfdestination.setBounds(220, 380, 150, 25);
        add(tfdestination);
        
        cancel = new JButton("Cancel Ticket");
        cancel.setBounds(220, 430, 140, 30);
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(800, 520);
        setLocation(350, 140);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String pnr = tfpnr.getText();
        if(ae.getSource() == fetchTicket){
            try{

                ConnectionDB c = new ConnectionDB();
                ResultSet rs = c.s.executeQuery("select * from reservation where PNR='"+pnr+"'");

                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tffname.setText(rs.getString("flightname"));
                    tfdatetravel.setText(rs.getString("dateTravel"));
                    tfsource.setText(rs.getString("src"));
                    tfdestination.setText(rs.getString("dest"));
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid PNR Number!, Enter Correctly");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            String pnrnum = tfpnr.getText();
            String name = tfname.getText();
            String cancelno = cancellationno.getText();
            String fname = tffname.getText();
            String date = tfdatetravel.getText();
            String source = tfsource.getText();
            String dest = tfdestination.getText();
            
            try{
                ConnectionDB c = new ConnectionDB();
                c.s.executeUpdate("insert into cancel values('"+pnrnum+"', '"+name+"', '"+cancelno+"', '"+fname+"', '"+date+"', '"+source+"', '"+dest+"')");
                c.s.executeUpdate("delete from reservation where PNR = '"+pnrnum+"'");
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public static void main(String[] args){
        new CancelTicket();
    }
}
