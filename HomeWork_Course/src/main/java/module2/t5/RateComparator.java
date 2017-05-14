package module2.t5;

import java.util.Comparator;

public class RateComparator implements Comparator<Result> {
    @Override
    public int compare(Result o1, Result o2) {
        return ~o1.getRate().toString().compareToIgnoreCase(o2.getRate().toString());
    }
}
