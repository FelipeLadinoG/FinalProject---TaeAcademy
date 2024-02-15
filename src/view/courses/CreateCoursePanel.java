package view.courses;

import model.Student;
import model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreateCoursePanel extends JFrame {

    private JTextField nameField, classroomField;
    private JComboBox<String> teacherComboBox;
    private JPanel studentsPanel;
    private JButton backButton, createButton;

    public CreateCoursePanel(List<Teacher> teacherList, List<Student> studentList) {

        setTitle("Create Course");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setResizable(false);


        nameField = new JTextField();
        classroomField = new JTextField();


        teacherComboBox = new JComboBox<>();
        for (Teacher teacher : teacherList) {
            teacherComboBox.addItem(teacher.getName());
        }


        studentsPanel = new JPanel(new GridLayout(studentList.size(), 1));
        for (Student student : studentList) {
            JCheckBox checkBox = new JCheckBox(student.getName());
            studentsPanel.add(checkBox);
        }


        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Classroom:"));
        panel.add(classroomField);
        panel.add(new JLabel("Teacher:"));
        panel.add(teacherComboBox);
        panel.add(new JLabel("Students:"));
        panel.add(studentsPanel);


        backButton = new JButton("Back");


        createButton = new JButton("Create");


        panel.add(backButton);
        panel.add(createButton);


        add(panel, BorderLayout.CENTER);


        pack();


        setSize(450, getHeight());
        setLocationRelativeTo(null);
    }


    public String getName() {
        return nameField.getText();
    }


    public String getClassroom() {
        return classroomField.getText();
    }


    public String getSelectedTeacher() {
        return (String) teacherComboBox.getSelectedItem();
    }


    public List<String> getSelectedStudents() {

        List<String> selectedStudents = new ArrayList<>();
        Component[] components = studentsPanel.getComponents();
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                if (checkBox.isSelected()) {
                    selectedStudents.add(checkBox.getText());
                }
            }
        }
        return selectedStudents;
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
