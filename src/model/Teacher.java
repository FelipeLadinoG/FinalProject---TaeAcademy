package model;

public class Teacher extends Person {

    protected double salary;
    protected String teacherId;


    public Teacher() {
    }

    public Teacher(String name, String age, double salary, String teacherId) {
        super(name, age);
        this.salary = salary;
        this.teacherId = teacherId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
