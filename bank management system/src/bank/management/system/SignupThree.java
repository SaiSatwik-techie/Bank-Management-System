
package bank.management.system;

/*import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 

public class SignupThree extends JFrame implements ActionListener{
    
    String generatedCardNumber;
    String generatedPinNumber;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    ButtonGroup accountTypeGroup;
    JLabel l1,type,cardnumberLabel,cardnumberl,number,pin,pass,pinl,services;
     private static final Color DEEP_BLUE = new Color(0x003366);
    private static final int FRAME_WIDTH = 850;
    private static final int HEADER_HEIGHT = 70;
    SignupThree(String formno){
        this.formno = formno ;
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(DEEP_BLUE);
        headerPanel.setLayout(null);
        headerPanel.setBounds(0, 0, FRAME_WIDTH, HEADER_HEIGHT);
        add(headerPanel);
        try {
            // Loading your Logo.png (assuming it's in the 'icons' folder)
            ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("icons/toplogo.png"));
            
            int logoDisplayWidth = 1000;
            int logoDisplayHeight = 40;

            // Scale the image
            Image image = originalIcon.getImage();
            Image scaledImage = image.getScaledInstance(logoDisplayWidth, logoDisplayHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            
            JLabel logoLabel = new JLabel(scaledIcon);
            
            // Position the logo: 20px from the left, vertically centered
            int logoX = 20;
            int logoY = (HEADER_HEIGHT - logoDisplayHeight) / 2; 
            
            logoLabel.setBounds(logoX, logoY, logoDisplayWidth, logoDisplayHeight); 
            headerPanel.add(logoLabel);

        } catch (Exception e) {
            // Fallback: If logo fails to load, place the text title in the header
            JLabel fallbackTitle = new JLabel("NavaAndhra Bank");
            fallbackTitle.setForeground(Color.WHITE);
            fallbackTitle.setFont(new Font("Arial", Font.BOLD, 20));
            fallbackTitle.setBounds(20, (HEADER_HEIGHT - 30) / 2, 400, 30);
            headerPanel.add(fallbackTitle);
        }
        
        
        
        
        l1=new JLabel("Page 3: Account Details");
        l1.setBounds(300,100,400,40);
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        add(l1);
        
        type = new JLabel("Account Type");
        type.setBounds(100,180,200,30);
        type.setFont(new Font("Raleway",Font.BOLD,22));
        add(type);
        
        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,240,170,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(280,240,220,20);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,280,170,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(280,280,250,20);
        add(r4);
        
        accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(r1);
        accountTypeGroup.add(r2);
        accountTypeGroup.add(r3);
        accountTypeGroup.add(r4);

        
        cardnumberLabel = new JLabel("Card Number");
        cardnumberLabel.setFont(new Font("RAleway",Font.BOLD,22));
        cardnumberLabel.setBounds(100,330,200,30);
        add(cardnumberLabel);
        
        cardnumberl = new JLabel("Your 16 digit Card Number");
        cardnumberl.setFont(new Font("Arial",Font.BOLD,11));
        cardnumberl.setBounds(100,360,200,30);
        add(cardnumberl);
        
        number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(310,330,280,30);
        add(number);
        
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,400,200,30);
        add(pin);
        
        pass = new JLabel("XXXX");
        pass.setFont(new Font("Raleway",Font.BOLD,22));
        pass.setBounds(310,400,280,30);
        add(pass);
        
        
        
        pinl = new JLabel("Your 4 digit Password");
        pinl.setFont(new Font("Raleway",Font.BOLD,11));
        pinl.setBounds(100,430,200,30);
        add(pinl);
        
        services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,480,200,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,520,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,520,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,570,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,570,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,620,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,620,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hearby declares that above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100,690,680,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBounds(250,730,100,30);
        submit.setBackground(Color.decode("#FFCC00"));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial", Font.BOLD, 14));
        submit.setFocusPainted(false);
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400,730,100,30);
        cancel.setBackground(Color.decode("#FFCC00"));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 14));
        cancel.setFocusPainted(false);
        add(cancel);
        cancel.addActionListener(this);
        
        setLayout(null);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == submit){
        String accountType = null;
        if(r1.isSelected()) accountType = "Savings Account";
        else if(r2.isSelected()) accountType = "Fixed Deposit Account";
        else if(r3.isSelected()) accountType = "Current Account";
        else if(r4.isSelected()) accountType = "Recurring Deposit Account";

        // Validation
        if(accountType == null){
            JOptionPane.showMessageDialog(null, "Account type is required");
            return;
        }
        
        if (!c7.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please confirm the declaration to proceed");
            return;
        }


        Random random = new Random();
        generatedCardNumber = "50409360" + String.format("%08d", random.nextInt(100000000));
        generatedPinNumber = String.format("%04d", random.nextInt(10000));

        number.setText(generatedCardNumber);
        pass.setText(generatedPinNumber);
        
        String facility = "";
        if(c1.isSelected()) facility += " ATM Card,";
        if(c2.isSelected()) facility += " Internet Banking,";
        if(c3.isSelected()) facility += " Mobile Banking,";
        if(c4.isSelected()) facility += " Email & SMS Alerts,";
        if(c5.isSelected()) facility += " Cheque Book,";
        if(c6.isSelected()) facility += " E-Statement,";
        if(!c7.isSelected()){
    JOptionPane.showMessageDialog(null, "Please confirm the declaration to proceed");
    return;
}

        if (!facility.isEmpty()) {
            facility = facility.substring(0, facility.length()-1); // remove last comma
        }

        try {
            Connc connc = new Connc();
            String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+generatedCardNumber+"','"+generatedPinNumber+"','"+facility+"')";
            String query2 = "insert into login values('"+formno+"','"+generatedCardNumber+"','"+generatedPinNumber+"')";

            connc.s.executeUpdate(query1);
            connc.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null,"Card Number: " + generatedCardNumber + "\nPIN: " + generatedPinNumber);

          setVisible(false);
          new Transactions(generatedPinNumber).setVisible(true); // Example: go to deposit page after signup
        } catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while saving details. Please try again.");
        
        }
    } 
    else if(ae.getSource() == cancel){
        setVisible(false);
        new Login().setVisible(true); // Go back to login page
    }
}

    public static void main(String args[]){
    new SignupThree("");
}
}
