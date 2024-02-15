package model;

public class FullTimeTeacher extends Teacher implements TeacherSalary {
    private double yearsXp;

    public FullTimeTeacher() {
    }

    public FullTimeTeacher(double yearsXp) {
        this.yearsXp = yearsXp;
    }

    public FullTimeTeacher(String name, String age, double salary,String teacherId, double yearsXp) {
        super(name, age, salary, teacherId);
        this.yearsXp = yearsXp;
        calculate();
    }

    public double getYearsXp() {
        return yearsXp;
    }

    public void setYearsXp(double yearsXp) {
        this.yearsXp = yearsXp;
    }

    @Override
    public double calculate() {
        this.salary = 250 +(yearsXp*(250*0.1));
        return salary;
    }
}
