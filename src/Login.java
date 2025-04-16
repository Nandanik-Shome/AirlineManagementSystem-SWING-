import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    

    JLabel username, password;
    JPanel info, button;
    JPasswordField pass;
    JTextField t1;
    JButton retur, submit, close;

    public Login() {
        setBounds(500, 200, 500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // top panel (input fields)
        info = new JPanel();
        info.setPreferredSize(new Dimension(250, 140));
        info.setOpaque(true);
        info.setLayout(null);

        // bottom panel (buttons)
        button = new JPanel();
        button.setPreferredSize(new Dimension(250, 160));
        button.setLayout(null);

        // username label and field
        username = new JLabel("USERNAME :");
        username.setBounds(10, 5, 100, 80);
        info.add(username);

        t1 = new JTextField();
        t1.setBounds(130, 30, 250, 30);
        info.add(t1);

        // password label and field
        password = new JLabel("PASSWORD :");
        password.setBounds(10, 55, 100, 80);
        info.add(password);

        pass = new JPasswordField();
        pass.setBounds(130, 80, 250, 30);
        info.add(pass);

        // buttons setup
        retur = new JButton("Return");
        retur.setBounds(60, 50, 150, 30);
        retur.addActionListener(this);
        button.add(retur);

        submit = new JButton("Submit");
        submit.setBounds(260, 50, 150, 30);
        submit.addActionListener(this);
        button.add(submit);

        close = new JButton("Close");
        close.setBounds(160, 100, 150, 30);
        close.addActionListener(this);
        button.add(close);

        add(info, BorderLayout.NORTH);
        add(button, BorderLayout.SOUTH);

        setVisible(true);
    }

    // button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retur) {
            // clear fields
            t1.setText("");
            pass.setText("");
        } else if (e.getSource() == close) {

            System.exit(0);

        } else if (e.getSource() == submit) {
            
            String tusername = t1.getText();
            String tpassword = new String(pass.getPassword());

            try {
                Conn c = new Conn();

                String query = "select * from login where username = '" + tusername + "' and password = '" + tpassword + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {

                    new Home();
                    setVisible(false);

                } else {
                    
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    System.exit(0);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // main method
    public static void main(String[] args) {
        new Login();
    }
}
