package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField text1;
    JPasswordField password;
    JButton button1, button2, button3;

    Login() {
        super("Net Banking");

        label1 = new JLabel("Welcome to Net Banking");
        label1.setBounds(300,80,450,40);
        label1.setForeground(Color.BLUE);
        label1.setFont(new Font("Calibri", Font.BOLD, 24));
        add(label1);

        label2 = new JLabel("Card Number");
        label2.setBounds(180,150,350,30);
        label2.setFont(new Font("Calibri", Font.BOLD, 16));
        label2.setForeground(Color.BLACK);
        add(label2);

        text1 = new JTextField(15);
        text1.setBounds(350,150,250,30);
        label2.setFont(new Font("Calibri", Font.BOLD, 16));
        add(text1);

        label3 = new JLabel("PIN");
        label3.setBounds(180,200,350,30);
        label3.setFont(new Font("Calibri", Font.BOLD, 16));
        label3.setForeground(Color.BLACK);
        add(label3);

        password = new JPasswordField(15);
        password.setBounds(350,200,250,30);
        password.setFont(new Font("Calibri", Font.BOLD, 16));
        add(password);

        button1 = new JButton("LOGIN");
        button1.setFont(new Font("Calibri", Font.BOLD, 14));
        button1.setForeground(Color.BLUE);
        button1.setBounds(280, 250,100, 40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("RESET");
        button2.setFont(new Font("Calibri", Font.BOLD, 14));
        button2.setForeground(Color.BLUE);
        button2.setBounds(450, 250,100, 40);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Calibri", Font.BOLD, 14));
        button3.setForeground(Color.BLUE);
        button3.setBounds(280, 300,270, 40);
        button3.addActionListener(this);
        add(button3);

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                Conn conn = new Conn();
                String card_no = text1.getText();
                String pin = password.getText();
                String q1 = "SELECT * FROM login WHERE card_no = '"+card_no+"' AND pin = '"+pin+"'";
                PreparedStatement pst = conn.con.prepareStatement(q1);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number/PIN");
                }
            } else if (e.getSource() == button2) {
                text1.setText("");
                password.setText("");
            } else if (e.getSource() == button3) {
                new Signup();
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
