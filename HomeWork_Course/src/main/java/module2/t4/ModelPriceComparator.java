package module2.t4;

import module2.t2.Chancery;
import module2.t2.Employee;

import java.util.Comparator;

public class ModelPriceComparator implements Comparator<Chancery> {
    private final ModelComparator ch1;
    private final PriceComparator ch2;

    ModelPriceComparator(ModelComparator ch1,PriceComparator ch2) {
        this.ch1 = ch1;
        this.ch2 = ch2;
    }

    @Override
    public int compare(Chancery o1, Chancery o2) {
        int res = ch1.compare(o1,o2);
        if (res == 0) {
            return ch2.compare(o1,o2);
        }
        return res;
    }
}
