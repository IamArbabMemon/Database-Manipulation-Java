import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SignUp {
    public static JButton s_b;
    public static JFrame frame;
    public static JLabel l, l_1, l_2, l_3, l_4, l_5;
    public static JTextField f1, f2, f3, f4,f5;


    public static void startApp(){

        s_b = new JButton("REGISTER");
        s_b.setFont(new Font("MV Boli",Font.BOLD,20));
        s_b.setBounds(250, 440, 160, 50);
        s_b.setFocusable(false);


        f1 = new JTextField();
        f1.setBounds(180, 90, 200, 25);

        f2 = new JTextField();
        f2.setBounds(180, 150, 200, 25);

        f3 = new JTextField();
        f3.setBounds(180, 210, 200, 25);

        f4 = new JTextField(20);
        f4.setBounds(180, 270, 200, 25);

        f5 = new JTextField(20);
        f5.setBounds(180, 340, 200, 25);

        l_2 = new JLabel("Username: ");
        l_2.setBounds(20, 130, 112, 60);
        l_2.setFont(new Font("MV Boli", Font.BOLD, 20));

        l_3 = new JLabel("Password: ");
        l_3.setBounds(20, 190, 110, 60);
        l_3.setFont(new Font("MV Boli", Font.BOLD, 20));

        l_4 = new JLabel("Department: ");
        l_4.setBounds(20, 250, 160, 60);
        l_4.setFont(new Font("MV Boli", Font.BOLD, 20));

        l_5 = new JLabel("Designation : ");
        l_5.setBounds(20, 320, 160, 60);
        l_5.setFont(new Font("MV Boli", Font.BOLD, 20));


        l = new JLabel(" SIGN UP FORM FOR ADMIN ");
        l.setBounds(120, 20, 700, 200);
        l.setFont(new Font("MV Boli", Font.BOLD, 30));
        l.setVerticalAlignment(JLabel.TOP);

//        reflectSelectedTableRow();


        frame = new JFrame("Employee Management System");
        frame.setSize(750, 900);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


        frame.add(f2);
        frame.add(f3);
        frame.add(f4);
        frame.add(f5);

        frame.add(s_b);

        frame.add(l);
        frame.add(l_2);
        frame.add(l_3);
        frame.add(l_4);
        frame.add(l_5);

        frame.getContentPane().setBackground(new Color(220, 220, 220));
        frame.setLocation(300, 60);
        frame.setVisible(true);

        s_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = f2.getText();
                String password = f3.getText();
                String department = f4.getText();
                String designation = f5.getText();
                Admin admin = new Admin(username,password,department,designation);
                new AdminDAO().registerAdmin(admin);
            }
        });

    }


}