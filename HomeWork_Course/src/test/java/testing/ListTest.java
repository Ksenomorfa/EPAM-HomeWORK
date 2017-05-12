package testing;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ListTest {

    @Test
    public void testAdditionFirst() {
        MyList<String> list = new MyList<>();
        String string = "Проверка";
        list.add(string);
        assertEquals(string, list.last.get());
    }

    @Test
    public void testAdditionSecond() {
        MyList<String> list = new MyList<>();
        String string1 = "Проверка1";
        list.add(string1);
        assertEquals(string1, list.first.get());
        assertEquals(1, list.size());

        String string2 = "Проверка2";
        list.add(string2);
        assertEquals(string2, list.last.get());
        assertEquals(2, list.size());
    }

    @Test
    public void testGetElement() {
        MyList<String> list = new MyList<>();
        String string1 = "Проверка1";
        list.add(string1);
        assertEquals(string1, list.get(0));

        String string2 = "Проверка2";
        list.add(string2);
        assertEquals(string2, list.get(1));

        String string3 = "Проверка3";
        list.add(string3);
        assertEquals(string3, list.get(2));

    }
}