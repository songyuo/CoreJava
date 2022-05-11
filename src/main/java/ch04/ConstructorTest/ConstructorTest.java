package ch04.ConstructorTest;

import java.util.Random;

public class ConstructorTest {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("张三", 7500);
        staff[1] = new Employee(8200);
        staff[2] = new Employee();
        for(var e : staff){
            System.out.println(e);
        }
    }
}

class Employee{
    private static int nextId;

    private final int id;
    private String name = "";
    private double salary;

    static {
        var generator = new Random();
        nextId = generator.nextInt(1000);
    }

    {
        id = nextId++;
    }

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public Employee(double salary){
        this("id: " + nextId, salary);  // 注意：这里不能用id
    }

    public Employee(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString(){
        return "id: " + this.id + ", name: " + this.name + ", salary: " + this.salary;
    }
}
