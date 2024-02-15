package view.student;

import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentInfoPanel extends JFrame {

    private JLabel nameLabel;
    private JLabel studentIdLabel;
    private JLabel ageLabel;
    private JButton backButton, coursesButton;

    public StudentInfoPanel(Student student) {

        setTitle("Student Information");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        nameLabel = new JLabel("Name: " + student.getName());
        studentIdLabel = new JLabel("Student ID: " + student.getStudentId());
        ageLabel = new JLabel("Age: " + student.getAge());


        panel.add(new JLabel("Name:"));
        panel.add(nameLabel);
        panel.add(new JLabel("Student ID:"));
        panel.add(studentIdLabel);
        panel.add(new JLabel("Age:"));
        panel.add(ageLabel);


        backButton = new JButton("Back");
        panel.add(backButton);

        coursesButton = new JButton("Show Courses");
        panel.add(coursesButton);


        add(panel, BorderLayout.CENTER);
    }


    public void setBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void setCoursesListener(ActionListener listener) {
         coursesButton.addActionListener(listener);
    }

    public void updateInfo(Student student) {

        nameLabel.setText(student.getName());
        studentIdLabel.setText(student.getStudentId());
        ageLabel.setText(student.getAge());
    }


    public void showView() {
        setVisible(true);
    }
}
