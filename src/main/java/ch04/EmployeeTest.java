package ch04;

import java.time.LocalDate;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("张三", 7500, 1987, 4, 30);
        staff[1] = new Employee("李四", 8200, 1990, 5, 4);
        staff[2] = new Employee("王五", 12000, 1985, 9, 12);

        for(Employee e : staff){
            e.raiseSalary(5);
        }

        for(Employee e : staff){
            System.out.println(e);
        }
    }
}

class Employee{
    private final String name;
    private double salary;
    private final LocalDate hireDay;

    public Employee(String name, double salary, int year, int month ,int day){
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public LocalDate getHireDay(){
        return this.hireDay;
    }

    public void raiseSalary(double byPercent){
        this.salary += this.salary * byPercent / 100;
    }

    @Override
    public String toString(){
        return "name: " + this.name + ", salary: " + this.salary + ", hireDay: " + this.hireDay;
    }
}
