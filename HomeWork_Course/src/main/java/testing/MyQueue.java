package testing;

public class MyQueue<E> implements MyQueueInt<E> {
    private Entry<E> head;
    private Entry<E> tail;
    private int length;

    @Override
    public void enqueue(E obj) {
        Entry<E> entry = new Entry<>();
        entry.data = obj;
        entry.next = null;
        if (head == null) {
            head = entry;
        } else {
            tail.next = entry;
        }
        tail = entry;
        length++;
    }

    @Override
    public E dequeue() throws Exception {
        Entry<E> entry = head;
        if (head != null) {
            head = head.next;
        }
        if (length == 0) {
            tail = null;
            throw new Exception();
        }
        length--;
        return entry.data;
    }

    @Override
    public int size() {
        return length;
    }

    class Entry<E> {
        Entry<E> next;
        E data;

        @Override
        public String toString() {
            return " data=" + data + '}';
        }
    }
}
