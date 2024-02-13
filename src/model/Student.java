package model;

public class Student extends User{
    private String studentId;
    private String age;

    public Student() {
    }

    public Student(String name, String email, String password, String studentId, String age) {
        super(name, email, password);
        this.studentId = studentId;
        this.age = age;
    }
}
