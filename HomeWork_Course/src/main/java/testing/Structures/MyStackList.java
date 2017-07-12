package testing.Structures;

public class MyStackList<E> {
    class Entry<E> {
        Entry<E> next;
        E data;
    }

    private Entry<E> first;
    private int length;

    void push(E obj) {
        Entry<E> entry = new Entry<>();
        entry.data = obj;
        if (first == null) {
            first = entry;
        }
        else {
            Entry<E> oldFirst = first;
            first = entry;
            first.next = oldFirst;
        }
        length++;
    }

    E pop() throws Exception {
        if(first!=null && length>0) {
            Entry<E> entry = first;
            first = first.next;
            length--;
            return entry.data;
        }
        else {
            System.out.println("No Elements");
            throw new Exception();
        }
    }

    public int size() {
        return length;
    }
}
