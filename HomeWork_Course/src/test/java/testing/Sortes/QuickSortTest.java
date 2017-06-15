package testing.Sortes;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void testQuick() {
        assertArrayEquals(new int[]{-5,0,1,2,3,4,5}, QuickSort.sort(new int[] {0,-5,1,3,5,4,2}));
        assertArrayEquals(new int[]{0,0,0,0}, QuickSort.sort(new int[] {0,0,0,0}));
    }

}