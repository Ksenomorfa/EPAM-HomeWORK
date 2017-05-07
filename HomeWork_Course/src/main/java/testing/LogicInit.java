package testing;

import module1.t1.logic.Logic;

import java.util.Date;

public class LogicInit {

    public static void main(String[] args) {
        LogicBlock2 log;
        System.out.println("step 0 ");

        log = new LogicBlock2(3);

    }

}
class LogicBlock2 {
    {
        System.out.println("logic(1) id = " + id); //0
    }

    private static int id;

    {
        id = 10;
        System.out.println("logic(1) id = " + id); //0

    }

    {
        System.out.println("logic(2) id = " + id); //7
        Date d = new Date(); //timestamp
        calc(d);
    }

    public LogicBlock2(int d) {
        System.out.println("конструктор before id = " + id);
        id = d;
        System.out.println("конструктор after id = " + id); //3 - в самый последнюю очередь
    }

    {
        id = 10;
        System.out.println("logic(3) id = " + id); //10
    }

    private void calc(Date d) {
        System.out.println(d.getTime());
    }

}
