package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    String pinnumber;
    
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setVerticalAlignment(SwingConstants.TOP);
        mini.setBounds(20, 140, 350, 200);
        add(mini);
        
        JLabel bank = new JLabel("NavaAndhra Bank");
        bank.setBounds(130,20,200,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);                       
        
        try{
            Connc conn = new Connc();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+" XXXX XXXX "+rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        // Fetch card number securely
        try {
            Connc conn = new Connc();
            String query = "SELECT cardnumber FROM login WHERE pin = ?";
            PreparedStatement ps = conn.c.prepareStatement(query);
            ps.setString(1, pinnumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cardNumber = rs.getString("cardnumber");
                card.setText("Card Number: " + cardNumber.substring(0, 4) + " XXXX XXXX " + cardNumber.substring(12));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fetch transactions and calculate balance
        try {
            Connc conn = new Connc();
            String query = "SELECT date, type, amount FROM bank WHERE pin = ?";
            PreparedStatement ps = conn.c.prepareStatement(query);
            ps.setString(1, pinnumber);
            ResultSet rs = ps.executeQuery();

            double bal = 0.0;
            StringBuilder html = new StringBuilder("<html>");
            while (rs.next()) {
                String type = rs.getString("type");
                double amt = rs.getDouble("amount");
                String date = rs.getString("date");

                html.append(date)
                    .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                    .append(type)
                    .append("&nbsp;&nbsp;&nbsp;&nbsp;Rs ")
                    .append(amt)
                    .append("<br><br>");

                if ("Deposit".equalsIgnoreCase(type)) {
                    bal += amt;
                } else {
                    bal -= amt;
                }
            }
            html.append("</html>");

            mini.setText(html.toString());
            balance.setText("Your current balance is Rs " + bal);

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}