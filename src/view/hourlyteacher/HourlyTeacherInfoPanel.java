package view.hourlyteacher;

import model.FullTimeTeacher;
import model.HourlyTeacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HourlyTeacherInfoPanel extends JFrame {

    private JLabel teacherIdLabel, nameLabel, ageLabel, salaryLabel, hoursLabel;
    private JButton backButton;

    public HourlyTeacherInfoPanel(HourlyTeacher hourlyTeacher) {

        setTitle("Hourly Teacher Information");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        teacherIdLabel = new JLabel("Teacher ID: " + hourlyTeacher.getTeacherId());
        nameLabel = new JLabel("Name: " + hourlyTeacher.getName());
        ageLabel = new JLabel("Age: " + hourlyTeacher.getAge());
        salaryLabel = new JLabel("Salary: " + hourlyTeacher.getSalary());
        hoursLabel = new JLabel("Hours per Week: " + hourlyTeacher.getHours());


        panel.add(new JLabel("Teacher ID:"));
        panel.add(teacherIdLabel);
        panel.add(new JLabel("Name:"));
        panel.add(nameLabel);
        panel.add(new JLabel("Age:"));
        panel.add(ageLabel);
        panel.add(new JLabel("Salary:"));
        panel.add(salaryLabel);
        panel.add(new JLabel("Hours per Week:"));
        panel.add(hoursLabel);


        backButton = new JButton("Back");
        panel.add(backButton);


        add(panel, BorderLayout.CENTER);
    }


    public void setBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
    public void updateInfo(HourlyTeacher hourlyTeacher) {

        teacherIdLabel.setText(hourlyTeacher.getTeacherId());
        nameLabel.setText(hourlyTeacher.getName());
        ageLabel.setText(hourlyTeacher.getAge());
        salaryLabel.setText(String.valueOf(hourlyTeacher.getSalary()));
        hoursLabel.setText(String.valueOf(hourlyTeacher.getHours()));
    }


    public void showView() {
        setVisible(true);
    }
}
