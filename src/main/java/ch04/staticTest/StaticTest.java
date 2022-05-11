package ch04.staticTest;

import java.time.LocalDate;
import java.util.function.Supplier;

public class StaticTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("张三", 7500);
        staff[1] = new Employee("李四", 8200);
        staff[2] = new Employee("王五", 12000);

        for(Employee e : staff){
            e.setId();
            System.out.println(e);
        }

        System.out.println("Next available is " + Employee.getNextId());
    }
}

class Employee{
    private static int nextId = 1; // 不赋值会自动初始化为0

    private final String name;
    private double salary;
    private int id;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        this.id = 0;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public int getId(){
        return id;
    }

    public void setId(){
        this.id = nextId;
        ++nextId;
    }

    public static int getNextId(){
        return nextId;
    }

    public static void main(String[] args) {
        Employee e = new Employee("武六", 1234);
        System.out.println(e);
    }

    public void raiseSalary(double byPercent){
        this.salary += this.salary * byPercent / 100;
    }

    @Override
    public String toString(){
        return "name: " + this.name + ", salary: " + this.salary + ", id: " + this.id;
    }
}
