package view.hourlyteacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateHourlyTeacherPanel extends JFrame {

    private JTextField nameField, ageField, hoursField;
    private JButton backButton, createButton;

    public CreateHourlyTeacherPanel() {

        setTitle("Create Hourly Teacher");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        nameField = new JTextField();
        ageField = new JTextField();
        hoursField = new JTextField();


        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Hours per Week:"));
        panel.add(hoursField);


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


    public int getHours() {
        return Integer.parseInt(hoursField.getText());
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
