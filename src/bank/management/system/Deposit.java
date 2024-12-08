package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton button1, button2;

    Deposit(String pin) {
        super("Deposit");

        this.pin = pin;

        JLabel labelTop = new JLabel("ENTER DEPOSIT AMOUNT");
        labelTop.setFont(new Font("Calibri", Font.BOLD, 20));
        labelTop.setBounds(600, 20, 300, 30);
        add(labelTop);

        textField = new TextField();
        textField.setBounds(580, 70, 300, 40);
        add(textField);

        button1 = new JButton("DEPOSIT");
        button1.setFont(new Font("Calibri", Font.BOLD, 18));
        button1.setBounds(580, 120, 100, 40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Calibri", Font.BOLD, 18));
        button2.setBounds(780, 120, 100, 40);
        button2.addActionListener(this);
        add(button2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource() == button1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you would like to deposit");
                } else {
                    Conn conn = new Conn();
                    String qry1 = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt1 = conn.con.prepareStatement(qry1);
                    pstmt1.setString(1, pin);
                    pstmt1.setString(2, date.toString());
                    pstmt1.setString(3, "Deposit");
                    pstmt1.setString(4, amount);
                    pstmt1.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited successfully");
                    setVisible(false);
                    new Transaction(pin);
                }
            } else if (e.getSource() == button2) {
                setVisible(false);
                new Transaction(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
