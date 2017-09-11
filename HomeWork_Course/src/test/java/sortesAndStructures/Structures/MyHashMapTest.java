package sortesAndStructures.Structures;

import org.junit.Test;

public class MyHashMapTest {
    @Test
    public void testCreateHashMap() {
        MyHashMap<String, String> map = new MyHashMap<>(6);
        map.put("3","21");
        map.put("4","22");
        map.put("13","23");
        map.put("22","24");
        map.put("31","25");
        System.out.println(map);
        map.remove("4");
        map.put("35","22");
        map.remove("22");
        map.remove("3");
        map.put("4","22");
        System.out.println(map);
    }
}