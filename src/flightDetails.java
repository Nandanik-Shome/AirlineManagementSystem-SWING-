import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
        
public class flightDetails extends JFrame {
    JTable table ;
    JScrollPane jsp ;
    public flightDetails(){
        
        setBounds(500,200,600,500);
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            
            String querry = "select*from flight ";
            
            ResultSet rs = c.s.executeQuery(querry);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        jsp = new JScrollPane(table);
        jsp.setBounds(0,0,600,500);
        add(jsp);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String [] args){
       new flightDetails(); 
    }
}