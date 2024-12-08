package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    JTextField userName, userFName, userEmail, userAddress, userCity, userPincode, userState;
    JDateChooser dateChooser;
    JRadioButton r1, r2, r3, r4, r5;
    JButton next;

    Random rand = new Random();
    long fourDigit = (rand.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(fourDigit);

    Signup() {
        super("New Account");

        JLabel label1 = new JLabel("Application No." + first);
        label1.setBounds(180, 20, 600, 40);
        label1.setFont(new Font("Calibri", Font.BOLD, 32));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(330, 70, 600, 30);
        label2.setFont(new Font("Calibri", Font.BOLD, 20));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Calibri", Font.BOLD, 18));
        label3.setBounds(280, 100, 600, 30);
        add(label3);

        JLabel labelName = new JLabel("Name");
        labelName.setFont(new Font("Calibri", Font.BOLD, 18));
        labelName.setBounds(100, 150, 100, 30);
        add(labelName);

        userName = new JTextField();
        userName.setFont(new Font("Calibri", Font.BOLD, 18));
        userName.setBounds(300, 150, 300, 30);
        add(userName);

        JLabel labelFname = new JLabel("Father's Name");
        labelFname.setFont(new Font("Calibri", Font.BOLD, 18));
        labelFname.setBounds(100, 200, 200, 30);
        add(labelFname);

        userFName = new JTextField();
        userFName.setFont(new Font("Calibri", Font.BOLD, 18));
        userFName.setBounds(300, 200, 300, 30);
        add(userFName);

        JLabel labelDOB = new JLabel("DOB");
        labelDOB.setFont(new Font("Calibri", Font.BOLD, 18));
        labelDOB.setBounds(100, 250, 200, 30);
        add(labelDOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(Color.BLUE);
        dateChooser.setBounds(300, 250, 300, 30);
        add(dateChooser);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setFont(new Font("Calibri", Font.BOLD, 18));
        labelGender.setBounds(100, 300, 200, 30);
        add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Calibri", Font.BOLD, 14));
        r1.setBounds(300, 300, 100, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Calibri", Font.BOLD, 14));
        r2.setBounds(450, 300, 100, 30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Calibri", Font.BOLD, 18));
        labelEmail.setBounds(100, 350, 200, 30);
        add(labelEmail);

        userEmail = new JTextField();
        userEmail.setFont(new Font("Calibri", Font.BOLD, 18));
        userEmail.setBounds(300, 350, 300, 30);
        add(userEmail);

        JLabel labelMarital = new JLabel("Marital Status");
        labelMarital.setFont(new Font("Calibri", Font.BOLD, 18));
        labelMarital.setBounds(100, 400, 200, 30);
        add(labelMarital);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Calibri", Font.BOLD, 14));
        r3.setBounds(300, 400, 100, 30);
        add(r3);

        r4 = new JRadioButton("Bachelor");
        r4.setFont(new Font("Calibri", Font.BOLD, 14));
        r4.setBounds(400, 400, 100, 30);
        add(r4);

        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Calibri", Font.BOLD, 14));
        r5.setBounds(500, 400, 100, 30);
        add(r5);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(r3);
        buttonGroup2.add(r4);
        buttonGroup2.add(r5);

        JLabel labelAddress = new JLabel("Address");
        labelAddress.setFont(new Font("Calibri", Font.BOLD, 18));
        labelAddress.setBounds(100, 450, 200, 30);
        add(labelAddress);

        userAddress = new JTextField();
        userAddress.setFont(new Font("Calibri", Font.BOLD, 18));
        userAddress.setBounds(300, 450, 300, 30);
        add(userAddress);

        JLabel labelCity = new JLabel("City");
        labelCity.setFont(new Font("Calibri", Font.BOLD, 18));
        labelCity.setBounds(100, 500, 200, 30);
        add(labelCity);

        userCity = new JTextField();
        userCity.setFont(new Font("Calibri", Font.BOLD, 18));
        userCity.setBounds(300, 500, 300, 30);
        add(userCity);

        JLabel labelPincode = new JLabel("Pincode");
        labelPincode.setFont(new Font("Calibri", Font.BOLD, 18));
        labelPincode.setBounds(100, 550, 200, 30);
        add(labelPincode);

        userPincode = new JTextField();
        userPincode.setFont(new Font("Calibri", Font.BOLD, 18));
        userPincode.setBounds(300, 550, 300, 30);
        add(userPincode);

        JLabel labelState = new JLabel("State");
        labelState.setFont(new Font("Calibri", Font.BOLD, 18));
        labelState.setBounds(100, 600, 200, 30);
        add(labelState);

        userState = new JTextField();
        userState.setFont(new Font("Calibri", Font.BOLD, 18));
        userState.setBounds(300, 600, 300, 30);
        add(userState);

        next = new JButton("NEXT");
        next.setFont(new Font("Calibri", Font.BOLD, 14));
        next.setBounds(525, 650, 80, 40);
        next.setForeground(Color.BLUE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setSize(850,800);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String form_no = first;
        String name = userName.getText();
        String father_name = userFName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }
        String email = userEmail.getText();
        String marital_status = null;
        if (r3.isSelected()) {
            marital_status = "Married";
        } else if (r4.isSelected()) {
            marital_status = "Bachelor";
        } else if (r5.isSelected()) {
            marital_status = "Other";
        }
        String address = userAddress.getText();
        String city = userCity.getText();
        String pincode = userPincode.getText();
        String state = userState.getText();

        try {
            if (userName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } else if (userFName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your father's name");
            } else {
                Conn conn1 = new Conn();
                String qry = "INSERT INTO signup (form_no, name, father_name, dob, gender, email, marital_status, address, city, pincode, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn1.con.prepareStatement(qry);
                pstmt.setString(1, form_no);
                pstmt.setString(2, name);
                pstmt.setString(3, father_name);
                pstmt.setString(4, dob);
                pstmt.setString(5, gender);
                pstmt.setString(6, email);
                pstmt.setString(7, marital_status);
                pstmt.setString(8, address);
                pstmt.setString(9, city);
                pstmt.setString(10, pincode);
                pstmt.setString(11, state);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Sign-up successful!");
                new Signup2(first);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
