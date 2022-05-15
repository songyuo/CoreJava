package ch05.inheritance;

public class Manager extends Employee{

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        this.bonus = 0;
    }

    @Override
    public double getSalary(){
        return bonus + super.getSalary();
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }


}
