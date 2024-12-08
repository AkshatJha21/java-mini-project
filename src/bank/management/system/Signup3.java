package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton submit, cancel;
    String form_no;
    Signup3(String form_no) {
        super("New Account");

        this.form_no = form_no;

        JLabel label1 = new JLabel("Page 3");
        label1.setBounds(360, 20, 600, 30);
        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        add(label1);

        JLabel label2 = new JLabel("Account Details");
        label2.setFont(new Font("Calibri", Font.BOLD, 18));
        label2.setBounds(310, 50, 600, 30);
        add(label2);

        JLabel labelType = new JLabel("Account Type");
        labelType.setFont(new Font("Calibri", Font.BOLD, 18));
        labelType.setBounds(100, 100, 150, 30);
        add(labelType);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Calibri", Font.BOLD, 14));
        r1.setBounds(250, 100, 150, 30);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Calibri", Font.BOLD, 14));
        r2.setBounds(400, 100, 150, 30);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit");
        r3.setFont(new Font("Calibri", Font.BOLD, 14));
        r3.setBounds(250, 130, 150, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit");
        r4.setFont(new Font("Calibri", Font.BOLD, 14));
        r4.setBounds(400, 130, 180, 30);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel labelCard = new JLabel("Card No");
        labelCard.setFont(new Font("Calibri", Font.BOLD, 18));
        labelCard.setBounds(100, 180, 150, 30);
        add(labelCard);

        JLabel labelCardNo = new JLabel("(Your 16-digit Card No)");
        labelCardNo.setFont(new Font("Calibri", Font.BOLD, 12));
        labelCardNo.setBounds(100, 210, 300, 30);
        add(labelCardNo);

        JLabel labelNum = new JLabel("XXXX-XXXX-XXXX-1092");
        labelNum.setFont(new Font("Calibri", Font.BOLD, 18));
        labelNum.setBounds(300, 180, 300, 30);
        add(labelNum);

        JLabel labelVis = new JLabel("(Visible on Card/Cheque/Bank Statements)");
        labelVis.setFont(new Font("Calibri", Font.BOLD, 12));
        labelVis.setBounds(300, 210, 400, 30);
        add(labelVis);

        JLabel labelPIN = new JLabel("PIN");
        labelPIN.setFont(new Font("Calibri", Font.BOLD, 18));
        labelPIN.setBounds(100, 260, 150, 30);
        add(labelPIN);

        JLabel labelPINInfo = new JLabel("(Your 4-digit password)");
        labelPINInfo.setFont(new Font("Calibri", Font.BOLD, 12));
        labelPINInfo.setBounds(100, 290, 300, 30);
        add(labelPINInfo);

        JLabel labelPINNum = new JLabel("XXXX");
        labelPINNum.setFont(new Font("Calibri", Font.BOLD, 18));
        labelPINNum.setBounds(300, 260, 300, 30);
        add(labelPINNum);

        JLabel labelServices = new JLabel("Services Required");
        labelServices.setFont(new Font("Calibri", Font.BOLD, 18));
        labelServices.setBounds(100, 340, 200, 30);
        add(labelServices);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Calibri", Font.BOLD, 14));
        c1.setBounds(300, 340, 150, 30);
        add(c1);

        c2 = new JCheckBox("Net Banking");
        c2.setFont(new Font("Calibri", Font.BOLD, 14));
        c2.setBounds(450, 340, 150, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Calibri", Font.BOLD, 14));
        c3.setBounds(300, 370, 150, 30);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setFont(new Font("Calibri", Font.BOLD, 14));
        c4.setBounds(450, 370, 150, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Calibri", Font.BOLD, 14));
        c5.setBounds(300, 400, 150, 30);
        add(c5);

        c6 = new JCheckBox("E-statements");
        c6.setFont(new Font("Calibri", Font.BOLD, 14));
        c6.setBounds(450, 400, 150, 30);
        add(c6);

        JCheckBox c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Calibri", Font.BOLD, 12));
        c7.setBounds(100, 450, 650, 30);
        add(c7);

        JLabel labelFormNo = new JLabel("Form No");
        labelFormNo.setFont(new Font("Calibri", Font.BOLD, 18));
        labelFormNo.setBounds(600, 10, 80, 30);
        add(labelFormNo);

        JLabel labelForm = new JLabel(form_no);
        labelForm.setFont(new Font("Calibri", Font.BOLD, 18));
        labelForm.setBounds(680, 10, 100, 30);
        add(labelForm);

        submit = new JButton("Submit");
        submit.setFont(new Font("Calibri", Font.BOLD, 14));
        submit.setForeground(Color.BLUE);
        submit.setBounds(425, 500, 80, 40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Calibri", Font.BOLD, 14));
        cancel.setForeground(Color.RED);
        cancel.setBounds(525, 500, 80, 40);
        add(cancel);

        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(850, 800);
        setLocation(400, 20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac_type = null;
        if (r1.isSelected()) {
            ac_type = "Savings Account";
        } else if (r2.isSelected()) {
            ac_type = "Current Account";
        } else if (r3.isSelected()) {
            ac_type = "Fixed Deposit";
        } else if (r4.isSelected()) {
            ac_type = "Recurring Deposit";
        }
        Random rand = new Random();
        long first7 = (rand.nextLong() % 90000000L) + 1409963000000000L;
        String card_no = "" + Math.abs(first7);
        long first3 = (rand.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        String services = "";
        if (c1.isSelected()) {
            services = services + " ATM Card ";
        }
        if (c2.isSelected()) {
            services = services + " Net Banking ";
        }
        if (c3.isSelected()) {
            services = services + " Mobile Banking ";
        }
        if (c4.isSelected()) {
            services = services + " Email Alerts ";
        }
        if (c5.isSelected()) {
            services = services + " Cheque Book ";
        }
        if (c6.isSelected()) {
            services = services + " E-statements ";
        }

        try {
            if (e.getSource() == submit) {
                if (ac_type.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all fields");
                } else {
                    Conn conn = new Conn();
                    String qry1 = "INSERT INTO signup3 (form_no, ac_type, card_no, pin, services) VALUES (?, ?, ?, ?, ?)";
                    String qry2 = "INSERT INTO login (form_no, card_no, pin) VALUES (?, ?, ?)";
                    PreparedStatement pstmt1 = conn.con.prepareStatement(qry1);
                    PreparedStatement pstmt2 = conn.con.prepareStatement(qry2);
                    pstmt1.setString(1, form_no);
                    pstmt1.setString(2, ac_type);
                    pstmt1.setString(3, card_no);
                    pstmt1.setString(4, pin);
                    pstmt1.setString(5, services);
                    pstmt2.setString(1, form_no);
                    pstmt2.setString(2, card_no);
                    pstmt2.setString(3, pin);
                    pstmt1.executeUpdate();
                    pstmt2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Card Number: "+card_no+"\n Pin: "+pin );
                    setVisible(false);
                    new Deposit(pin);
                }
            } else if (e.getSource() == cancel) {
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
