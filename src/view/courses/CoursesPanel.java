package view.courses;

import controller.Controller;
import model.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CoursesPanel extends JFrame {

    private JButton backButton;
    private JButton createButton;
    private JPanel coursesPanel;
    public List<Course> courseList;
    public Controller controller;

    public CoursesPanel(List<Course> courseList, Controller controller) {

        this.controller = controller;
        this.courseList = courseList;
        setTitle("COURSES");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        coursesPanel = new JPanel(new GridLayout(0, 1));


        coursesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        coursesPanel.setLayout(new GridLayout(0, 1, 0, 10));


        for (Course course : courseList) {
            JButton courseButton = new JButton(course.getName());
            courseButton.setPreferredSize(new Dimension(300, 50));
            courseButton.setBackground(Color.WHITE);
            courseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            coursesPanel.add(courseButton);
        }


        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 50));


        createButton = new JButton("Create");
        createButton.setPreferredSize(new Dimension(200, 50));


        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(createButton, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);


        add(coursesPanel, BorderLayout.CENTER);

        setResizable(false);
    }


    public void setBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }


    public void setCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }


    public void addCourseButtonListener(int index, ActionListener listener) {
        Component[] components = coursesPanel.getComponents();
        if (index >= 0 && index < components.length) {
            JButton courseButton = (JButton) components[index];
            courseButton.addActionListener(listener);
        }
    }

    public void updateCourseList(List<Course> courseList) {
        this.courseList = courseList;

        coursesPanel.removeAll();


        for (int i = 0; i < courseList.size(); i++) {
            final int index = i;
            Course course = courseList.get(index);
            JButton courseButton = new JButton(course.getName());
            courseButton.setPreferredSize(new Dimension(300, 100));
            courseButton.setBackground(Color.WHITE);
            courseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            courseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    controller.showCourseInfo(course);
                }
            });
            coursesPanel.add(courseButton);
        }


        revalidate();
        repaint();
    }

    public void showView() {
        setVisible(true);
    }
}
