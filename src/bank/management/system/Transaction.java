package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    String pin;
    JButton b1,b2,b3,b4, b5, b6, b7;

    Transaction(String pin) {
        super("Transaction");

        this.pin = pin;

        JLabel labelTop = new JLabel("SELECT TRANSACTION TYPE");
        labelTop.setFont(new Font("Calibri", Font.BOLD, 20));
        labelTop.setForeground(Color.BLUE);
        labelTop.setBounds(600, 20, 300, 30);
        add(labelTop);

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("Calibri", Font.BOLD, 14));
        b1.setBounds(600, 70, 150, 40);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("WITHDRAW");
        b2.setFont(new Font("Calibri", Font.BOLD, 14));
        b2.setBounds(750, 70, 150, 40);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("FAST CASH");
        b3.setFont(new Font("Calibri", Font.BOLD, 14));
        b3.setBounds(600, 120, 150, 40);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("MINI-STATEMENT");
        b4.setFont(new Font("Calibri", Font.BOLD, 14));
        b4.setBounds(750, 120, 150, 40);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("CHANGE PIN");
        b5.setFont(new Font("Calibri", Font.BOLD, 14));
        b5.setBounds(600, 170, 150, 40);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("BALANCE");
        b6.setFont(new Font("Calibri", Font.BOLD, 14));
        b6.setBounds(750, 170, 150, 40);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("EXIT");
        b7.setFont(new Font("Calibri", Font.BOLD, 14));
        b7.setBounds(750, 220, 150, 40);
        b7.addActionListener(this);
        add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource() == b2) {
            new Withdrawal(pin);
            setVisible(false);
        } else if (e.getSource() == b3) {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource() == b4) {
            setVisible(false);
            new Mini(pin);
        } else if (e.getSource() == b5) {
            setVisible(false);
            new ChangePIN(pin);
        } else if (e.getSource() == b6) {
            setVisible(false);
            new Balance(pin);
        } else if (e.getSource() == b7) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
