import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.sql.*;
           
public class journeyDetails extends JFrame implements ActionListener{
    JTable table ;
    JScrollPane jsp ;
    JTextField t1;
    JLabel pnr ;
    JButton find;
    public journeyDetails(){
        
        //TABLE//
        table = new JTable();
        jsp = new JScrollPane(table);
        jsp.setBounds(0,80,990,500);
        add(jsp);
        
        //PNR//
        pnr = new JLabel ("PNR");
        pnr.setBounds(80,10,100,50);
        add(pnr);
        t1 = new JTextField ();
        t1.setBounds(200,15,100,30);
        add(t1);
        
        //FIND DETAIL BUTTON//
        find = new JButton("FIND DETAIL");
        find.setBounds(330,15,100,30);
        find.setFont(new Font("Arial", Font.PLAIN ,10));
        find.setBackground(Color.BLACK);
        find.setForeground(Color.WHITE);
        add(find);
        find.addActionListener(this);
        
        //FRAME PROPERTIES//
        setBounds(300,200,1000,500);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== find){
        try{
            Conn c = new Conn();
            
            String querry = "select*from reservation where PNR ='"+t1.getText()+"'";
            
            ResultSet rs = c.s.executeQuery(querry); 
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "PNR NO IS INVALID");
                return;
            }
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        }
    }
    
    public static void main(String [] args){
       new journeyDetails(); 
    }
}  






