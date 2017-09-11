package tdd;

import java.util.Iterator;
import java.util.List;

public class Range {
    private long lowerBound;
    private long upperBound;

    public Range(long lowerBound, long upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    boolean isBefore(Range otherRange) {
        return this.upperBound < otherRange.lowerBound;
    }

    boolean isAfter(Range otherRange) {
        return this.lowerBound > otherRange.upperBound;
    }

    boolean isConcurrent(Range otherRange) {
        return ((otherRange.lowerBound <= this.upperBound) && (otherRange.upperBound > this.lowerBound));
    }

    long getLowerBound() {
        return lowerBound;
    }

    long getUpperBound() {
        return upperBound;
    }

    boolean contains(long value) {
        return (value >= lowerBound && value <= upperBound);
    }

    //TODO: create list and iterator
    List<Long> asList() {
        return null;
    }

    Iterator<Long> asIterator() {
        return null;
    }

}
