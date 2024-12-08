package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {

    String pin;
    JLabel lblBalance;
    JButton btnBack;

    Balance(String pin) {
        super("Balance");

        JLabel labelTop = new JLabel("CURRENT BALANCE Rs:");
        labelTop.setFont(new Font("Calibri", Font.BOLD, 20));
        labelTop.setBounds(530, 20, 300, 30);
        add(labelTop);

        lblBalance = new JLabel();
        lblBalance.setFont(new Font("Calibri", Font.BOLD, 20));
        lblBalance.setBounds(780, 20, 500, 30);
        add(lblBalance);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Calibri", Font.BOLD, 18));
        btnBack.setBounds(660, 170, 130, 40);
        btnBack.addActionListener(this);
        add(btnBack);

        int balance =  0;
        try {
            Conn conn = new Conn();
            String q1 = "SELECT * FROM bank WHERE pin = '"+pin+"'";
            PreparedStatement pst1 = conn.con.prepareStatement(q1);
            ResultSet rs = pst1.executeQuery();
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdraw")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblBalance.setText(""+balance);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            setVisible(false);
            new Transaction(pin);
        }

    }

    public static void main(String[] args) {
        new Balance("");
    }
}
