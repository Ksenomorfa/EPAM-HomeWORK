package module2.t4;

import module2.t2.Chancery;

import java.util.Comparator;

public class PriceComparator implements Comparator<Chancery> {
    @Override
    public int compare(Chancery o1, Chancery o2) {
        return new Double(o1.getPrice()).compareTo(o2.getPrice());
    }
}
