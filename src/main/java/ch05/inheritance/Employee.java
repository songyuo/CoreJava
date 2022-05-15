package ch05.inheritance;

import java.time.LocalDate;

public class Employee {

    private String name;

    private double salary;

    private LocalDate hireDate;

    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(year, month, day);
    }

    public void raiseSalary(double percent){
        this.salary = this.salary * percent / 100;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString(){
        //这里最好用get方法而不是直接调用实例变量，因为方法中会对变量做一些处理，比如manager的salary会加上bonus才是对的
        return "name: " + getName() + ", salary: " + getSalary();
    }
}
