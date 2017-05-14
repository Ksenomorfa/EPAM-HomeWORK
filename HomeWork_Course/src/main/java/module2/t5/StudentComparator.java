package module2.t5;

import java.util.Comparator;

public class StudentComparator implements Comparator<Result> {
    @Override
    public int compare(Result o1, Result o2) {
        return o1.getStudent().getName().compareToIgnoreCase(o2.getStudent().getName());
    }
}
