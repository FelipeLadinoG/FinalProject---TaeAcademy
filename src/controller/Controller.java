package controller;

import model.Course;
import model.Student;
import model.Teacher;
import view.CreateStudentPanel;
import view.CreateTeacherPanel;
import view.LoginPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {

    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Course> courseList;


    private LoginPanel loginPanel;
    private CreateTeacherPanel createTeacherPanel;
    private CreateStudentPanel createStudentPanel;

    public Controller() {
        loginPanel = new LoginPanel();
        createTeacherPanel = new CreateTeacherPanel();
        createStudentPanel = new CreateStudentPanel();
        loginPanel.setCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Login as teacher", "Login as student"};
                int choice = JOptionPane.showOptionDialog(null, "Seleccione el tipo de usuario:",
                        "Tipo de usuario", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                loginPanel.setVisible(false);
                switch (choice) {
                    case JOptionPane.YES_OPTION:
                        JOptionPane.showMessageDialog(null, "Login as teacher");
                        createTeacherPanel.showView();
                        break;

                    case JOptionPane.NO_OPTION:
                        JOptionPane.showMessageDialog(null, "Login as student");
                        createStudentPanel.showView();
                        break;
                    default:
                        break;
                }
            }
        });

        loginPanel.setLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Login");

            }
        });
    }

    public void iniciar() {
        loginPanel.showView();
    }












    public Student createStudent (String name, String email, String password, String studentId, String age){
        return new Student(name, email, password, studentId, age);
    }

    public Teacher createTeacher (String name, String email, String password, String type, double hours, double salary){
        return new Teacher(name, email, password, type, hours, salary);
    }

    public Course createClass (String name, String classroom, Teacher teacher, List<Student> studentList){
        return new Course (name, classroom, teacher, studentList);
    }

    public static boolean validarEmail(String email) {
        // Expresión regular para verificar la estructura de un email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Verificar si el email coincide con el patrón
        return email.matches(regex);
    }



}
