import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.Random;

public class bookFlight extends JFrame implements ActionListener {
    JLabel text , Name , Nationality , Adhaar , Address , Gender ,image,t2, t3, t4 ,t5, sor ,dest ,fn ,fc , t6 ,t7 ,cal ;
    JTextField t1 ;
    JButton user , flight , book;
    ImageIcon icon ,i1 ;
    Image i2 ;
    JComboBox <String> c1 , c2 ;
    JDateChooser dc ;
    Random random;
    public bookFlight(){
        
        //HEADING//
        text = new JLabel ("BOOK FLIGHT");
        text.setBounds(490,10,250,50);
        text.setFont(new Font ("Arial",Font.BOLD,20));
        text.setForeground(Color.BLUE);
        add(text);    
        
        //IMAGE//
        i1 = new ImageIcon (ClassLoader.getSystemResource("pics/details.jpg"));
        i2 = i1.getImage().getScaledInstance(450,400, Image.SCALE_DEFAULT);
        icon = new ImageIcon(i2);
        image = new JLabel(icon);
        image.setBounds(550,150,500,410);
        add(image);
        
        //ADHAAR//
        Adhaar = new JLabel ("ADHAAR NO.");
        Adhaar.setBounds(10,70,100,50);
        add(Adhaar);
        t1 = new JTextField();
        t1.setBounds(100,80,220,30);
        add(t1);
        
        //USER DETAIL BUTTON//
        user = new JButton("USER DETAIL");
        user.setBounds(330,80,130,30);
        user.setFont(new Font("Arial", Font.PLAIN ,10));
        user.setBackground(Color.BLACK);
        user.setForeground(Color.WHITE);
        add(user);
        user.addActionListener(this);
        
        // DETAILS ABOUT CUSTOMER //
        //NAME-
        Name = new JLabel ("NAME");
        Name.setBounds(10,120,100,50);
        add(Name);
        t2 = new JLabel ();
        t2.setBounds(100,130,220,30);
        add(t2);
        
        //NATIONALITY-
        Nationality = new JLabel ("NATIONALITY");
        Nationality.setBounds(10,170,100,50);
        add(Nationality);
        t3 = new JLabel ();
        t3.setBounds(100,180,220,30);
        add(t3);
        
        //ADDRESS-
        Address = new JLabel ("ADDRESS");
        Address.setBounds(10,220,100,50);
        add(Address);
        t4 = new JLabel ();
        t4.setBounds(100,230,220,30);
        add(t4);
        
        //GENDER-
        Gender = new JLabel ("GENDER");
        Gender.setBounds(10,270,100,50);
        add(Gender);
        t5 = new JLabel ();
        t5.setBounds(100,280,220,30);
        add(t5);
        //
        //FLIGHT DETAIL
        //SOURCE-
        sor = new JLabel ("SOURCE");
        sor.setBounds(10,320,100,50);
        add(sor);
        c1 = new JComboBox <> ();
        c1.setBounds(100,330,180,30);
        add(c1);
        
        //DESTINATION-
        dest = new JLabel ("DESTINATION");
        dest.setBounds(10,370,100,50);
        add(dest);
        c2 = new JComboBox <> ();
        c2.setBounds(100,380,180,30);
        add(c2);
        
        //DESTINATION AND SOURCE PLACE ADDED -
        try{
           Conn c = new Conn();
           
           String querry = "select * from flight" ;
           
           ResultSet rs = c.s.executeQuery(querry);
           
           while(rs.next()){
               c1.addItem(rs.getString("source"));
               c2.addItem(rs.getString("destination"));
           }
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        //FLIGHT FETCH BUTTON-
        flight = new JButton("FLIGHT DETAIL");
        flight.setBounds(330,380,130,30);
        flight.setFont(new Font("Arial", Font.PLAIN ,10));
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        add(flight);
        flight.addActionListener(this);
        
        //FLIGHT NAME-
        fn = new JLabel ("FLIGHT NAME");
        fn.setBounds(10,420,100,50);
        add(fn);
        t6 = new JLabel ();
        t6.setBounds(100,430,220,30);
        add(t6);
        
        //FLIGHT CODE-
        fc = new JLabel ("FLIGHT CODE");
        fc.setBounds(10,470,100,50);
        add(fc);
        t7 = new JLabel ();
        t7.setBounds(100,480,220,30);
        add(t7); 
        //
        
        // TRAVEL DATE //
        cal = new JLabel ("DATE OF TRAVEL");
        cal.setBounds(10,520,150,50);
        add(cal);
        dc = new JDateChooser ();
        dc.setBounds(130,530,220,30);
        add(dc);
        
        //BOOK FLIGHT BUTTON//
        book = new JButton("BOOK FLIGHT");
        book.setBounds(200,630,130,30);
        book.setFont(new Font("Arial", Font.PLAIN ,10));
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        add(book);
        book.addActionListener(this);
        
        //FRAME PROPERTY//
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200,10,1100,800);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //ACTIONLISTENER//
    public void actionPerformed (ActionEvent e){
        //USER DETAIL ACTIONS //
        if (e.getSource()== user){
            try{
                Conn c = new Conn ();
                
                String querry = "Select*from passenger where aadhar = '"+t1.getText()+"'";
                
                ResultSet rs = c.s.executeQuery(querry);
                if(rs.next()){
                    
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("nationality"));
                    t4.setText(rs.getString("address"));
                    t5.setText(rs.getString("gender"));
                    
                }
                else {
                    JOptionPane.showMessageDialog(null,"No Customer Found");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        //FLIGHT DETAIL ACTIONS //
        else if (e.getSource()== flight){
            try{
                Conn c = new Conn ();
                
                String querry = "Select*from flight where source = '"+c1.getSelectedItem()+"' and destination = '"+c2.getSelectedItem()+"'";
                
                ResultSet rs = c.s.executeQuery(querry);
                if(rs.next()){
                    
                    t6.setText(rs.getString("f_name"));
                    t7.setText(rs.getString("f_code"));
                    
                }
                else {
                    JOptionPane.showMessageDialog(null,"No Flight Found");
                    t6.setText("");
                    t7.setText("");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        //BOOK FLIGHT ACTION//
        else if (e.getSource()== book){
            
            random = new Random();
            String date = ((JTextField)dc.getDateEditor().getUiComponent()).getText();
            
            try{
                Conn c = new Conn ();
                
                String query = "insert into reservation values('"+random.nextInt(1000000)+"','"+random.nextInt(10000)+"','"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+c1.getSelectedItem()+"','"+c2.getSelectedItem()+"','"+date+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Flight Booked Sucessfully");
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    //MAIN FUNCTION//
    public static void main(String args[]){
        new bookFlight();
    }
}

