package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class Deposit extends JFrame implements ActionListener{
    
    JLabel text ;
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
Deposit(String pinnumber){
    this.pinnumber = pinnumber;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmatm2.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         image.setLayout(null);
         add(image);
         
         text = new JLabel("Enter the amount you want to deposit");
         text.setBounds(210,180,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);
         
         amount = new JTextField();
         amount.setFont(new Font("Raleway",Font.BOLD,22));
         amount.setBounds(210,250,280,25);
         image.add(amount);
         
         deposit = new JButton("Deposit");
         deposit.setBounds(355,380,150,30);
         deposit.addActionListener(this);
         image.add(deposit);
         
         back = new JButton("Back");
         back.setBounds(355,430,150,30);
         back.addActionListener(this);
         image.add(back);
         
    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
} 

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==deposit){
        String number = amount.getText().trim();
        if(number.equals("")){
            JOptionPane.showMessageDialog(null,"please enter amount you wants to deposit");
            return;
        }
         try {
            double amt = Double.parseDouble(number);
            if (amt <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a positive amount");
                return;
            }
        
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);
        
          Connc connc = new Connc();
          String query = "insert into bank values('"+pinnumber+"','"+formattedDate+"','Deposit','"+number+"')";
          connc.s.executeUpdate(query);
           
          JOptionPane.showMessageDialog(null,"Rs"+amt+" Deposited Successfully");
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
          
          
         }catch(NumberFormatException e){
              JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");   
             }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while processing the deposit. Please try again.");
        }
         }
        
    else if(ae.getSource()== back){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}


public static void main(String args[]){
    new Deposit("");
}
}
