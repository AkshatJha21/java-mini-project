package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton button1, button2;

    Withdrawal(String pin) {
        super("Withdrawal");

        this.pin = pin;

        JLabel labelTop = new JLabel("MAXIMUM WITHDRAWAL OF Rs. 10,000");
        labelTop.setFont(new Font("Calibri", Font.BOLD, 20));
        labelTop.setBounds(530, 20, 500, 30);
        add(labelTop);

        JLabel labelTop2 = new JLabel("PLEASE ENTER AMOUNT");
        labelTop2.setFont(new Font("Calibri", Font.BOLD, 20));
        labelTop2.setBounds(600, 70, 300, 30);
        labelTop2.setForeground(Color.BLUE);
        add(labelTop2);

        textField = new TextField();
        textField.setBounds(580, 120, 300, 40);
        add(textField);

        button1 = new JButton("WITHDRAW");
        button1.setFont(new Font("Calibri", Font.BOLD, 18));
        button1.setBounds(580, 170, 130, 40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Calibri", Font.BOLD, 18));
        button2.setBounds(780, 170, 100, 40);
        button2.addActionListener(this);
        add(button2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER AMOUNT");
                } else {
                    Conn c = new Conn();
                    String q1 = "SELECT * FROM bank WHERE pin = '" + pin + "'";
                    PreparedStatement pst1 = c.con.prepareStatement(q1);
                    ResultSet rs = pst1.executeQuery();
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    String q2 = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
                    PreparedStatement pst2 = c.con.prepareStatement(q2);
                    pst2.setString(1, pin);
                    pst2.setString(2, date.toString());
                    pst2.setString(3, "Withdrawal");
                    pst2.setString(4, amount);
                    pst2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " WITHDRAWAL SUCCESSFULLY");
                    setVisible(false);
                    new Transaction(pin);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == button2) {
            setVisible(false);
            new Transaction(pin);
        }

    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
