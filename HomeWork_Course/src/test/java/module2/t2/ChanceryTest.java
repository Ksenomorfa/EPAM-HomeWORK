package module2.t2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChanceryTest {

    Employee employee1;
    Employee employee2;
    Employee employee3;
    WorkPlace workPlace1;
    WorkPlace workPlace2;
    WorkPlace workPlace3;

    Chancery pencil;
    Chancery ruler;
    Chancery ruler2;
    Chancery eraser;
    Chancery eraser2;

    @Before
    public void init() {
        employee1 = new Employee("Ivanov", "Ivan", "IT");
        employee2 = new Employee("Pavlov", "Pavel", "IT");
        employee3 = new Employee("Sidorov", "Sidor", "Counting");

        workPlace1 = new WorkPlace(employee1);
        workPlace2 = new WorkPlace(employee2);
        workPlace3 = new WorkPlace(employee3);

        pencil = new Pencil("Erich", "X123", 12.43);

        ruler = new Ruler("Erich", "N6342", 13.50);
        ruler2 = new Ruler("Factic", "23UY2", 10.20);
        eraser = new Eraser("Factic", "2T42-2", 4.50);
        eraser2 = new Eraser("L&C", "2300/40", 7.50);

        workPlace1.addChancery(pencil);
        workPlace1.addChancery(pencil);
        workPlace1.addChancery(eraser);
        workPlace1.addChancery(eraser);

        workPlace2.addChancery(eraser);
        workPlace2.addChancery(ruler);
        workPlace2.addChancery(eraser2);
    }

    @Test
    public void summWorkplace1() {
        assertEquals(33.86, workPlace1.calculateChancery(), 0.01);
        workPlace1.printChancery();

    }

    @Test
    public void summWorkplace2() {
        assertEquals(25.5, workPlace2.calculateChancery(), 0.01);
    }
}