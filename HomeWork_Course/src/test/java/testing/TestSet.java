package testing;

import java.util.*;

public class TestSet {
    static NavigableSet<Integer> setSorted;

    public static void main(String[] args) {
        Set<Integer> setTree = new TreeSet<>();
        setTree.add(1);
        setTree.add(2);
        setTree.add(1);
        System.out.println("TreeSet:" + setTree); // will be 2 elements

        //In TreeSet we check not equals, but only compare:
        Set<Integer> setTreeCompare = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        setTreeCompare.add(1);
        setTreeCompare.add(2);
        setTreeCompare.add(1);
        System.out.println("TreeSetCompare:" + setTreeCompare); // will be 1 element

        Set<Integer> setHash = new HashSet<>();
        setHash.add(1);
        setHash.add(2);
        setHash.add(1);
        System.out.println("HashSet:" + setHash); // will be 2 elements

        setSorted = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            setSorted.add(i);
        }
        System.out.println("Navigable fot Tree Set: " + TestSet.getNextElement(5));

        Set<Integer> setLinkedHash = new LinkedHashSet<>();
        setLinkedHash.add(2);
        setLinkedHash.add(1);
        setLinkedHash.add(1);
        System.out.println("LinkedHashSet:" + setLinkedHash); // will be 2 elements, in inserting order
    }

    static Integer getNextElement(Integer elem) {
        return setSorted.higher(elem);
    }
}
