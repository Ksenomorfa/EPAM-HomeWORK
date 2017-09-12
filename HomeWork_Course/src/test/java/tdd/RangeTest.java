package tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

    private static Range range1;
    private static Range range2;
    private static Range range3;
    private static Range range4;
    private static Range range5;
    private static Range range6;

    private static long value1;
    private static long value2;
    private static long value3;

    @BeforeAll
    static void setUp() throws Exception {
        range1 = new Range(10, 30);
        range2 = new Range(11, 15);
        range3 = new Range(-1, 20);
        range4 = new Range(0, 1);
        range5 = new Range(0, 1);
        range6 = new Range(0, 10, 3);

        value1 = 10;
        value2 = 20;
        value3 = 30;
    }

    @Test
    void isBefore() throws Exception {
        assertTrue(range4.isBefore(range2));
        assertFalse(range4.isBefore(range3));
        assertTrue(range4.isBefore(range1));
        assertFalse(range2.isBefore(range3));
        assertFalse(range4.isBefore(range5));
    }

    @Test
    void isAfter() throws Exception {
        assertTrue(range2.isAfter(range4));
        assertTrue(range1.isAfter(range4));
        assertFalse(range2.isAfter(range3));
        assertFalse(range4.isAfter(range5));
    }

    @Test
    void isConcurrent() throws Exception {
        assertTrue(range4.isConcurrent(range5));
        assertTrue(range5.isConcurrent(range4));
        assertTrue(range5.isConcurrent(range3));
        assertFalse(range1.isConcurrent(range4));
        assertTrue(range2.isConcurrent(range3));
    }

    @Test
    void getLowerBound() throws Exception {
        assertEquals(10, range1.getLowerBound());
        assertEquals(11, range2.getLowerBound());
        assertEquals(-1, range3.getLowerBound());
        assertEquals(0, range4.getLowerBound());
    }

    @Test
    void getUpperBound() throws Exception {
        assertEquals(30, range1.getUpperBound());
        assertEquals(15, range2.getUpperBound());
        assertEquals(20, range3.getUpperBound());
        assertEquals(1, range4.getUpperBound());
    }

    @Test
    void contains() throws Exception {
        assertFalse(range4.contains(value1));
        assertFalse(range2.contains(value1));
        assertFalse(range2.contains(value2));
        assertTrue(range3.contains(value1));
        assertFalse(range3.contains(value3));
    }

    @Test
    void asList() throws Exception {
        assertEquals(Arrays.asList(10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L,
                20L, 21L, 22L, 23L, 24L, 25L, 26L, 27L, 28L, 29L, 30L),
                range1.asList());

        assertEquals(Arrays.asList(0L, 1L),
                range4.asList());

        assertEquals(Arrays.asList(0L, 3L, 6L, 9L, 10L),
                range6.asList());
    }

    @Test
    void asIterator() throws Exception {
        Iterator<Long> iterator = range1.asIterator();
        List<Long> expected = new ArrayList<>();
        while (iterator.hasNext()) {
            expected.add(iterator.next());
        }
        assertEquals(Arrays.asList(10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L,
                20L, 21L, 22L, 23L, 24L, 25L, 26L, 27L, 28L, 29L, 30L),
                range1.asList());

    }

}