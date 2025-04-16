import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 
public class Home extends JFrame implements ActionListener {
    ImageIcon icon ;
    JLabel image , text ;
    JMenuBar menu;
    JMenu details , ticket ;
    JMenuItem flight , customer , book , journey ,cancel , boarding ;
    public Home(){
        setLayout(null);
        
        icon  = new ImageIcon("src/pics/front.jpg");

        image = new JLabel(icon);
        image.setBounds(0,0,1600,800);
        image.setLayout(null); 


        text = new JLabel("AIR INDIA WELCOMES YOU");
        text.setBounds(100, 100, 600, 60);  
        text.setFont(new Font("Arial", Font.BOLD, 40));  
        text.setForeground(Color.WHITE);  
        image.add(text);
        
        menu = new JMenuBar();
        setJMenuBar(menu);
        
        details = new JMenu("Detail");
        menu.add(details);
        
        flight = new JMenuItem ("Flight Details");
        customer = new JMenuItem ("Add Customer Details");
        book = new JMenuItem ("Book Flight");
        journey = new JMenuItem ("Journey Details");
        cancel = new JMenuItem ("Cancel Ticket");
        details.add(flight);
        details.add(customer);
        details.add(book);
        details.add(journey);
        details.add(cancel);
        
        ticket = new JMenu ("Ticket");
        menu.add(ticket);
        
        boarding = new JMenuItem ("Boarding Pass");
        ticket.add(boarding);
        
        customer.addActionListener(this);
        flight.addActionListener(this);
        book.addActionListener(this);
        journey.addActionListener(this);
        cancel.addActionListener(this);
        boarding.addActionListener(this);
        
        add(image);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible (true);
        
    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == customer){
            new addCustomer();
        }
        else if (e.getSource() == flight){
            new flightDetails();
        }
        else if (e.getSource() == book){
            new bookFlight();
        }
        else if (e.getSource() == journey){
            new journeyDetails();
        }
        else if (e.getSource() == cancel){
            new cancelFlight();
        }
        else if (e.getSource() == boarding){
            new boardingTicket();
        }
        
    }
    public static void main (String args[]){
        new Home(); 
    }
}
