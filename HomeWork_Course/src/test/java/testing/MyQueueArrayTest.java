package testing;

import org.junit.Test;

public class MyQueueArrayTest {
    @Test
    public void test() throws Exception {
        MyQueueArray<String> myQueueArray = new MyQueueArray<>();
        myQueueArray.enqueue("String1");
        myQueueArray.enqueue("String2");
        myQueueArray.enqueue("String3");
        myQueueArray.enqueue("String4");
        myQueueArray.enqueue("String5");
        int length = myQueueArray.size();

        for (int i = 0; i < length - 2; i++) {
            System.out.println(myQueueArray.dequeue());
        }
        System.out.println();

        myQueueArray.enqueue("String6");
        myQueueArray.enqueue("String7");
        myQueueArray.enqueue("String8");
        length = myQueueArray.size();
        for (int i = 0; i < length; i++) {
            System.out.println(myQueueArray.dequeue());
        }
    }
}