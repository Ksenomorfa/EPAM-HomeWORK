package module2.t5;

import java.util.Comparator;

/**
 * Universal Comparator that can compare object of class Result.
 */
public class BiComparator implements Comparator<Result> {
    private final Comparator<Result> ch1;
    private final Comparator<Result> ch2;

    BiComparator(Comparator<Result> ch1, Comparator<Result> ch2) {
        this.ch1 = ch1;
        this.ch2 = ch2;
    }

    @Override
    public int compare(Result o1, Result o2) {
        int res = ch1.compare(o1, o2);
        if (res == 0) {
            return ch2.compare(o1, o2);
        }
        return res;
    }
}
