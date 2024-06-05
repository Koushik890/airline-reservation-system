package airlinereservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton reset, submit, close;
    JTextField tfUsername, tfPassword;
    
    public Login(){
        
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(20, 20, 100, 20);
        add(lblUsername);
        
        tfUsername = new JTextField();
        tfUsername.setBounds(130, 20, 200, 20);
        add(tfUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(20, 60, 100, 20);
        add(lblPassword);
        
        tfPassword = new JTextField();
        tfPassword.setBounds(130, 60, 200, 20);
        add(tfPassword);
        
        reset = new JButton("Reset");
        reset.setBounds(50, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(200, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);
        
        setSize(400, 250);
        setLocation(600, 250);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username = tfUsername.getText();
            String password = tfPassword.getText();
            
            try{
                ConnectionDB c = new ConnectionDB();
                
                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username and Password");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == reset){
            tfUsername.setText("");
            tfPassword.setText("");
        }else if(ae.getSource() == close){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
