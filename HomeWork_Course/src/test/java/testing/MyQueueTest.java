package testing;

import org.junit.Test;

public class MyQueueTest {
    @Test
    public void test() throws Exception {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("String1");
        queue.enqueue("String2");
        queue.enqueue("String3");
        queue.enqueue("String4");
        queue.enqueue("String5");
        int length = queue.size();
        for (int i = 0; i < length - 2; i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println();

        queue.enqueue("String4");
        length = queue.size();
        for (int i = 0; i < length; i++) {
            System.out.println(queue.dequeue());
        }
    }
}