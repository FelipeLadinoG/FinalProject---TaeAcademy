package view.student;

import controller.Controller;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentsPanel extends JFrame {

    private JButton backButton, createButton;
    private JPanel studentsPanel;

    public List<Student> studentList;
    public Controller controller;

    public StudentsPanel(List<Student> studentList , Controller controller) {
        this.controller = controller;
        this.studentList = studentList;
        setTitle("STUDENTS");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        studentsPanel = new JPanel(new GridLayout(0, 1));
        studentsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));        studentsPanel.setLayout(new GridLayout(0, 2, 0, 10));
        for (Student student : studentList) {
            JButton studentButton = new JButton(student.getName());
            studentButton.setPreferredSize(new Dimension(300, 100));            studentButton.setBackground(Color.WHITE);            studentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));            studentsPanel.add(studentButton);
        }

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 50));
        createButton = new JButton("Create");
        createButton.setPreferredSize(new Dimension(200, 50));
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(backButton, BorderLayout.WEST);        buttonPanel.add(createButton, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        add(studentsPanel, BorderLayout.CENTER);

        setResizable(false);
    }

    public void setBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void setCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addStudentButtonListener(int index, ActionListener listener) {
        Component[] components = studentsPanel.getComponents();
        if (index >= 0 && index < components.length) {
            JButton studentButton = (JButton) components[index];
            studentButton.addActionListener(listener);
        }
    }

    public void updateStudentList(List<Student> studentList) {
        this.studentList = studentList;
        studentsPanel.removeAll();

        for (int i = 0; i < studentList.size(); i++) {
            final int index = i;
            Student student = studentList.get(index);
            JButton studentButton = new JButton(student.getName());
            studentButton.setPreferredSize(new Dimension(300, 100));            studentButton.setBackground(Color.WHITE);            studentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));            studentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.showStudentInfo(student);
                }
            });
            studentsPanel.add(studentButton);
        }

        revalidate();
        repaint();
    }

    public void showView() {
        setVisible(true);
    }
}
