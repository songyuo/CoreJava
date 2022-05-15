package ch05.abstractClasses;

public class PerTest {

    public static void main(String[] args) {
        var people = new Person[2];
        people[0] = new Employee("王五", 123123, 1976, 6, 12);
        people[1] = new Student("王德法", "贴膜");
        for(var p : people){
            System.out.println(p.getName() + "," + p.getDescription());
        }
    }

}
