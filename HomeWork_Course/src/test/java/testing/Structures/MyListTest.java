package testing.Structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyListTest {
    MyList<String> list;

    @Before
    public void init() {
        list = new MyList<>();
    }

    @Test
    public void testAdditionFirst() {
        String string = "Проверка";
        list.add(string);
        assertEquals(string, list.last.get());
    }

    @Test
    public void testAddGet3Element() {
        String string1 = "Проверка1";
        String string2 = "Проверка2";
        String string3 = "Проверка3";
        list.add(string1);
        list.add(string2);
        list.add(string3);
        assertEquals(string1, list.get(0));
        assertEquals(string2, list.get(1));
        assertEquals(string3, list.get(2));

    }
    @Test
    public void deleteElements() {
        testAddGet3Element();
        list.printList();
        System.out.println("!");
        list.remove(0);
        list.remove(1);
        String string4 = "Проверка4";
        String string5 = "Проверка5";
        String string6 = "Проверка6";
        list.add(string4);
        list.add(string5);
        list.add(string6);
        list.printList();
        System.out.println("!");
        list.remove(2);
        list.printList();
    }
}