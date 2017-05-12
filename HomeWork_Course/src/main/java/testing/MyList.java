package testing;

public class MyList<E> implements List<E> {
    Entry<E> first;
    Entry<E> last;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        if (first == null) {
            first = new Entry<>(element,null);
            last = first;
        } else {
            Entry<E> newEl = new Entry<>(element,null);
            last.next = newEl;
            last = newEl;
        }
        size++;
    }

    @Override
    public void remove(int i) {

    }

    @Override
    public E get(int i) {
        Entry<E> current = first;
        for (int j=0;j<i;j++) {
            current = current.next;
        }
        return current.get();
    }

    static class Entry<E> {
        private E element;
        private Entry<E> next;

        public Entry(E element, Entry<E> next) {
            this.element = element;
            this.next = next;
        }

        public E get() {
            return element;
        }
    }
}
