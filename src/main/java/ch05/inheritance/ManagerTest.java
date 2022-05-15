package ch05.inheritance;

public class ManagerTest {
    public static void main(String[] args) {
        var boss = new Manager("老板", 20000, 1991, 3,1);
        boss.setBonus(123);

        var staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("张三", 1000, 1956, 5,7);
        staff[2] = new Employee("李四", 3212, 1953, 7, 2);

        for(var e : staff){
            System.out.println(e);
        }
    }
}
