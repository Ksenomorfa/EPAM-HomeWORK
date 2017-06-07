package testing;
//TODO: remove entry, tests, increase capacity through checking load factor
public class MyHashMap<K, V> {
    Entry<K, V>[] array;
    public final static int DEF_CAPACITY = 16;
    public final static double DEF_LOAD_FACTOR = 0.75;
    int capacity;
    int length;
    double loadFactor;

    public MyHashMap() {
        capacity = DEF_CAPACITY;
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        loadFactor = length / capacity;
        if ((length < capacity) && (loadFactor < DEF_LOAD_FACTOR)) {
            Entry<K, V> entry = new Entry<>(key, value);
            array[entry.hash] = entry;
        } else {
            //Entry<K,V> newArray[] = new Object<>[];
        }
        length++;
    }

    public void delete(K key) {

    }

    public V getValue(K key) {
        V value = null;
        for (int i = 0; i < length; i++) {
            if (array[i].equals(key)) {
                value = array[i].value;
            }
        }
        return value;
    }

    class Entry<K, V> {
        K key;
        V value;
        int hash = (key.hashCode() ^ value.hashCode()) % capacity;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.value = value;
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public String toString() {
            return key + "=" + value;
        }
    }
}
