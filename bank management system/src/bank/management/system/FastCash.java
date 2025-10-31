
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmatm2.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         image.setLayout(null);
         add(image);
         
         JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
         text.setBounds(240,200,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);
         
         deposit = new JButton("Rs 100");
         deposit.setBounds(220,350,120,30);
         deposit.addActionListener(this);
         image.add(deposit);
         
         withdrawl = new JButton("Rs 500");
         withdrawl.setBounds(380,350,120,30);
         withdrawl.addActionListener(this);

         image.add(withdrawl);
         
         fastcash = new JButton("Rs 1000");
         fastcash.setBounds(220,400,120,30);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         ministatement = new JButton("Rs 2000");
         ministatement.setBounds(380,400,120,30);
         ministatement.addActionListener(this);
         image.add(ministatement);
         
         pinchange = new JButton("Rs 5000");
         pinchange.setBounds(220,450,120,30);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
         balanceenquiry = new JButton("Rs 10000");
         balanceenquiry.setBounds(380,450,120,30);
         balanceenquiry.addActionListener(this);
         image.add(balanceenquiry);
         
         exit = new JButton("BACK");
         exit.setBounds(380,500,120,20);
         exit.addActionListener(this);
         image.add(exit);
         
                setSize(900,900);
                setLocation(300,0);
                setLayout(null);
                setUndecorated(true);
                setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amountStr = ((JButton)e.getSource()).getText().substring(3);
            double amount = Double.parseDouble(amountStr);
            
          
            try{
                  Connc c = new Connc();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                double balance = 0.0;
             
                 while (rs.next()) {
                String type = rs.getString("type");
                double amt = rs.getDouble("amount");
                if ("Deposit".equalsIgnoreCase(type)) {
                    balance += amt;
                } else {
                    balance -= amt;
                }
            }


            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
                
                Date date = new Date();
                String query = "Insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception ae){
                ae.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ae.getMessage());

            }
        }
        
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
    
}

