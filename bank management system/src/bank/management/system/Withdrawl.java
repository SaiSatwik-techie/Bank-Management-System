package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JLabel text;
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmatm2.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        image.setLayout(null);
        add(image);

        text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(210, 180, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(210, 250, 280, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 380, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 430, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText().trim();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                return;
            }

            try {
                double amt = Double.parseDouble(number);
                if (amt <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive amount");
                    return;
                }

                // Check balance
               double balanceAmount = 0.0;
Connc connc = new Connc();
                String balanceQuery = "SELECT type, amount FROM bank WHERE pin = ?";
                PreparedStatement ps = connc.c.prepareStatement(balanceQuery);
                ps.setString(1, pinnumber);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    double transactionAmount = rs.getDouble("amount");

                    if ("Deposit".equalsIgnoreCase(type)) {
                        balanceAmount += transactionAmount;
                    } else {
                        balanceAmount -= transactionAmount;
                    }
                }

                rs.close();
                ps.close();

                if (amt > balanceAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Record withdrawal
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(date);

                String withdrawQuery = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
                PreparedStatement ps2 = connc.c.prepareStatement(withdrawQuery);
                ps2.setString(1, pinnumber);
                ps2.setString(2, formattedDate);
                ps2.setString(3, "Withdrawl");
                ps2.setDouble(4, amt);
                ps2.executeUpdate();

                ps2.close();

                JOptionPane.showMessageDialog(null, "Rs " + amt + " withdrawn successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage());
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Withdrawl("");
    }
}
               