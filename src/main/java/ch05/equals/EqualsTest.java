package ch05.equals;

public class EqualsTest {
    public static void main(String[] args) {
        var alice1 = new Employee("alice", 1800, 1987, 10, 12);
        var alice2 = alice1;
        var alice3 = new Employee("alice", 1800, 1987, 10, 12);
        var bob = new Employee("bob", 3000, 1995, 12,21);
        System.out.println("alice1==alice2: " + (alice1==alice2));
        System.out.println("alice1==alice3: " + (alice1==alice3));
        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
        System.out.println("alice1.equals(bob): " + alice1.equals(bob));
        System.out.println("bob.toString(): " + bob);

        var carl = new Manager("carl", 10000, 1993, 6, 10);
        var boss = new Manager("boss", 20000, 1973, 3, 8);
        boss.setBonus(8000);

        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());
        System.out.println("boss.hashCode(): " + boss.hashCode());

        var mama = new Manager("alice", 1800, 1987, 10, 12);
        System.out.println("alice1.equals(mama): " + alice1.equals(mama));

    }
}
