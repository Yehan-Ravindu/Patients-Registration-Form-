import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientForm extends JFrame {
    private JTextField nameField = new JTextField();
    private JTextField ageField = new JTextField();
    private JTextField addressField = new JTextField();
    private JTextField contactField = new JTextField();
    private JTextField idField = new JTextField();
    private JTextField otherField = new JTextField();
    private JPanel backgroundPanel = new JPanel();
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    private JRadioButton single = new JRadioButton("Single");
    JRadioButton divorced = new JRadioButton("Divorced");
    JRadioButton married = new JRadioButton("Married");
    JRadioButton widow = new JRadioButton("Widow");
    ButtonGroup gender = new ButtonGroup();
    ButtonGroup relation = new ButtonGroup();


    JComboBox<String> his;

    public PatientForm() {
        ImageIcon backgroundImage = new ImageIcon("3.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1200, 800);
        add(backgroundLabel);
        setTitle("Patient Registration Form");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        backgroundLabel.add(backgroundPanel);

        JLabel headLabel = new JLabel("PATIENT REGISTRATION FORM");
        headLabel.setBounds(250, 10, 800, 40);
        headLabel.setForeground(Color.BLUE);
        headLabel.setFont(new Font("Madefor", Font.BOLD, 40));
        backgroundLabel.add(headLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 100, 100, 30);
        nameLabel.setForeground(Color.BLUE);
        nameLabel.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(nameLabel);

        nameField.setBounds(200, 100, 500, 30);
        nameField.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(20, 160, 100, 30);
        ageLabel.setForeground(Color.BLUE);
        ageLabel.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(ageLabel);

        ageField.setBounds(200, 160, 500, 30);
        ageField.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(ageField);

        JLabel idLabel = new JLabel("NIC Number:");
        idLabel.setBounds(20, 220, 200, 30);
        idLabel.setForeground(Color.BLUE);
        idLabel.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(idLabel);

        idField.setBounds(200, 220, 500, 30);
        idField.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(idField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 280, 100, 30);
        addressLabel.setForeground(Color.BLUE);
        addressLabel.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(addressLabel);

        addressField.setBounds(200, 280, 500, 30);
        addressField.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(addressField);

        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setBounds(20, 340, 200, 30);
        contactLabel.setForeground(Color.BLUE);
        contactLabel.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(contactLabel);

        contactField.setBounds(200, 340, 500, 30);
        contactField.setFont(new Font("Madefor", Font.PLAIN, 20));
        backgroundLabel.add(contactField);

        JLabel relationLabel = new JLabel("Relation Status:");
        relationLabel.setBounds(20, 400, 200, 30);
        relationLabel.setForeground(Color.BLUE);
        relationLabel.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(relationLabel);

        single.setActionCommand("Single");
        married.setActionCommand("Married");
        divorced.setActionCommand("Divorced");
        widow.setActionCommand("Widow");
        relation.add(single);
        relation.add(married);
        relation.add(divorced);
        relation.add(widow);
        single.setBounds(200, 400, 100, 30);
        married.setBounds(320, 400, 100, 30);
        divorced.setBounds(440, 400, 100, 30);
        widow.setBounds(560, 400, 100, 30);
        backgroundLabel.add(single);
        backgroundLabel.add(married);
        backgroundLabel.add(divorced);
        backgroundLabel.add(widow);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(20, 460, 200, 30);
        genderLabel.setForeground(Color.BLUE);
        genderLabel.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(genderLabel);

        gender.add(male);
        gender.add(female);
        male.setBounds(200, 460, 100, 30);
        male.setActionCommand("Male");
        female.setBounds(320, 460, 100, 30);
        female.setActionCommand("Female");
        backgroundLabel.add(male);
        backgroundLabel.add(female);

        JLabel historyLabel = new JLabel("Patient History:");
        historyLabel.setBounds(20, 520, 200, 30);
        historyLabel.setForeground(Color.BLUE);
        historyLabel.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(historyLabel);

        String[] historytest = {"Diabetes", "Cancer", "Blood Pressure", "Mental Disorders", "Wheeze"};

    
        his = new JComboBox<>(historytest);
        his.setBounds(200, 520, 500, 30);
        his.setFont(new Font("Arial", Font.BOLD, 15));
        backgroundLabel.add(his);

        JLabel otherLabel = new JLabel("Other Information:");
        otherLabel.setBounds(20, 580, 300, 30);
        otherLabel.setForeground(Color.BLUE);
        otherLabel.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(otherLabel);

        otherField.setBounds(200, 580, 500, 80);
        otherField.setFont(new Font("Madefor", Font.BOLD, 20));
        backgroundLabel.add(otherField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 700, 80, 40);
        backgroundLabel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPatient();
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(150, 700, 80, 40);
        backgroundLabel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        setVisible(true);

    }

    private void registerPatient() {
        String name = nameField.getText();
        String hist = (String) his.getSelectedItem();  // For JComboBox history
        String other = otherField.getText();
        String gend = male.isSelected() ? "Male" : "Female";  // For gender
        String relate = null;

        if (single.isSelected()) relate = "Single";
        else if (married.isSelected()) relate = "Married";
        else if (divorced.isSelected()) relate = "Divorced";
        else if (widow.isSelected()) relate = "Widow";  // For relation

        String id = idField.getText();
        int age;
        int contact;

        
        if (gend == null || relate == null) {
            JOptionPane.showMessageDialog(this, "Please select gender and relation.");
            return;
        }

        try {
            age = Integer.parseInt(ageField.getText());
            contact = Integer.parseInt(contactField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid age or contact number. Please enter valid numbers.");
            return;
        }

        // Database connection
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientDB", "root", "16013tcc");
            String query = "INSERT INTO appointments (name, age, address, id, gender, history, relationship, contact, other) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, addressField.getText());
            statement.setString(4, id);
            statement.setString(5, gend);
            statement.setString(6, hist);
            statement.setString(7, relate);
            statement.setInt(8, contact);
            statement.setString(9, other);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Patient registered successfully!");
                resetFields();
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to database. Please try again.");
        }
    }

    private void resetFields() {
        nameField.setText("");
        ageField.setText("");
        addressField.setText("");
        contactField.setText("");
        idField.setText("");
        otherField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PatientForm());
    }
}
