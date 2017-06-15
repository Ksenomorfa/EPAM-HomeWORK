package testing.Sortes;

public class QuickSort {
    static int [] sort(int a[]) {
        doSort(a, 0, a.length - 1);
        return a;
    }

    static void doSort(int a[], int lo, int hi) {
        int i = lo;
        int j = hi;
        int middle = a[i + (j - i) / 2];

        while (i <= j) {
            while (a[i] < middle) i++;
            while (a[j] > middle) j--;
            if (i <= j) {
                if (i < j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
                i++;
                j--;
            }
        }
        if (i < hi) doSort(a, i, hi);
        if (j > lo) doSort(a, lo, j);
    }
}
