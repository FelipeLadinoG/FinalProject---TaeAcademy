package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DashboardPanel extends JFrame {

    private JButton teachersBtn;
    private JTextField teachersTotalField;
    private JButton hourlyTeachersBtn;
    private JTextField hourlyTeachersTotalField;
    private JButton studentsBtn;
    private JTextField studentsTotalField;
    private JButton coursesBtn;
    private JTextField coursesTotalField;
    private JButton logOutBtn;

    public DashboardPanel() {
        setTitle("DASHBOARD");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        teachersBtn = new JButton("Teachers");
        teachersTotalField = new JTextField();
        teachersTotalField.setEditable(false);        hourlyTeachersBtn = new JButton("Temporal Teachers");
        hourlyTeachersTotalField = new JTextField();
        hourlyTeachersTotalField.setEditable(false);        studentsBtn = new JButton("Students");
        studentsTotalField = new JTextField();
        studentsTotalField.setEditable(false);        coursesBtn = new JButton("Courses");
        coursesTotalField = new JTextField();
        coursesTotalField.setEditable(false);        logOutBtn = new JButton("Log Out");

        panel.add(teachersBtn);
        panel.add(teachersTotalField);
        panel.add(hourlyTeachersBtn);
        panel.add(hourlyTeachersTotalField);
        panel.add(studentsBtn);
        panel.add(studentsTotalField);
        panel.add(coursesBtn);
        panel.add(coursesTotalField);
        panel.add(logOutBtn);
        add(panel);
        setResizable(false);
    }

    public void setTeachersListener(ActionListener listener) {
        teachersBtn.addActionListener(listener);
    }

    public void setHourlyTeachersListener(ActionListener listener) {
        hourlyTeachersBtn.addActionListener(listener);
    }

    public void setStudentsListener(ActionListener listener) {
        studentsBtn.addActionListener(listener);
    }

    public void setCoursesListener(ActionListener listener) {
        coursesBtn.addActionListener(listener);
    }

    public void setLogOutListener(ActionListener listener) {
        logOutBtn.addActionListener(listener);
    }

    public void setTeachersTotal(String total) {
        teachersTotalField.setText(total);
    }

    public void setTemporalTeachersTotal(String total) {
        hourlyTeachersTotalField.setText(total);
    }

    public void setStudentsTotal(String total) {
        studentsTotalField.setText(total);
    }

    public void setCoursesTotal(String total) {
        coursesTotalField.setText(total);
    }

    public void showView() {
        setVisible(true);
    }
}
