package airlinereservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, tfphone, tfemail, tfgender, tffname, tffcode;
    JButton bookFlights, fetchUserButton, fetchFlights;
    Choice source, destination;
    JDateChooser dcdate;
    
    public BookFlight(){
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(360, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadahar Number");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);
        
        fetchUserButton = new JButton("Fetch User");
        fetchUserButton.setBounds(380, 80, 150, 25);
        fetchUserButton.setForeground(Color.LIGHT_GRAY);
        fetchUserButton.setBackground(Color.BLUE);
        fetchUserButton.addActionListener(this);
        add(fetchUserButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        tfgender = new JLabel();
        tfgender.setBounds(220, 280, 150, 25);
        add(tfgender);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 330, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblemail);
        
        tfemail = new JLabel();
        tfemail.setBounds(220, 330, 150, 25);
        add(tfemail);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 380, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 380, 150, 25);
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 430, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 430, 150, 25);
        add(destination);
        
        
        try{
            ConnectionDB c = new ConnectionDB();
            String query= "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        fetchFlights = new JButton("Fetch Flights");
        fetchFlights.setBounds(380, 430, 140, 22);
        fetchFlights.setBackground(Color.BLUE);
        fetchFlights.setForeground(Color.WHITE);
        fetchFlights.addActionListener(this);
        add(fetchFlights);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 480, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        tffname = new JLabel();
        tffname.setBounds(220, 480, 150, 25);
        add(tffname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 530, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        tffcode = new JLabel();
        tffcode.setBounds(220, 530, 150, 25);
        add(tffcode);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 580, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 580, 150, 25);
        add(dcdate);
        
        bookFlights = new JButton("Book Flights");
        bookFlights.setBounds(220, 630, 150, 25);
        bookFlights.setBackground(Color.BLUE);
        bookFlights.setForeground(Color.WHITE);
        bookFlights.addActionListener(this);
        add(bookFlights);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinereservationsystem/icons/details.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 90, 500, 400);
        add(lblimage);
        
        
        setSize(1100, 720);
        setLocation(200, 80);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchUserButton){
            String aadhar = tfaadhar.getText();

            try{

                ConnectionDB c = new ConnectionDB();

                String query = "select * from passenger where aadhar = '"+aadhar+"'";

                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    tfgender.setText(rs.getString("gender"));
                    tfemail.setText(rs.getString("email"));
                }else{
                    
                    JOptionPane.showMessageDialog(null, "User Doesn't Exist!, Please Enter Correct Aadhar Number");
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == fetchFlights){
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            
            try{
                
                ConnectionDB  c = new ConnectionDB();
                
                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    tffname.setText(rs.getString("f_name"));
                    tffcode.setText(rs.getString("f_code"));
                }else{
                    JOptionPane.showMessageDialog(null, "No Flights Available");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == bookFlights){
            Random randomNum = new Random();
            String aadhar =  tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightName = tffname.getText();
            String flightCode = tffcode.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String dateTravel = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
        
            try{

                ConnectionDB c = new ConnectionDB();

                String query = "insert into reservation values('PNR-"+randomNum.nextInt(1000000)+"', 'TIC-"+randomNum.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightName+"', '"+flightCode+"', '"+src+"', '"+dest+"', '"+dateTravel+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Flight Booked Successfully");
                
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }    
    }
    
    public static void main(String[] args){
        new BookFlight();
    }
}
