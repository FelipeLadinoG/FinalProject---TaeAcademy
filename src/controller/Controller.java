package controller;

import model.*;
import view.*;
import view.courses.CourseInfoPanel;
import view.courses.CoursesPanel;
import view.courses.CreateCoursePanel;
import view.hourlyteacher.CreateHourlyTeacherPanel;
import view.hourlyteacher.HourlyTeacherInfoPanel;
import view.hourlyteacher.HourlyTeachersPanel;
import view.student.CreateStudentPanel;
import view.student.StudentInfoPanel;
import view.student.StudentsPanel;
import view.teacher.CreateTeacherPanel;
import view.teacher.TeacherInfoPanel;
import view.teacher.TeachersPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private List<Student> studentList;
    private List<FullTimeTeacher> fullTimeTeacherList;
    private List<HourlyTeacher> hourlyTeachersList;
    private List<Course> courseList;
    private List<Teacher> teacherList;

    private Student student;

    private LoginPanel loginPanel;
    private CreateTeacherPanel createTeacherPanel;
    private CreateStudentPanel createStudentPanel;
    private CreateHourlyTeacherPanel createHourlyTeacherPanel;
    private CreateCoursePanel createCoursePanel;
    private DashboardPanel dashboardPanel;
    private TeachersPanel teachersPanel;
    private TeacherInfoPanel teacherInfoPanel;
    private StudentsPanel studentsPanel;
    private StudentInfoPanel studentInfoPanel;
    private HourlyTeachersPanel hourlyTeachersPanel;
    private HourlyTeacherInfoPanel hourlyTeacherInfoPanel;
    private CourseInfoPanel courseInfoPanel;
    private CoursesPanel coursesPanel;

    private void initialize() {
        initializeLists();
        initializePanels();
    }




    public Controller() {
        initialize();

        loginPanel.setExitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "System clossed.", "Warning", JOptionPane.WARNING_MESSAGE);
                loginPanel.setVisible(false);
            }
        });

        loginPanel.setLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = loginPanel.getUserText();
                String password = loginPanel.getPasswordText();

                if (user.equals("Admin") && password.equals("Admin")) {
                    JOptionPane.showMessageDialog(null, "Signed as AdminUser.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    loginPanel.setVisible(false);
                    dashboardPanel.setCoursesTotal("Total: " + courseList.size());
                    dashboardPanel.setStudentsTotal("Total: " + studentList.size());
                    dashboardPanel.setTeachersTotal("Total: " + fullTimeTeacherList.size());
                    dashboardPanel.setTemporalTeachersTotal("Total: " + hourlyTeachersList.size());
                    dashboardPanel.showView();
                } else
                    JOptionPane.showMessageDialog(null, "Error! Username or password incorrect.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        });


        dashboardPanel.setTeachersListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardPanel.setVisible(false);
                teachersPanel.showView();

            }
        });

        createTeacherPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTeacherPanel.setVisible(false);
                teachersPanel.showView();

            }
        });

        createTeacherPanel.setCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = createTeacherPanel.getName();
                String age = createTeacherPanel.getAge();
                int yearsXp = createTeacherPanel.getYearsXp();
                yearsXp = 1;
                fullTimeTeacherList.add(new FullTimeTeacher(name, age, 4000, "full-" + fullTimeTeacherList.size(), yearsXp));
                teachersPanel.updateTeacherList(fullTimeTeacherList);
                createTeacherPanel.setVisible(false);
                teachersPanel.showView();
            }
        });


        for (int i = 0; i < fullTimeTeacherList.size(); i++) {
            final int index = i;
            teachersPanel.addTeacherButtonListener(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FullTimeTeacher fullTimeTeacher = fullTimeTeacherList.get(index);
                    showTeacherInfo(fullTimeTeacher);
                }
            });
        }

        teachersPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teachersPanel.setVisible(false);
                dashboardPanel.showView();
            }
        });

        teachersPanel.setCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teachersPanel.setVisible(false);
                createTeacherPanel.showView();
            }
        });

        teacherInfoPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherInfoPanel.setVisible(false);
                teachersPanel.showView();
            }
        });


        dashboardPanel.setStudentsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardPanel.setVisible(false);
                studentsPanel.showView();
            }
        });

        createStudentPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createStudentPanel.setVisible(false);
                studentsPanel.showView();

            }
        });

        createStudentPanel.setCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = createStudentPanel.getName();
                String age = createTeacherPanel.getAge();
                studentList.add(new Student(name, age, "student-" + studentList.size()));
                studentsPanel.updateStudentList(studentList);
                createStudentPanel.setVisible(false);
                studentsPanel.showView();
            }
        });


        for (int i = 0; i < studentList.size(); i++) {
            final int index = i;
            studentsPanel.addStudentButtonListener(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student student = studentList.get(index);
                    showStudentInfo(student);
                }
            });
        }


        studentsPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentsPanel.setVisible(false);
                dashboardPanel.showView();
            }
        });

        studentsPanel.setCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentsPanel.setVisible(false);
                createStudentPanel.showView();
            }
        });

        studentInfoPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentInfoPanel.setVisible(false);

                studentsPanel.showView();
            }
        });

        studentInfoPanel.setCoursesListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCoursesByStudent(student);
                JOptionPane.showMessageDialog(studentInfoPanel, "List of Courses\n" + getCoursesByStudent(student));
            }
        });


        dashboardPanel.setHourlyTeachersListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardPanel.setVisible(false);
                hourlyTeachersPanel.showView();
            }
        });

        createHourlyTeacherPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createHourlyTeacherPanel.setVisible(false);
                hourlyTeachersPanel.showView();

            }
        });

        createHourlyTeacherPanel.setCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = createHourlyTeacherPanel.getName();
                String age = createHourlyTeacherPanel.getAge();
                int yearsXp = (int) createHourlyTeacherPanel.getHours();
                hourlyTeachersList.add(new HourlyTeacher(name, age, 4000, "hourly-" + hourlyTeachersList.size(), yearsXp));


                hourlyTeachersPanel.updateTeacherList(hourlyTeachersList);

                createHourlyTeacherPanel.setVisible(false);
                hourlyTeachersPanel.showView();
            }
        });


        for (int i = 0; i < hourlyTeachersList.size(); i++) {
            final int index = i;
            hourlyTeachersPanel.addTeacherButtonListener(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    HourlyTeacher hourlyTeacher = hourlyTeachersList.get(index);

                    showHourlyTeacherInfo(hourlyTeacher);
                }
            });
        }


        hourlyTeachersPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                hourlyTeachersPanel.setVisible(false);

                dashboardPanel.showView();
            }
        });

        hourlyTeachersPanel.setCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                hourlyTeachersPanel.setVisible(false);

                createHourlyTeacherPanel.showView();
            }
        });

        hourlyTeacherInfoPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                hourlyTeacherInfoPanel.setVisible(false);

                hourlyTeachersPanel.showView();
            }
        });

        dashboardPanel.setCoursesListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardPanel.setVisible(false);
                coursesPanel.showView();
            }
        });

        coursesPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coursesPanel.setVisible(false);
                dashboardPanel.showView();
            }
        });


        coursesPanel.setCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                coursesPanel.setVisible(false);

                createCoursePanel.showView();
            }
        });

        createCoursePanel.setCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Teacher teacherFound = new Teacher();
                String name = createCoursePanel.getName();
                String classroom = createCoursePanel.getClassroom();
                String teacherName = createCoursePanel.getSelectedTeacher();
                for (int i = 0; i < teacherList.size(); i++) {
                    if(teacherList.get(i).getName().equalsIgnoreCase(teacherName)){
                        teacherFound = teacherList.get(i);
                        i=teacherList.size()+1;
                    }
                }

                findStudents(createCoursePanel.getSelectedStudents(), studentList);


                courseList.add(new Course(name, classroom, teacherFound,findStudents(createCoursePanel.getSelectedStudents(), studentList) ));


                studentsPanel.updateStudentList(studentList);
                coursesPanel.updateCourseList(courseList);

                createCoursePanel.setVisible(false);
                coursesPanel.showView();
            }
        });


        for (int i = 0; i < courseList.size(); i++) {
            final int index = i;
            coursesPanel.addCourseButtonListener(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    Course course = courseList.get(index);

                    showCourseInfo(course);
                }
            });
        }

        createCoursePanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createCoursePanel.setVisible(false);

                coursesPanel.showView();
            }
        });

        courseInfoPanel.setBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                courseInfoPanel.setVisible(false);

                coursesPanel.showView();
            }
        });







        dashboardPanel.setLogOutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardPanel.setVisible(false);
                loginPanel.setVisible(true);

            }
        });
    }


    private void initializeLists() {
        student = new Student();

        fullTimeTeacherList = new ArrayList<>();
        fullTimeTeacherList.add(new FullTimeTeacher("Omar Felipe", "35", 0, "full-" + fullTimeTeacherList.size(), 35));
        fullTimeTeacherList.add(new FullTimeTeacher("Rodrigo Hernan", "40", 0, "full-" + fullTimeTeacherList.size(), 45));
        fullTimeTeacherList.add(new FullTimeTeacher("Felipe Omar", "38", 0, "full-" + fullTimeTeacherList.size(), 38));
        fullTimeTeacherList.add(new FullTimeTeacher("Ricardo Wilson", "42", 0, "full-" + fullTimeTeacherList.size(), 42));

        studentList = new ArrayList<>();
        studentList.add(new Student("Felipe", "26", "student-" + studentList.size()));
        studentList.add(new Student("Juan", "25", "student-" + studentList.size()));
        studentList.add(new Student("Miguel", "24", "student-" + studentList.size()));
        studentList.add(new Student("David", "22", "student-" + studentList.size()));
        studentList.add(new Student("Jose", "21", "student-" + studentList.size()));

        hourlyTeachersList = new ArrayList<>();
        hourlyTeachersList.add(new HourlyTeacher("Fernando Alonso", "35", 0, "hourly-" + hourlyTeachersList.size(), 35));
        hourlyTeachersList.add(new HourlyTeacher("LeBron James", "40", 0, "hourly-" + hourlyTeachersList.size(), 45));
        hourlyTeachersList.add(new HourlyTeacher("Richard Alberto", "38", 0, "hourly-" + hourlyTeachersList.size(), 38));
        hourlyTeachersList.add(new HourlyTeacher("Rayo McQueen", "42", 0, "hourly-" + hourlyTeachersList.size(), 42));

        courseList = new ArrayList<>();
        courseList.add(new Course("Maths", "1-101", hourlyTeachersList.get(0), studentList.subList(0, 2)));
        courseList.add(new Course("Science", "1-102", hourlyTeachersList.get(1), studentList.subList(0, 4)));
        courseList.add(new Course("Astronomy", "1-102", hourlyTeachersList.get(1), studentList.subList(1, 3)));
        courseList.add(new Course("Arts", "1-102", hourlyTeachersList.get(1), studentList.subList(2, 2)));


        teacherList = new ArrayList<>();
        teacherList.addAll(fullTimeTeacherList);
        teacherList.addAll(hourlyTeachersList);
    }

    private void initializePanels() {
        loginPanel = new LoginPanel();
        createTeacherPanel = new CreateTeacherPanel();
        createHourlyTeacherPanel = new CreateHourlyTeacherPanel();
        createStudentPanel = new CreateStudentPanel();
        dashboardPanel = new DashboardPanel();
        teacherInfoPanel = new TeacherInfoPanel(new FullTimeTeacher());
        hourlyTeacherInfoPanel = new HourlyTeacherInfoPanel(new HourlyTeacher());
        studentInfoPanel = new StudentInfoPanel(new Student());
        courseInfoPanel = new CourseInfoPanel(new Course());

        teachersPanel = new TeachersPanel(fullTimeTeacherList, this);
        studentsPanel = new StudentsPanel(studentList, this);
        hourlyTeachersPanel = new HourlyTeachersPanel(hourlyTeachersList, this);
        coursesPanel = new CoursesPanel(courseList, this);

        createCoursePanel = new CreateCoursePanel(teacherList, studentList);
    }

    public void showTeacherInfo(FullTimeTeacher fullTimeTeacher) {

        teacherInfoPanel.updateInfo(fullTimeTeacher);

        teachersPanel.setVisible(false);
        teacherInfoPanel.showView();
    }

    public void showHourlyTeacherInfo(HourlyTeacher hourlyTeacher) {

        hourlyTeacherInfoPanel.updateInfo(hourlyTeacher);

        hourlyTeachersPanel.setVisible(false);
        hourlyTeacherInfoPanel.showView();
    }

    public void showStudentInfo(Student student) {
        this.student = student;

        studentInfoPanel.updateInfo(student);

        studentsPanel.setVisible(false);
        studentInfoPanel.showView();
    }

    public void showCourseInfo(Course course) {
//        this.student = student;

        courseInfoPanel.updateInfo(course);

        coursesPanel.setVisible(false);
        courseInfoPanel.showView();
    }


    public void iniciar() {
        loginPanel.showView();
    }


    public String getCoursesByStudent(Student student) {
        List<Course> courses = new ArrayList<>();
        String message = "";
        for (Course course : courseList) {
            if (course.getStudentList().contains(student)) {
                courses.add(course);
                message += course.getName() + "\n";
            }
        }
        return message;
    }

    private List<Student> findStudents(List<String> selectedStudentNames, List<Student> studentList) {
        List<Student> selectedStudents = new ArrayList<>();

        for (String selectedStudentName : selectedStudentNames) {
            List<Student> foundStudents = studentList.stream()
                    .filter(student -> student.getName().equalsIgnoreCase(selectedStudentName))
                    .collect(Collectors.toList());

            selectedStudents.addAll(foundStudents);
            studentList.removeAll(foundStudents);
        }

        return selectedStudents;
    }


}
