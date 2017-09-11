package sortesAndStructures.Structures;

import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {
    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry<K, V>[] table;
    private int capacity;
    private int size;
    private float loadFactor;

    static class Entry<K, V> {
        final K key;
        V value;
        Entry next;
        final int hash;

        Entry(int hash, K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final Entry<K, V> getNext() {
            return next;
        }

        public final void setNext(Entry<K, V> next) {
            this.next = next;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof MyHashMap.Entry) {
                MyHashMap.Entry<?, ?> e = (MyHashMap.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

    private int hash(int hashCode) {
        return hashCode % table.length;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "table=" + Arrays.toString(table) +
                '}';
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        table = new Entry[this.capacity];
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public boolean put(K key, V value) {
        if (key == null)
            return false;

        float currentLoadFactor = (float) size / capacity;
        if (currentLoadFactor >= loadFactor) {
            extendCapacity();
        }

        int hash = hash(key.hashCode());
        Entry<K, V> entry = new Entry<>(hash, key, value);

        if (table[hash] == null) {
            table[hash] = entry;
        } else {
            if (key.equals(table[hash].getKey())) table[hash].setValue(value);
            else {
                Entry<K, V> nextEntry = table[hash];
                while (nextEntry.getNext() != null) {
                    nextEntry = nextEntry.getNext();
                }
                nextEntry.setNext(entry);
            }
        }
        size++;
        return true;
    }

    private void extendCapacity() {
        Entry[] tempTable = new Entry[capacity];
        System.arraycopy(table, 0, tempTable, 0, capacity);
        capacity = capacity * 2;
        table = new Entry[capacity];
        for (Entry e : tempTable) {
            if (e != null) {
                this.put((K) e.getKey(), (V) e.getValue());
                if (e.getNext() != null) {
                    Entry<K, V> nextEntry = e;
                    while (nextEntry.getNext() != null) {
                        nextEntry = nextEntry.getNext();
                        this.put((K) nextEntry.getKey(), (V) nextEntry.getValue());
                    }
                }
            }
        }
    }

    public V get(Object key) {
        if (!isEmpty()) {
            int hash = hash(key.hashCode());
            if (key.equals(table[hash].getKey())) {
                return table[hash(key.hashCode())].getValue();
            } else {
                Entry<K, V> nextEntry = table[hash(key.hashCode())];
                while (nextEntry.getNext() != null) {
                    nextEntry = nextEntry.getNext();
                    if (key.equals(nextEntry.getKey())) {
                        return nextEntry.getValue();
                    }
                }
            }
        }
        return null;
    }

    public boolean remove(Object key) {
        int hash = hash(key.hashCode());
        if ((key == null) || (isEmpty()))
            return false;
        else {
            if (table[hash].getNext() == null) {
                if (key.equals(table[hash].getKey())) {
                    table[hash] = null;
                }
                else return false;
            }
            else {
                if (key.equals(table[hash].getKey())) {
                    table[hash] = table[hash].getNext();
                }
                else {
                    Entry<K, V> nextEntry = table[hash];
                    while (nextEntry.getNext() != null) {
                        nextEntry = nextEntry.getNext();
                        if ((nextEntry.getNext().getKey().equals(key))&&(nextEntry.getNext().getNext()!=null)) {
                            nextEntry.setNext(nextEntry.getNext().getNext());
                        }
                        else
                            nextEntry.setNext(null);
                    }
                }
            }
        }
        return true;
    }
}
