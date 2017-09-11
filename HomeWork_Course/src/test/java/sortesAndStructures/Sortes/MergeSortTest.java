package sortesAndStructures.Sortes;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {
    @Test
    public void testMerge() {
        assertArrayEquals(new int[]{-5,0,1,2,3,4,5}, MergeSort.sort(new int[] {0,-5,1,3,5,4,2}));
        assertArrayEquals(new int[]{0,0,0,0}, MergeSort.sort(new int[] {0,0,0,0}));
    }
}