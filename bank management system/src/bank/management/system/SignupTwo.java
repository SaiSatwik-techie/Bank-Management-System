package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

    private static final Color DEEP_BLUE = new Color(0x003366);
    private static final int FRAME_WIDTH = 850;
    private static final int HEADER_HEIGHT = 70;
    
    JButton next;
    JRadioButton yes,no,Syes,Sno;
    JComboBox religioncb,occupcb,castcb,incomecb,educb, nationalityCb;
    JLabel additionalDetails,nationality,status,religion,occup,category,income,edu,pin,pan,adhar;
    JTextField adharTf,panTf;
    String formno;
    SignupTwo(String form) {
        this.formno=form;
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
        
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
        
        

       
        
        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,100,300,30);
        add(additionalDetails);
        
        religion = new JLabel("RELIGION : ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,200,150,30);
        religion.setForeground(DEEP_BLUE);
        add(religion);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religioncb = new JComboBox(valReligion);
        religioncb.setBounds(320,200,400,30);
        religioncb.setSelectedIndex(-1);  // No item selected initially

        add(religioncb);
        
        /*nameTf=new JTextField();
        nameTf.setFont(new Font("Raleway",Font.BOLD,14));
        nameTf.setBounds(500,200,200,30);
        add(nameTf);*/
        
        category = new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,250,250,30);
        category.setForeground(DEEP_BLUE);
        add(category);
        
        String cast[]={"BC","SC","ST","OC","Other"};
        castcb = new JComboBox(cast);
        castcb.setBounds(320,250,400,30);
        castcb.setSelectedIndex(-1);  
        add(castcb);
        
        income = new JLabel("Income: ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,300,250,30);
        income.setForeground(DEEP_BLUE);
        add(income);
        
        String incomes[]={"NULL","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        incomecb = new JComboBox(incomes);
        incomecb.setBounds(320,300,400,30);
        incomecb.setSelectedIndex(-1);  
        add(incomecb);
        
        edu = new JLabel("Education: ");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,350,250,30);
        edu.setForeground(DEEP_BLUE);
        add(edu); 
        
        String eduvalues[]={"Non-Graduation","Graduate","Post-Graduate","Doctrate","others"};
        educb = new JComboBox(eduvalues);
        educb.setBounds(320,350,400,30);
        educb.setSelectedIndex(-1);  
        add(educb);
        
        
        occup = new JLabel("Occupation : ");
        occup.setFont(new Font("Raleway",Font.BOLD,20));
        occup.setBounds(100,400,250,30);
        occup.setForeground(DEEP_BLUE);
        add(occup);
        
        String occupvalues[]={"Salaried",
    "Self-Employed",
    "Business",
    "Student",
    "Retired",
    "Homemaker",
    "Unemployed",
    "Other"};
        occupcb = new JComboBox(occupvalues);
        occupcb.setBounds(320,400,400,30);
        occupcb.setSelectedIndex(-1);  
        add(occupcb);
      
        nationality = new JLabel("Nationality : ");
        nationality.setFont(new Font("Raleway", Font.BOLD, 20));
        nationality.setBounds(100,450,250,30);
        nationality.setForeground(DEEP_BLUE);
        add(nationality);

        String[] nationalities = {"Indian", "NRI", "Other"};
        nationalityCb = new JComboBox(nationalities);
        nationalityCb.setBounds(320,450,400,30);
        nationalityCb.setSelectedIndex(-1);  
        add(nationalityCb);

        
       /* married = new JRadioButton("Married");
        married.setBounds(320,450,80,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(400,450,90,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        */
        
        pan = new JLabel("Pan Number: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,500,250,30);
        pan.setForeground(DEEP_BLUE);
        add(pan);
        
        panTf=new JTextField();
        panTf.setFont(new Font("Raleway",Font.BOLD,14));
        panTf.setBounds(320,500,400,30);
        add(panTf);
        
        adhar = new JLabel("Adhar Number :  ");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setBounds(100,550,250,30);
        adhar.setForeground(DEEP_BLUE);
        add(adhar);
        
        adharTf=new JTextField();
        adharTf.setFont(new Font("Raleway",Font.BOLD,14));
        adharTf.setBounds(320,550,400,30);
        add(adharTf);
        
        pin = new JLabel("Senior Citigen : ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,600,250,30);
        pin.setForeground(DEEP_BLUE);
        add(pin);
        
       Syes = new JRadioButton("Yes");
        Syes.setBounds(320,600,80,30);
        Syes.setBackground(Color.WHITE);
        add(Syes);
        
        Sno = new JRadioButton("No");
        Sno.setBounds(420,600,90,30);
        Sno.setBackground(Color.WHITE);
        add(Sno);
        
        ButtonGroup srgroup = new ButtonGroup();
        srgroup.add(Syes);
        srgroup.add(Sno);
        
        status = new JLabel("Existing Account : ");
        status.setFont(new Font("Raleway",Font.BOLD,20));
        status.setBounds(100,650,250,30);
        status.setForeground(DEEP_BLUE);
        add(status);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(320,650,80,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(420,650,90,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup statusgroup = new ButtonGroup();
        statusgroup.add(yes);
        statusgroup.add(no);
        
        next = new JButton("NEXT");
        next.setBounds(620,700,80,30);
        next.setBackground(Color.decode("#FFCC00"));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setFocusPainted(false);
        add(next);
        next.addActionListener(this);
        
        // Frame Setup
        getContentPane().setBackground(Color.WHITE);
        setSize(FRAME_WIDTH, 800);
        setLayout(null);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    String religion    = (String) religioncb.getSelectedItem();
    String category    = (String) castcb.getSelectedItem();
    String income      = (String) incomecb.getSelectedItem();
    String education   = (String) educb.getSelectedItem();
    String occupation  = (String) occupcb.getSelectedItem();
    String nationality = (String) nationalityCb.getSelectedItem();

    String pan   = panTf.getText();
    String adhar = adharTf.getText();

    String seniorCitizen = Syes.isSelected() ? "Yes" : (Sno.isSelected() ? "No" : null);
    String existingAcc   = yes.isSelected() ? "Yes" : (no.isSelected() ? "No" : null);

    try {
        if (pan.equals("") || adhar.equals("")) {
            JOptionPane.showMessageDialog(null, "PAN and Aadhaar are required");
        } else {
            Connc c = new Connc();
            String query = "insert into signuptwo values('" 
                    + formno + "', '" + religion + "', '" + category + "', '" 
                    + income + "', '" + education + "', '" + occupation + "', '" 
                    + nationality + "', '" + pan + "', '" + adhar + "', '" 
                    + seniorCitizen + "', '" + existingAcc + "')";
            c.s.executeUpdate(query);

            // go to next page
           setVisible(false);
           new SignupThree(formno).setVisible(true);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}


    public static void main(String args[]) {
        new SignupTwo("");
    }
}