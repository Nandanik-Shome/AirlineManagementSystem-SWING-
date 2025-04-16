import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class cancelFlight extends JFrame implements ActionListener{
    
    JLabel text , image , pnr , Name , t2 , fc ,t7 , t3 ,date , cn ,t4;
    JTextField t1 ;
    ImageIcon i1 , icon;
    Image i2;
    JButton find , cancel;
    Random random;
    public cancelFlight(){
        
        //HEADING//
        text = new JLabel ("CANCEL FLIGHT");
        text.setBounds(350,10,150,50);
        text.setFont(new Font ("Arial",Font.BOLD,15));
        text.setForeground(Color.BLUE);
        add(text);    
        
        //IMAGE//
        i1 = new ImageIcon (ClassLoader.getSystemResource("pics/cancel.jpg"));
        i2 = i1.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        icon = new ImageIcon(i2);
        image = new JLabel(icon);
        image.setBounds(400,40,390,400);
        add(image);
        
        //PNR//
        pnr = new JLabel ("PNR");
        pnr.setBounds(30,60,100,50);
        add(pnr);
        t1 = new JTextField ();
        t1.setBounds(140,70,150,30);
        add(t1);
        
        //FIND BUTTON//
        find = new JButton("FIND DETAIL");
        find.setBounds(300,70,130,30);
        find.setFont(new Font("Arial", Font.PLAIN ,10));
        find.setBackground(Color.BLACK);
        find.setForeground(Color.WHITE);
        add(find);
        find.addActionListener(this);
        
        //NAME//
        Name = new JLabel ("NAME");
        Name.setBounds(30,110,100,50);
        add(Name);
        t2 = new JLabel ();
        t2.setBounds(140,120,150,30);
        add(t2);
        
        //FLIGHT CODE//
        fc = new JLabel ("FLIGHT CODE");
        fc.setBounds(30,160,100,50);
        add(fc);
        t7 = new JLabel ();
        t7.setBounds(140,170,150,30);
        add(t7); 
        
        //DATE//
        date = new JLabel ("DATE");
        date.setBounds(30,210,100,50);
        add(date);
        t3 = new JLabel ();
        t3.setBounds(140,220,150,30);
        add(t3);
        
        //CANCELLATION NO.//
        cn = new JLabel ("CANCELLATION NO.");
        cn.setBounds(30,260,150,50);
        add(cn);
        t4 = new JLabel ();
        t4.setBounds(200,270,150,30);
        add(t4);
        
        //CANCEL BUTTON //
        cancel = new JButton("CANCEL");
        cancel.setBounds(200,380,130,30);
        cancel.setFont(new Font("Arial", Font.PLAIN ,10));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);
        
        //FRAME PROPERTY//
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,150,800,500);
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
                
                random = new Random();
                
                if(rs.next()){
                    
                    t2.setText(rs.getString("name"));
                    t7.setText(rs.getString("flightcode"));
                    t3.setText(rs.getString("ddate"));
                    t4.setText(""+random.nextInt(1000000));
                    
                }
                else {
                    JOptionPane.showMessageDialog(null,"No Customer Found");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t7.setText("");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        //FLIGHT DETAIL ACTIONS //
        else if (e.getSource()== cancel){
            try{
                Conn c = new Conn ();
                
                String querry = "insert into cancel values('"+t1.getText()+"','"+t2.getText()+"','"+t4.getText()+"','"+t7.getText()+"','"+t3.getText()+"')";
                
                c.s.executeUpdate(querry);
                
                c.s.executeUpdate("delete from reservation where PNR = '"+t1.getText()+"'");

                JOptionPane.showMessageDialog(null,"Canceled Sucessfully");
                
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t7.setText("");
                
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }
    public static void main(String args[]){
        new cancelFlight();
    }
}



