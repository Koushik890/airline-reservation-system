package airlinereservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname, tfnationality, tfaadhar, tfaddress, tfphone, tfemail;
    JRadioButton rbmale, rbfemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(250, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);
        
        JLabel lblaadhar = new JLabel("Aadahar Number");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        ButtonGroup genderGroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 75, 25);
        rbmale.setBackground(Color.ORANGE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 75, 25);
        rbfemale.setBackground(Color.ORANGE);
        add(rbfemale);
        
        genderGroup.add(rbmale);
        genderGroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(60, 340, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 340, 150, 25);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 405, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 405, 150, 25);
        add(tfemail);
        
        JButton save = new JButton("SAVE");
        save.setBounds(220, 460, 150, 30);
        save.setBackground(Color.BLUE);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        add(save);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinereservationsystem/icons/customer.png"));
        Image i2 = i1.getImage().getScaledInstance(440, 390, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 80, 430, 400);
        add(image);
        
        
        setSize(900, 600);
        setLocation(300, 150);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String aadhar = tfaadhar.getText();
        String address= tfaddress.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String gender = null;
        
        if(rbmale.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }
        
        try{
            
            ConnectionDB c = new ConnectionDB();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+gender+"','"+aadhar+"', '"+address+"', '"+phone+"', '"+email+"')";
            
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Cutomer Details Added Successfully");
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
