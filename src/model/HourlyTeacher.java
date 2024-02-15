package model;

public class HourlyTeacher extends Teacher implements TeacherSalary{
    private int hours;

    public HourlyTeacher() {
    }

    public HourlyTeacher(int hours) {
        this.hours = hours;
    }

    public HourlyTeacher(String name, String age, double salary, String teacherId, int hours) {
        super(name, age, salary, teacherId);
        this.hours = hours;
        calculate();
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public double calculate() {
        this.salary = salary+ (15 * hours);
        return salary;
    }
}
