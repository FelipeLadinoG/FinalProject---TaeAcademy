package view.student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateStudentPanel extends JFrame {

    private JTextField nameField, ageField;
    private JButton backButton, createButton;

    public CreateStudentPanel() {

        setTitle("Create Student");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        nameField = new JTextField();
        ageField = new JTextField();


        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);


        backButton = new JButton("Back");


        createButton = new JButton("Create");


        panel.add(backButton);
        panel.add(createButton);


        add(panel, BorderLayout.CENTER);
    }


    public String getName() {
        return nameField.getText();
    }


    public String getAge() {
        return ageField.getText();
    }


    public void setBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }


    public void setCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }


    public void showView() {
        setVisible(true);
    }
}
