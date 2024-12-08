package bank.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {

    String pin;
    JButton button;

    Mini(String pin) {
        super("Mini Statement");

        this.pin = pin;

        JLabel label1 = new JLabel();
        label1.setBounds(20, 120, 400, 300);
        add(label1);

        JLabel label2 = new JLabel("Akshat Jha");
        label2.setBounds(150, 20, 200, 20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20, 80, 300, 20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20, 450, 300, 20);
        add(label4);

        try {
            Conn conn = new Conn();
            String q1 = "SELECT * FROM login WHERE pin = '"+pin+"'";
            PreparedStatement pst1 = conn.con.prepareStatement(q1);
            ResultSet rs = pst1.executeQuery();
            while (rs.next()) {
                label3.setText(rs.getString("card_no").substring(0, 4) + "XXXXXXXX" + rs.getString("card_no").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            Conn conn = new Conn();
            String q2 = "SELECT * FROM bank WHERE pin = '"+pin+"'";
            PreparedStatement pst1 = conn.con.prepareStatement(q2);
            ResultSet rs = pst1.executeQuery();
            StringBuilder transactions = new StringBuilder("<html>");
            while (rs.next()) {
                transactions.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount"))
                        .append("<br/><br/>");

                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdraw")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            transactions.append("</html>");
            label1.setText(transactions.toString());

            label4.setText("Current Balance Rs. "+balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20, 500, 100, 30);
        button.addActionListener(this);
        add(button);

        setLayout(null);
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
