package sortesAndStructures.Structures;

import org.junit.Before;
import org.junit.Test;

public class MyStackListTest {
    private MyStackList<Integer> a;

    @Before
    public void init() {
        a = new MyStackList<>();
    }

    @Test
    public void test1OK() throws Exception {
        a.push(1);
        a.push(1);
        a.push(3);
        a.push(4);
        System.out.println(a.pop() + " length: " + a.size());
        System.out.println(a.pop() + " length: " + a.size());
        System.out.println(a.pop() + " length: " + a.size());
        System.out.println(a.pop() + " length: " + a.size());
    }

    @Test(expected = Exception.class)
    public void test2Exception() throws Exception {
        System.out.println(a.pop() + " length: " + a.size());
    }
}