import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class boardingTicket extends JFrame implements ActionListener{
    
    JLabel text1, text2 , image , pnr , Name , t2 , fc ,t7 , t3 ,date , fn ,t4 , t6 , Nationality , t5 ,src ,dst, t8,t9;
    JTextField t1 ;
    ImageIcon i1 , icon;
    Image i2;
    JButton find ;
    
    public boardingTicket(){
        
        //HEADING//
        text1 = new JLabel ("AIR INDIA");
        text1.setBounds(450,10,150,50);
        text1.setFont(new Font ("Arial",Font.BOLD,20));
        text1.setForeground(Color.BLACK);
        add(text1);    
        
        text2 = new JLabel ("BOARDING TICKET");
        text2.setBounds(428,40,150,50);
        text2.setFont(new Font ("Arial",Font.BOLD,15));
        text2.setForeground(Color.BLUE);
        add(text2);   
        
        //IMAGE//
        i1 = new ImageIcon (ClassLoader.getSystemResource("pics/airindia.png"));
        i2 = i1.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        icon = new ImageIcon(i2);
        image = new JLabel(icon);
        image.setBounds(600,40,390,350);
        add(image);
        
        //PNR//
        pnr = new JLabel ("PNR");
        pnr.setBounds(30,110,100,50);
        add(pnr);
        t1 = new JTextField ();
        t1.setBounds(140,120,150,30);
        add(t1);
        
        //FIND BUTTON//
        find = new JButton("FIND DETAIL");
        find.setBounds(300,120,130,30);
        find.setFont(new Font("Arial", Font.PLAIN ,10));
        find.setBackground(Color.BLACK);
        find.setForeground(Color.WHITE);
        add(find);
        find.addActionListener(this);
        
        //NAME//
        Name = new JLabel ("NAME");
        Name.setBounds(30,160,100,50);
        add(Name);
        t2 = new JLabel ();
        t2.setBounds(140,170,150,30);
        add(t2);
        
        //FLIGHT CODE//
        fc = new JLabel ("FLIGHT CODE");
        fc.setBounds(30,210,100,50);
        add(fc);
        t7 = new JLabel ();
        t7.setBounds(140,220,150,30);
        add(t7); 
        
        //DATE//
        date = new JLabel ("DATE");
        date.setBounds(30,260,100,50);
        add(date);
        t3 = new JLabel ();
        t3.setBounds(140,270,150,30);
        add(t3);
        
        //FLIGHT NAME//
        fn = new JLabel ("FLIGHT NAME");
        fn.setBounds(30,310,100,50);
        add(fn);
        t6 = new JLabel ();
        t6.setBounds(140,320,150,30);
        add(t6);
        
        //NATIONALITY-
        Nationality = new JLabel ("NATIONALITY");
        Nationality.setBounds(30,360,100,50);
        add(Nationality);
        t5 = new JLabel ();
        t5.setBounds(140,370,150,30);
        add(t5);
        
        //SOURCE//
        src = new JLabel ("SOURCE");
        src.setBounds(300,260,100,50);
        add(src);
        t8 = new JLabel ();
        t8.setBounds(440,270,150,30);
        add(t8);
        
        //DESTINATION//
        dst = new JLabel ("DESTINATION");
        dst.setBounds(300,310,100,50);
        add(dst);
        t9 = new JLabel ();
        t9.setBounds(440,320,150,30);
        add(t9);
        
        //FRAME PROPERTY//
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,150,1000,460);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void actionPerformed (ActionEvent e){
        //FIND DETAIL ACTIONS //
        if (e.getSource()== find){
            try{
                Conn c = new Conn ();
                
                String querry = "Select*from reservation where PNR = '"+t1.getText()+"'";
                
                ResultSet rs = c.s.executeQuery(querry);
                
                if(rs.next()){
                    
                    t2.setText(rs.getString("name"));
                    t7.setText(rs.getString("flightcode"));
                    t3.setText(rs.getString("ddate"));
                    t6.setText(rs.getString("flightname"));
                    t5.setText(rs.getString("nationality"));
                    t8.setText(rs.getString("src"));
                    t9.setText(rs.getString("des"));
                    
                }
                else {
                    JOptionPane.showMessageDialog(null,"No Customer Found");
                    t2.setText("");
                    t3.setText("");
                    t1.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
 public static void main(String args[]){
     new boardingTicket();
 }
}

