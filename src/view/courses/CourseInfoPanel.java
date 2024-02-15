package view.courses;

import model.Course;
import model.Student;
import model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CourseInfoPanel extends JFrame {

    private JLabel nameLabel;
    private JLabel classroomLabel;
    private JLabel teacherLabel;
    private JLabel studentsLabel;
    private JButton backButton;

    public CourseInfoPanel(Course course) {

        setTitle("Course Information");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        nameLabel = new JLabel("Name: " + course.getName());
        classroomLabel = new JLabel("Classroom: " + course.getClassroom());


        Teacher teacher = course.getTeacher();
        if (teacher != null) {
            teacherLabel = new JLabel("Teacher: " + teacher.getName());
        } else {
            teacherLabel = new JLabel("Teacher: Not assigned");
        }


        List<Student> studentList = course.getStudentList();
        if (studentList != null) {
            StringBuilder studentsInfo = new StringBuilder("Students: ");
            for (Student student : studentList) {
                studentsInfo.append(student.getName()).append(", ");
            }
            studentsLabel = new JLabel(studentsInfo.toString());
        } else {
            studentsLabel = new JLabel("Students: No students assigned");
        }


        panel.add(new JLabel("Name:"));
        panel.add(nameLabel);
        panel.add(new JLabel("Classroom:"));
        panel.add(classroomLabel);
        panel.add(new JLabel("Teacher:"));
        panel.add(teacherLabel);
        panel.add(new JLabel("Students:"));
        panel.add(studentsLabel);


        backButton = new JButton("Back");
        panel.add(backButton);


        add(panel, BorderLayout.CENTER);
    }


    public void setBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }



    public void updateInfo(Course course) {

        nameLabel.setText(course.getName());
        classroomLabel.setText(course.getClassroom());


        Teacher teacher = course.getTeacher();
        teacherLabel.setText((teacher != null ? teacher.getName() : "Not assigned"));


        List<Student> studentListCopy = new ArrayList<>(course.getStudentList());
        StringBuilder studentsInfo = new StringBuilder("");
        for (Student student : studentListCopy) {
            studentsInfo.append(student.getName()).append(", ");
        }
        studentsLabel.setText(studentsInfo.toString());
    }



    public void showView() {
        setVisible(true);
    }
}
