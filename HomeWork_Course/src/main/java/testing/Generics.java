package testing;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Generics<T> {
    public <E> void test(Collection <E> collection) {
        for(E e:collection)
            System.out.println(e);
    }

    public void test(List<Integer> integerList) {
        for(Integer integer: integerList)
            System.out.println(integer);
    }

    public static void main(String[] args) {
        Generics<?> generics = new Generics<>();
        List<String> list = Arrays.asList("value");
        generics.test(list);
    }
}
