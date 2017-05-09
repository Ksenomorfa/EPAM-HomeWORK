package module2.t4;
import module2.t2.*;
import module2.t3.*;

import java.util.Comparator;

public class ModelComparator implements Comparator<Chancery> {
    @Override
    public int compare(Chancery o1, Chancery o2) {
        return o1.getModel().compareToIgnoreCase(o2.getModel());
    }

}
