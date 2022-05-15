package ch05.equals;

import java.util.Objects;

public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        bonus = 0;
    }

    @Override
    public double getSalary() {
        return this.bonus + super.getSalary();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object object) {
        //super.equals checked that this and other belong to the same class
        if(!super.equals(object)) return false;
        Manager other = (Manager) object;
        return this.bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus: " + this.bonus + "]";
    }
}
