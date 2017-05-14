package module2.t5;

import java.util.Comparator;

public class SubjectComparator implements Comparator<Result> {
    @Override
    public int compare(Result o1, Result o2) {
        return o1.getSubject().compareTo(o2.getSubject());
    }
}
