package ch05.equals;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    private void raiseSalary(double byPercent){
        this.salary = this.salary * byPercent / 100;
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null) return false;
        if(this.getClass() != object.getClass()) return false;
        var other = (Employee) object;
        return Objects.equals(this.name, other.name) && this.salary == other.salary && Objects.equals(this.hireDay, other.hireDay);
    }

    @Override
    public int hashCode() {
        return  Objects.hash(this.name, this.salary, this.hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name= " + this.name + ",salary= " + this.salary + ", hireDay= " + this.salary + "]";
    }
}
