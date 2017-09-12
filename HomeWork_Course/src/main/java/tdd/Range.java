package tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Range {
    private long lowerBound;
    private long upperBound;
    private long step;
    private List<Long> list = new ArrayList<>();

    public Range(long lowerBound, long upperBound, long step) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.step = step;
        for (long i = lowerBound; i < upperBound + step; i += step) {
            if (i > upperBound) {
                list.add(upperBound);
                break;
            }
            list.add(i);
        }
    }

    public Range(long lowerBound, long upperBound) {
        this(lowerBound, upperBound, 1);
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

    List<Long> asList() {
        return list;
    }

    Iterator<Long> asIterator() {
        return list.iterator();
    }

}
