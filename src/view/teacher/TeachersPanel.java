package view.teacher;

import controller.Controller;
import model.FullTimeTeacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TeachersPanel extends JFrame {

    private JButton backButton, createButton;
    private JPanel teachersPanel;
    public Controller controller;

    public List<FullTimeTeacher> fullTimeTeacherList;

    public TeachersPanel(List<FullTimeTeacher> fullTimeTeacherList, Controller controller) {
        this.fullTimeTeacherList = fullTimeTeacherList;
        this.controller = controller;
        setTitle("TEACHERS");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        teachersPanel = new JPanel(new GridLayout(0, 1));
        teachersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));        teachersPanel.setLayout(new GridLayout(0, 2, 0, 10));
        for (FullTimeTeacher fullTimeTeacher : fullTimeTeacherList) {
            JButton teacherButton = new JButton(fullTimeTeacher.getName());
            teacherButton.setPreferredSize(new Dimension(300, 100));            teacherButton.setBackground(Color.WHITE);            teacherButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));            teachersPanel.add(teacherButton);
        }

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 50));
        createButton = new JButton("Create");
        createButton.setPreferredSize(new Dimension(200, 50));
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(backButton, BorderLayout.WEST);        buttonPanel.add(createButton, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        add(teachersPanel, BorderLayout.CENTER);

        setResizable(false);
    }

    public void setBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void setCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addTeacherButtonListener(int index, ActionListener listener) {
        Component[] components = teachersPanel.getComponents();
        if (index >= 0 && index < components.length) {
            JButton teacherButton = (JButton) components[index];
            teacherButton.addActionListener(listener);
        }
    }

    public void updateTeacherList(List<FullTimeTeacher> fullTimeTeacherList) {
        this.fullTimeTeacherList = fullTimeTeacherList;
        teachersPanel.removeAll();

        for (FullTimeTeacher fullTimeTeacher : fullTimeTeacherList) {
            JButton teacherButton = new JButton(fullTimeTeacher.getName());
            teacherButton.setPreferredSize(new Dimension(300, 100));            teacherButton.setBackground(Color.WHITE);            teacherButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));            teacherButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.showTeacherInfo(fullTimeTeacher);                }
            });
            teachersPanel.add(teacherButton);
        }

        revalidate();
        repaint();
    }

    public void showView() {
        setVisible(true);
    }
}
