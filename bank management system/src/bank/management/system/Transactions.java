
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmatm2.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         image.setLayout(null);
         add(image);
         
         JLabel text = new JLabel("Please select your Transaction");
         text.setBounds(240,200,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);
         
         deposit = new JButton("Deposit");
         deposit.setBounds(220,350,120,30);
         deposit.addActionListener(this);
         image.add(deposit);
         
         withdrawl = new JButton("Withdrawl");
         withdrawl.setBounds(380,350,120,30);
         withdrawl.addActionListener(this);

         image.add(withdrawl);
         
         fastcash = new JButton("Fast Cash");
         fastcash.setBounds(220,400,120,30);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         ministatement = new JButton("Mini Statement");
         ministatement.setBounds(380,400,120,30);
         ministatement.addActionListener(this);
         image.add(ministatement);
         
         pinchange = new JButton("Pin Change");
         pinchange.setBounds(220,450,120,30);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
         balanceenquiry = new JButton("Balance Enquiry");
         balanceenquiry.setBounds(360,450,150,30);
         balanceenquiry.addActionListener(this);
         image.add(balanceenquiry);
         
         exit = new JButton("Exit");
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
            System.exit(0);
         }else if(e.getSource() == deposit){
             setVisible(false);
             new Deposit(pinnumber).setVisible(true);
         }else if(e.getSource()== withdrawl){
             setVisible(false);
             new Withdrawl(pinnumber).setVisible(true);
         }else if(e.getSource()==fastcash){
             setVisible(false);
             new FastCash(pinnumber).setVisible(true);
         }else if(e.getSource()== pinchange){
             setVisible(false);
             new PinChange(pinnumber).setVisible(true);
         }else if(e.getSource()== balanceenquiry){
             setVisible(false);
             new BalanceEnquiry(pinnumber).setVisible(true);
         }else if(e.getSource() == ministatement){
             setVisible(false);
             new MiniStatement(pinnumber).setVisible(true);
         }
        
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
    
}
