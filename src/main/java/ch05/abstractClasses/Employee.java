package ch05.abstractClasses;

import java.time.LocalDate;

public class Employee extends Person{

    private double salary;

    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day){
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of %.2f", this.salary);
    }

    public void raiseSalary(double byPercent){
        this.salary = salary * byPercent / 100;
    }
}