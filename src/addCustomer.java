import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class addCustomer extends JFrame implements ActionListener {
    JLabel text , Name , Nationality , Adhaar , Address , Phone , Gender ,image;
    JTextField t1 ,t2, t3, t4 ,t5 ;
    JRadioButton Male , Female ;
    ButtonGroup gen ;
    JButton b1 ;
    ImageIcon icon ;
    public addCustomer(){
        setLayout(null);
        setBounds(500 , 100 ,650 ,550);
        
        text = new JLabel ("Add Customer Details");
        text.setBounds(205,10,250,50);
        text.setFont(new Font ("Arial",Font.BOLD,20));
        text.setForeground(Color.BLUE);
        add(text);
        
        Name = new JLabel ("NAME");
        Name.setBounds(10,60,100,50);
        add(Name);
        t1 = new JTextField();
        t1.setBounds(100,70,220,30);
        add(t1);
        
        Nationality = new JLabel ("NATIONALITY");
        Nationality.setBounds(10,110,100,50);
        add(Nationality);
        t2 = new JTextField();
        t2.setBounds(100,120,220,30);
        add(t2);
        
        Adhaar = new JLabel ("ADHAAR NO.");
        Adhaar.setBounds(10,160,100,50);
        add(Adhaar);
        t3 = new JTextField();
        t3.setBounds(100,170,220,30);
        add(t3);
        
        Address = new JLabel ("ADDRESS");
        Address.setBounds(10,210,100,50);
        add(Address);
        t4 = new JTextField();
        t4.setBounds(100,220,220,30);
        add(t4);
        
        Phone = new JLabel ("PHONE NO.");
        Phone.setBounds(10,260,100,50);
        add(Phone);
        t5 = new JTextField();
        t5.setBounds(100,270,220,30);
        add(t5);
        
        Gender = new JLabel ("GENDER");
        Gender.setBounds(10,310,100,50);
        add(Gender);
        Male = new JRadioButton ("MALE");
        Male.setBounds(100,320,110,30);
        Female = new JRadioButton ("FEMALE");
        Female.setBounds(210,320,110,30);
        add(Male);
        add(Female);
        gen = new ButtonGroup();
        gen.add(Male);
        gen.add(Female);
        
        b1 = new JButton("Submit");
        b1.setBounds(140,400,110,30);
        add(b1);
        b1.addActionListener(this);
        
        icon = new ImageIcon (ClassLoader.getSystemResource("pics/emp.png"));
        image = new JLabel(icon);
        image.setBounds(330,60,400,400);
        add(image);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== b1){
            String name = t1.getText();
            String nationality = t2.getText();
            String adhaar = t3.getText();
            String phone = t5.getText();
            String address = t4.getText();
            String gender ;
            if(Male.isSelected()){
                gender = "Male";
            }
            else{
                gender = "Female";
            }
            try {
                Conn c = new Conn();
                
                String query = "insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+adhaar+"','"+gender+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Detail Added Sucessfully");
                
                setVisible(false);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
    }
    }
    public static void main(String args[]){
        new addCustomer();
    }
}
