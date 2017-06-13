package testing.Structures;

public class MyQueueArray<E> implements MyQueueInt<E> {
    private Object[] objects = new Object[5];
    private int head;
    private int tail;
    private int length;

    @Override
    public void enqueue(E obj) {
        if (objects[head] == null) {
            objects[head] = obj;
        }
        if (tail <= length) {
            objects[tail] = obj;
            tail++;
        } else {
            if (head == tail) {
                Object[] dest = new Object[length * 2];
                System.arraycopy(objects,head,dest,0,length-head);
                System.arraycopy(objects,0,dest,length-head,length-tail);
                objects[tail] = obj;
                tail++;
            }
            if (objects[0] == null) {
                tail = 0;
                objects[tail] = obj;
                tail++;
            }
        }
        length++;
    }

    @Override
    public E dequeue() throws Exception {
        Object obj = objects[head];
        objects[head] = null;
        if (head < objects.length-1) {
            head++;
        } else {
            head=0;
        }
        length--;
        return (E) obj;
    }

    @Override
    public int size() {
        return length;
    }
}