package testing.Structures;

import org.junit.Test;

public class MyHashMapTest {
    @Test
    public void testCreateHashMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.delete("key3");
    }
}