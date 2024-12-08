package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Signup2 extends JFrame implements ActionListener {
    String form_no;
    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPAN, textAadhaar;
    JRadioButton r1, r2, r3, r4;
    JButton next;

    Signup2(String first){
        super("New Account");

        this.form_no = first;

        JLabel label1 = new JLabel("Page 2");
        label1.setBounds(360, 20, 600, 30);
        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        add(label1);

        JLabel label2 = new JLabel("Additional Details");
        label2.setFont(new Font("Calibri", Font.BOLD, 18));
        label2.setBounds(310, 50, 600, 30);
        add(label2);

        JLabel labelReligion = new JLabel("Religion");
        labelReligion.setFont(new Font("Calibri", Font.BOLD, 18));
        labelReligion.setBounds(100, 100, 100, 30);
        add(labelReligion);

        String[] religion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(Color.WHITE);
        comboBox.setFont(new Font("Calibri", Font.BOLD, 18));
        comboBox.setBounds(250, 100, 300, 30);
        add(comboBox);

        JLabel labelCategory = new JLabel("Category");
        labelCategory.setFont(new Font("Calibri", Font.BOLD, 18));
        labelCategory.setBounds(100, 150, 100, 30);
        add(labelCategory);

        String[] category = {"General", "OBC", "SC", "ST", "Other"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(Color.WHITE);
        comboBox2.setFont(new Font("Calibri", Font.BOLD, 18));
        comboBox2.setBounds(250, 150, 300, 30);
        add(comboBox2);

        JLabel labelIncome = new JLabel("Income");
        labelIncome.setFont(new Font("Calibri", Font.BOLD, 18));
        labelIncome.setBounds(100, 200, 100, 30);
        add(labelIncome);

        String[] income = {"None", "Below 1,50,000", "Below 2,50,000", "Below 5,00,000", "Over 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(Color.WHITE);
        comboBox3.setFont(new Font("Calibri", Font.BOLD, 18));
        comboBox3.setBounds(250, 200, 300, 30);
        add(comboBox3);

        JLabel labelEducation = new JLabel("Education");
        labelEducation.setFont(new Font("Calibri", Font.BOLD, 18));
        labelEducation.setBounds(100, 250, 100, 30);
        add(labelEducation);

        String[] education = {"Non Graduate", "Graduate", "Post Graduate", "Doctorate", "Other"};
        comboBox4 = new JComboBox(education);
        comboBox4.setBackground(Color.WHITE);
        comboBox4.setFont(new Font("Calibri", Font.BOLD, 18));
        comboBox4.setBounds(250, 250, 300, 30);
        add(comboBox4);

        JLabel labelOccupation = new JLabel("Occupation");
        labelOccupation.setFont(new Font("Calibri", Font.BOLD, 18));
        labelOccupation.setBounds(100, 300, 120, 30);
        add(labelOccupation);

        String[] occupation = {"Unemployed", "Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(Color.WHITE);
        comboBox5.setFont(new Font("Calibri", Font.BOLD, 18));
        comboBox5.setBounds(250, 300, 300, 30);
        add(comboBox5);

        JLabel labelPAN = new JLabel("PAN");
        labelPAN.setFont(new Font("Calibri", Font.BOLD, 18));
        labelPAN.setBounds(100, 350, 120, 30);
        add(labelPAN);

        textPAN = new JTextField();
        textPAN.setFont(new Font("Calibri", Font.BOLD, 18));
        textPAN.setBounds(250, 350, 300, 30);
        add(textPAN);

        JLabel labelAadhaar = new JLabel("Aadhaar No");
        labelAadhaar.setFont(new Font("Calibri", Font.BOLD, 18));
        labelAadhaar.setBounds(100, 400, 120, 30);
        add(labelAadhaar);

        textAadhaar = new JTextField();
        textAadhaar.setFont(new Font("Calibri", Font.BOLD, 18));
        textAadhaar.setBounds(250, 400, 300, 30);
        add(textAadhaar);

        JLabel labelSenior = new JLabel("Senior Citizen");
        labelSenior.setFont(new Font("Calibri", Font.BOLD, 18));
        labelSenior.setBounds(100, 450, 150, 30);
        add(labelSenior);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Calibri", Font.BOLD, 14));
        r1.setBounds(300, 450, 100, 30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Calibri", Font.BOLD, 14));
        r2.setBounds(450, 450, 100, 30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelExisting = new JLabel("Existing Account");
        labelExisting.setFont(new Font("Calibri", Font.BOLD, 18));
        labelExisting.setBounds(100, 500, 170, 30);
        add(labelExisting);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Calibri", Font.BOLD, 14));
        r3.setBounds(300, 500, 100, 30);
        add(r3);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Calibri", Font.BOLD, 14));
        r4.setBounds(450, 500, 100, 30);
        add(r4);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(r3);
        buttonGroup2.add(r4);

        JLabel labelFormNo = new JLabel("Form No");
        labelFormNo.setFont(new Font("Calibri", Font.BOLD, 18));
        labelFormNo.setBounds(600, 10, 80, 30);
        add(labelFormNo);

        JLabel labelNum = new JLabel(form_no);
        labelNum.setFont(new Font("Calibri", Font.BOLD, 18));
        labelNum.setBounds(680, 10, 100, 30);
        add(labelNum);

        next = new JButton("NEXT");
        next.setFont(new Font("Calibri", Font.BOLD, 14));
        next.setBounds(525, 550, 80, 40);
        next.setForeground(Color.BLUE);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850, 750);
        setLocation(450, 80);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) comboBox.getSelectedItem();
        String category = (String) comboBox2.getSelectedItem();
        String income = (String) comboBox3.getSelectedItem();
        String education = (String) comboBox4.getSelectedItem();
        String occupation = (String) comboBox5.getSelectedItem();
        String pan = textPAN.getText();
        String aadhaar = textAadhaar.getText();
        String senior_citizen = "";
        if (r1.isSelected()) {
            senior_citizen = "Yes";
        } else if (r2.isSelected()) {
            senior_citizen = "No";
        }
        String existing_account = "";
        if (r3.isSelected()) {
            existing_account = "Yes";
        } else if (r4.isSelected()) {
            existing_account = "No";
        }

        try {
            if (textPAN.getText().isEmpty() || textAadhaar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill all fields");
            } else {
                Conn conn1 = new Conn();
                String qry1 = "INSERT INTO signup2 (form_no, religion, category, income, education, occupation, pan, aadhaar, senior_citizen, existing_account) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn1.con.prepareStatement(qry1);
                pstmt.setString(1, form_no);
                pstmt.setString(2, religion);
                pstmt.setString(3, category);
                pstmt.setString(4, income);
                pstmt.setString(5, education);
                pstmt.setString(6, occupation);
                pstmt.setString(7, pan);
                pstmt.setString(8, aadhaar);
                pstmt.setString(9, senior_citizen);
                pstmt.setString(10, existing_account);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Sign-up successful!");
                new Signup3(form_no);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
