package model;

public class Student extends Person {
    private String studentId;

    public Student() {
    }

    public Student(String name, String age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
