package ch05.enums;

import java.util.Locale;
import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase(Locale.ROOT);
        Size size = Size.valueOf(input);
        System.out.println("Size: " + size);
        System.out.println("Abbreviation: " + size.getAbbreviation());
        //因为只有那几个实例，所有比较用==就可以
        if(size == Size.EXTRA_LARGE){
            System.out.println("wow");
        }
    }
}

enum Size{

    //最多有以下几个实例，不能再枚举类外新建实例
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation(){
        return abbreviation ;
    }
    private final String abbreviation;
}
