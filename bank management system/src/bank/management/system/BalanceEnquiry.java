
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmatm2.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         image.setLayout(null);
         add(image);
        
         JLabel text = new JLabel("YOUR CURRENT BALANCE IS :");
         text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(230, 200, 400, 30);
        image.add(text);
        
        JLabel balanceLabel = new JLabel();
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("System", Font.BOLD, 18));
        balanceLabel.setBounds(250, 300, 400, 30);
        image.add(balanceLabel);
        
        double balance = 0.0;
        

try {
    Connc c = new Connc();  // Assuming Connc.c is your Connection object
    String query = "SELECT type, amount FROM bank WHERE pin = ?";
    
    PreparedStatement ps = c.c.prepareStatement(query);
    ps.setString(1, pinnumber);
    
    ResultSet rs = ps.executeQuery();
    
    while (rs.next()) {
        String type = rs.getString("type");
        double amt = rs.getDouble("amount");
        
        if ("Deposit".equalsIgnoreCase(type)) {
            balance += amt;
        } else {
            balance -= amt;
        }
    }
    
    rs.close();
    ps.close();
    // c.c.close(); // Optional — close here only if you’re done with this connection

} catch (SQLException e) {
    e.printStackTrace(); // For debugging
    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
}

        balanceLabel.setText("Rs " + balance);
        
        back = new JButton("BACK");
        back.setBounds(355, 480, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== back){
           setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
        
       
    
    
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
