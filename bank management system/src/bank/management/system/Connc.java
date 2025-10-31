package bank.management.system;
import java.sql.*;

public class Connc{
    Connection c;
    Statement s;
    public Connc(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","whathacked143@gmail.com");
            s = c.createStatement();
            System.out.println("✅ Database connected successfully");
        }catch(Exception e){
            System.out.println(e);
             e.printStackTrace(); // show full error
            System.out.println("❌ Database connection failed: " + e.getMessage());
        }
    }
}