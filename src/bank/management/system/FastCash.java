package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String pin;
    JButton b1,b2,b3,b4, b5, b6, b7;

    FastCash(String pin) {
        super("Fast Cash");

        this.pin = pin;

        JLabel labelTop = new JLabel("SELECT AMOUNT");
        labelTop.setFont(new Font("Calibri", Font.BOLD, 20));
        labelTop.setForeground(Color.BLUE);
        labelTop.setBounds(600, 20, 300, 30);
        add(labelTop);

        b1 = new JButton("Rs. 100");
        b1.setFont(new Font("Calibri", Font.BOLD, 14));
        b1.setBounds(600, 70, 150, 40);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Rs. 500");
        b2.setFont(new Font("Calibri", Font.BOLD, 14));
        b2.setBounds(750, 70, 150, 40);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setFont(new Font("Calibri", Font.BOLD, 14));
        b3.setBounds(600, 120, 150, 40);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setFont(new Font("Calibri", Font.BOLD, 14));
        b4.setBounds(750, 120, 150, 40);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setFont(new Font("Calibri", Font.BOLD, 14));
        b5.setBounds(600, 170, 150, 40);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setFont(new Font("Calibri", Font.BOLD, 14));
        b6.setBounds(750, 170, 150, 40);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("BACK");
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
        if (e.getSource() == b7) {
            setVisible(false);
            new Transaction(pin);
        } else {
            String amount = ((JButton) e.getSource()).getText().substring(4);
            Conn conn = new Conn();
            Date date = new Date();
            try {
                String q1 = "SELECT * FROM bank WHERE pin = '" + pin + "'";
                PreparedStatement pst1 = conn.con.prepareStatement(q1);
                ResultSet rs = pst1.executeQuery();
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else if (rs.getString("type").equals("Withdraw")) {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                String num = "17";

                if (e.getSource() != b7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Not enough balance");
                    return;
                }
                String q2 = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt2 = conn.con.prepareStatement(q2);
                pstmt2.setString(1, pin);
                pstmt2.setString(2, date.toString());
                pstmt2.setString(3, "Withdraw");
                pstmt2.setString(4, amount);
                pstmt2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " debited successful");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            setVisible(false);
            new Transaction(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
