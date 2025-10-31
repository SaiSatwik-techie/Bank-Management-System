package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JLabel text,pintext,repintext;
    JPasswordField pin,repin;
    JButton change,back;
    
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmatm2.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         image.setLayout(null);
         add(image);
         
         text = new JLabel("CHANGE YOUR PIN:");
         text.setForeground(new Color(255,240,100));
         text.setFont(new Font("System",Font.BOLD,18));
         text.setBounds(250,200,500,50);
         image.add(text);
         
         pintext = new JLabel("ENTER NEW PIN:");
         pintext.setForeground(Color.white);
         pintext.setFont(new Font("System",Font.BOLD,16));
         pintext.setBounds(220,270,180,25);
         image.add(pintext);
         
         pin = new JPasswordField();
         pin.setFont(new Font("Raleway",Font.BOLD,25));
         pin.setBounds(220,310,200,25);
         image.add(pin);
         
         repintext = new JLabel("Re-Enter New PIN:");
         repintext.setForeground(Color.white);
         repintext.setFont(new Font("System",Font.BOLD,16));
         repintext.setBounds(220,360,180,25);
         image.add(repintext);
         
         repin = new JPasswordField();
         repin.setFont(new Font("Raleway",Font.BOLD,25));
         repin.setBounds(220,390,200,25);
         image.add(repin);
         
         change = new JButton("CHANGE");
         change.setBounds(350,485,150,30);
          change.addActionListener(this);
         image.add(change);
         
         back = new JButton("BACK");
         back.setBounds(350,450,150,30);
         back.addActionListener(this);
         image.add(back);
         
         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){ 
       try{
           String npin = pin.getText();
           String rpin = repin.getText();
           if(!npin.equals(rpin)){
               JOptionPane.showMessageDialog(null, "Entered pin does not match");
               return;
           }
           
           if(npin.equals("")||rpin.equals("")){
               JOptionPane.showMessageDialog(null, "please fill the fields properly");
               return;
           }
           
           Connc conn = new Connc();
           String query1 = "update bank set pin= '"+rpin+"' where pin ='"+pinnumber+"'";
           String query2 = "update login set pin= '"+rpin+"' where pin ='"+pinnumber+"'";
           String query3 = "update signupthree set pin= '"+rpin+"' where pin ='"+pinnumber+"'";

           conn.s.executeUpdate(query1);
           conn.s.executeUpdate(query2);
           conn.s.executeUpdate(query3);
           
           JOptionPane.showMessageDialog(null, "PIN changed successfully");
           setVisible(false);
           new Transactions(rpin).setVisible(true);
           
       }catch(Exception e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());

       }
    
    }else{
    setVisible(false);
    new Transactions(pinnumber).setVisible(true);
}
    }
    
    public static void main(String args[]){
        new PinChange("");
    }
}
