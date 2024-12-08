package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePIN extends JFrame implements ActionListener {

    String pin;
    JButton button1, button2;
    JPasswordField p1, p2;

    ChangePIN(String pin) {
        super("Change PIN");

        this.pin = pin;

        JLabel labelTop = new JLabel("CHANGE PIN");
        labelTop.setFont(new Font("Calibri", Font.BOLD, 20));
        labelTop.setBounds(600, 20, 300, 30);
        add(labelTop);

        JLabel label1 = new JLabel("New PIN");
        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        label1.setBounds(400, 100, 300, 30);
        add(label1);

        p1 = new JPasswordField();
        p1.setBounds(400, 130, 300, 40);
        add(p1);

        JLabel label2 = new JLabel("Confirm new PIN");
        label2.setFont(new Font("Calibri", Font.BOLD, 20));
        label2.setBounds(400, 180, 300, 30);
        add(label2);

        p2 = new JPasswordField();
        p2.setBounds(400, 210, 300, 40);
        add(p2);

        button1 = new JButton("Change PIN");
        button1.setFont(new Font("Calibri", Font.BOLD, 18));
        button1.setBounds(580, 290, 100, 40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Back");
        button2.setFont(new Font("Calibri", Font.BOLD, 18));
        button2.setBounds(780, 290, 100, 40);
        button2.addActionListener(this);
        add(button2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = p1.getText();
            String pin2 = p2.getText();
            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "PIN does not match");
                return;
            }
            if (e.getSource() == button1) {
                if (p1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter new PIN");
                    return;
                }
                if (p2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-enter PIN");
                    return;
                }
                Conn conn = new Conn();
                String q1 = "UPDATE bank SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";
                String q2 = "UPDATE login SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";
                String q3 = "UPDATE signup3 SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";
                conn.stmt.executeUpdate(q1);
                conn.stmt.executeUpdate(q2);
                conn.stmt.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed");
                setVisible(false);
                new Transaction(pin);
            } else if (e.getSource() == button2) {
                new Transaction(pin);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChangePIN("");
    }
}
