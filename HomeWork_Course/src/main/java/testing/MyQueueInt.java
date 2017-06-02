package testing;

public interface MyQueueInt<E> {
    void enqueue(E obj);
    E dequeue() throws Exception;
    int size();
}
