import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homePage extends JFrame {

    JButton admission = new JButton("LOGIN IN");
    JButton reset = new JButton("CREATE ACCOUNT");
    JLabel title = new JLabel("Human Resource Management System");
    JLabel l1, l2;
    JTextField t1, t2;

    public homePage() {
        title.setBounds(220, 80, 600, 300);
        title.setFont(new Font("New Times Roman", Font.BOLD, 30));

        t1 = new JTextField();
        t1.setBounds(200, 520, 200, 30);

        t2 = new JTextField();
        t2.setBounds(200, 590, 200, 30);


        l1 = new JLabel("USERNAME ");
        l1.setBounds(200, 450, 100, 100);
        l1.setFont(new Font("", Font.BOLD, 15));

        l2 = new JLabel("PASSWORD");
        l2.setBounds(200, 530, 100, 100);
        l2.setFont(new Font("", Font.BOLD, 15));


        admission.setBounds(200, 400, 200, 50);
        reset.setBounds(200,680,200,50);
        admission.setFont(new Font("New Times Roman", Font.BOLD, 15));
        admission.setFocusable(false);

        this.setLayout(null);
        this.setSize(1000, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(450, 60);
        this.getContentPane().setBackground(new Color(220, 220, 220));
        this.setTitle("HR APP");
        this.add(title);
        this.add(t2);
        this.add(l2);
        this.add(t1);
        this.add(l1);
        this.add(reset);
        this.add(admission);
        this.setVisible(true);

        admission.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isFound = new AdminDAO().searchForAdmin(t1.getText(), t2.getText());
            if(isFound){
                GUI.startApp();
            }else{
                JOptionPane.showMessageDialog(null,"USER NOT FOUND ","INFORMATION",JOptionPane.ERROR_MESSAGE);
            }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp.startApp();
            }
        });

    }


    }

