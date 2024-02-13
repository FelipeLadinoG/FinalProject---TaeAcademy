package model;

import java.util.List;

public class Course {
    private String name;
    private String classroom;
    private Teacher teacher;
    List<Student> studentList;

    public Course(String name, String classroom, Teacher teacher, List<Student> studentList) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.studentList = studentList;
    }
}
