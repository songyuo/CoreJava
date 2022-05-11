package ch04;

import java.time.LocalDate;

public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today-1);
        int value = date.getDayOfWeek().getValue();

        System.out.println("Mon Thu Wen Thr Fri Sat Sun");

        //打印日历第一天前的空格部分
        for(int i=1;i<value;++i){
            System.out.print("    ");
        }

        //循环打印日历
        while(date.getMonthValue()==month){
            System.out.printf("%3d", date.getDayOfMonth());
            if(date.getDayOfMonth()==today){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue()==1){
                System.out.println();
            }
        }

    }
}
