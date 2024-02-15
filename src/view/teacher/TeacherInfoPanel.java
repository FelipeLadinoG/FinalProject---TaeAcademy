package view.teacher;

import model.FullTimeTeacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TeacherInfoPanel extends JFrame {

    private JLabel teacherIdLabel, nameLabel, ageLabel ,salaryLabel, yearsXpLabel;
    private JButton backButton;
    public TeacherInfoPanel(FullTimeTeacher fullTimeTeacher) {
        setTitle("Teacher Information");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        teacherIdLabel = new JLabel("teacherId: " + fullTimeTeacher.getName());
        nameLabel = new JLabel("Name: " + fullTimeTeacher.getName());
        ageLabel = new JLabel("Age: " + fullTimeTeacher.getAge());
        salaryLabel = new JLabel("Salary: " + fullTimeTeacher.getSalary());
        yearsXpLabel = new JLabel("Years of Experience: " + fullTimeTeacher.getYearsXp());

        panel.add(new JLabel("TeacherId:"));
        panel.add(teacherIdLabel);
        panel.add(new JLabel("Name:"));
        panel.add(nameLabel);
        panel.add(new JLabel("Age:"));
        panel.add(ageLabel);
        panel.add(new JLabel("Salary:"));
        panel.add(salaryLabel);
        panel.add(new JLabel("Years of Experience:"));
        panel.add(yearsXpLabel);

        backButton = new JButton("Back");
        panel.add(backButton);

        add(panel, BorderLayout.CENTER);
    }


    public void setBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }


    public void updateInfo(FullTimeTeacher fullTimeTeacher) {
        teacherIdLabel.setText(fullTimeTeacher.getTeacherId());
        nameLabel.setText(fullTimeTeacher.getName());
        ageLabel.setText(fullTimeTeacher.getAge());
        salaryLabel.setText(""+fullTimeTeacher.getSalary());
        yearsXpLabel.setText(""+fullTimeTeacher.getYearsXp());
    }

    public void showView() {
        setVisible(true);
    }
}
