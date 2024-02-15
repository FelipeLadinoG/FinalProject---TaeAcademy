package model;

import java.util.List;

public class Course {
    private String name;
    private String classroom;
    private Teacher teacher;
    List<Student> studentList;

    public Course() {
    }

    public Course(String name, String classroom, Teacher teacher, List<Student> studentList) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
