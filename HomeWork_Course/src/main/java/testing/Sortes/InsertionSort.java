package testing.Sortes;

public class InsertionSort {
    static int[] sort(int a[]) {
        int value;
        int j;
        for (int i = 1; i < a.length; i++) {
            value = a[i];
            for (j = i - 1; (j >=0) && (a[j] > value); j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = value;
        }
        return a;
    }
}
