package sortesAndStructures.Sortes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest {
    SelectionSort s;

    @Before
    public void init() {
        s = new SelectionSort();
    }

    @Test
    public void sort7elements() throws Exception {
        int[] srcArray = {1, 2, 3, 4, 5, 6, 7};
        int[] sortedArray = s.sort(srcArray);
        final int[] resultArray = {7, 6, 5, 4, 3, 2, 1};

        assertArrayEquals(resultArray, sortedArray);
    }

    @Test
    public void sort8elements() throws Exception {
        int[] srcArray = {1, 2, 3, 4, 5, 6, 8, 7};
        int[] sortedArray = s.sort(srcArray);
        final int[] resultArray = {8, 7, 6, 5, 4, 3, 2, 1};

        assertArrayEquals(resultArray, sortedArray);
    }

    @Test
    public void sortElements() throws Exception {
        int[] srcArray = {};
        int[] sortedArray = s.sort(srcArray);
        final int[] resultArray = {};

        assertArrayEquals(resultArray, sortedArray);

    }
}