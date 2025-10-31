package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {

    private static final Color DEEP_BLUE = new Color(0x003366);
    private static final int FRAME_WIDTH = 850;
    private static final int HEADER_HEIGHT = 70;
    long random;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male,female,others,married,unmarried;
    JLabel formno,personDetails,name,fathername,dob,gender,email,mstatus,address,city,pin,state;
    JTextField nameTf,fnameTf,emailTf,addTf,cityTf,pinTf,stateTf;
    SignupOne() {
        
        // 1. Create the Full-Width Header Panel (Deep Blue Strip)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(DEEP_BLUE);
        headerPanel.setLayout(null);
        headerPanel.setBounds(0, 0, FRAME_WIDTH, HEADER_HEIGHT);
        add(headerPanel);

        // 2. Place the Scaled Logo Image inside the Header Panel
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
        
        // 3. Application Form Number Title (Below the header)
        Random ran = new Random();
        // Changed to 4 digits for a more standard form number
        random = Math.abs((ran.nextLong() % 9000L) + 1000L); 

        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setForeground(DEEP_BLUE);
        
        // Position the title 20px below the header, centered horizontally
        int titleWidth = 600;
        int titleX = (FRAME_WIDTH - titleWidth) / 2;
        int titleY = HEADER_HEIGHT + 20; 
        
        formno.setBounds(titleX, titleY, titleWidth, 40);
        add(formno);
        
        personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,140,300,30);
        add(personDetails);
        
        name = new JLabel("NAME : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,200,100,30);
        name.setForeground(DEEP_BLUE);
        add(name);
        
        nameTf=new JTextField();
        nameTf.setFont(new Font("Raleway",Font.BOLD,14));
        nameTf.setBounds(320,200,400,30);
        add(nameTf);
        
        fathername = new JLabel("FATHER'S NAME : ");
        fathername.setFont(new Font("Raleway",Font.BOLD,20));
        fathername.setBounds(100,250,250,30);
        fathername.setForeground(DEEP_BLUE);
        add(fathername);
        
        fnameTf=new JTextField();
        fnameTf.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTf.setBounds(320,250,400,30);
        add(fnameTf);
        
        dob = new JLabel("Date of birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,300,250,30);
        dob.setForeground(DEEP_BLUE);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(320,300,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,350,250,30);
        gender.setForeground(DEEP_BLUE);
        add(gender); 
        
        male = new JRadioButton("Male");
        male.setBounds(320,350,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
       
        female = new JRadioButton("FEMALE");
        female.setBounds(400,350,80,30);
        female.setBackground(Color.WHITE);

        add(female);
        
        others = new JRadioButton("OTHERS");
        others.setBounds(500,350,80,30);
        others.setBackground(Color.WHITE);

        add(others);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);
       
        email = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,400,250,30);
        email.setForeground(DEEP_BLUE);
        add(email);
        
        emailTf=new JTextField();
        emailTf.setFont(new Font("Raleway",Font.BOLD,14));
        emailTf.setBounds(320,400,400,30);
        add(emailTf);
        
        mstatus = new JLabel("Marital Status : ");
        mstatus.setFont(new Font("Raleway",Font.BOLD,20));
        mstatus.setBounds(100,450,250,30);
        mstatus.setForeground(DEEP_BLUE);
        add(mstatus);
        
        married = new JRadioButton("Married");
        married.setBounds(320,450,80,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(400,450,90,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup morunm = new ButtonGroup();
        morunm.add(married);
        morunm.add(unmarried);
        
        address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,500,250,30);
        address.setForeground(DEEP_BLUE);
        add(address);
        
        addTf=new JTextField();
        addTf.setFont(new Font("Raleway",Font.BOLD,14));
        addTf.setBounds(320,500,400,30);
        add(addTf);
        
        city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,550,250,30);
        city.setForeground(DEEP_BLUE);
        add(city);
        
        cityTf=new JTextField();
        cityTf.setFont(new Font("Raleway",Font.BOLD,14));
        cityTf.setBounds(320,550,400,30);
        add(cityTf);
        
        pin = new JLabel("Pin Code : ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,600,250,30);
        pin.setForeground(DEEP_BLUE);
        add(pin);
        
        pinTf=new JTextField();
        pinTf.setFont(new Font("Raleway",Font.BOLD,14));
        pinTf.setBounds(320,600,400,30);
        add(pinTf);
        
        state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,650,250,30);
        state.setForeground(DEEP_BLUE);
        add(state);
        
        stateTf=new JTextField();
        stateTf.setFont(new Font("Raleway",Font.BOLD,14));
        stateTf.setBounds(320,650,400,30);
        add(stateTf);
        
        next = new JButton("NEXT");
        next.setBounds(620,700,80,30);
        next.setBackground(Color.decode("#FFCC00"));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setFocusPainted(false);
        next.addActionListener(this);
        add(next);
        
        // Frame Setup
        getContentPane().setBackground(Color.WHITE);
        setSize(FRAME_WIDTH, 800);
        setLayout(null);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;//long
        String name = nameTf.getText();
        String fname= fnameTf.getText();
        String dob =  ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTf.getText();
        String marital= null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";    
    }
        String address = addTf.getText();
        String city = cityTf.getText();
        String pin = pinTf.getText();
        String state = stateTf.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                Connc c = new Connc();
                String query = "insert into signup values('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String args[]) {
        new SignupOne();
    }
}