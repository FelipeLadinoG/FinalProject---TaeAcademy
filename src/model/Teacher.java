package model;

public class Teacher extends User{
    private String type;
    private double hours;
    private double Salary;

    public Teacher(String name, String email, String password) {
        super(name, email, password);
    }

    public Teacher(String name, String email, String password, String type, double hours, double salary) {
        super(name, email, password);
        this.type = type;
        this.hours = hours;
        Salary = salary;
    }
}
