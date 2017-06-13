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
            first = new Entry<>(element, null);
            last = first;
        } else {
            Entry<E> newEl = new Entry<>(element, null);
            last.next = newEl;
            last = newEl;
        }
        size++;
    }

    @Override
    public void remove(int i) {
        Entry<E> current = first;
        if (i < size) {
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
        }
        if ((current == last) && (current == first)) {
            first = null;
            last = null;
        }
        else if ((current == first) && (current.next != null)) {
            first = current.next;
            current = null;
        }
        else if (current == last) {
            Entry<E> newLast = first;
            for (int j = 0; j < i - 1; j++) {
                newLast = newLast.next;
            }
            last = newLast;
            current = null;
        } else {
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            current.next = current.next.next;

        }
        size--;

    }

    public void printList() {
        StringBuilder stringBuilder = new StringBuilder();
        Entry<E> current = first;
        for (int i=0;i<size;i++) {
            System.out.println(current.element);
            current = current.next;
        }
    }

    @Override
    public E get(int i) {
        Entry<E> current = first;
        if (i < size) {
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
            return current.get();
        }
        return null;
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
