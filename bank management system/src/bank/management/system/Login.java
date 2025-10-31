package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logoS2.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel label = new JLabel(i3);
        label.setBounds(70,20,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to NavaAndhra Bank");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,585,40);
        add(text);
        
        JLabel cardno = new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,400,40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 155,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,250,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));

        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(310,300,100,30);
        login.setBackground(Color.decode("#003366"));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setFocusPainted(false);
        add(login);
        login.addActionListener(this);
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.decode("#003366"));
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setFocusPainted(false);
        add(clear);
        clear.addActionListener(this);

        
        
        signup = new JButton("SIGN UP");
        signup.setBounds(310,350,245,30);
        signup.setBackground(Color.decode("#FFCC00"));
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setFocusPainted(false);
        add(signup);
        signup.addActionListener(this);

        getContentPane().setBackground(Color.white);
                setLayout(null);
                setSize(800,480);
                setVisible(true);
                setLocation(350,200);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == clear){
          cardTextField.setText("");
          pinTextField.setText("");
      }else if(ae.getSource()== login){
          Connc connc = new Connc();
          String cardnumber = cardTextField.getText();
          String pinnumber = pinTextField.getText();
          String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
          try{
              ResultSet rs = connc.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
              }else{
                  JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin");
              }
          }catch(Exception e){
              System.out.println(e);
          }
      } else if(ae.getSource()== signup){
          setVisible(false);
          new SignupOne().setVisible(true);
      }
    }
    
    public static void main(String args[]){
      
  new Login();
    }
}

