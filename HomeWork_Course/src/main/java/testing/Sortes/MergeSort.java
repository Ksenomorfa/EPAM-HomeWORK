package testing.Sortes;

public class MergeSort {
    static int[] sort(int a[]) {
        int aux[] = new int[a.length];
        sortInner(a, aux, 0, a.length-1);
        return a;
    }

    private static void sortInner(int[] a, int aux[], int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sortInner(a, aux, lo, mid);
        sortInner(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int a[], int aux[], int lo, int mid, int hi) {
        System.arraycopy(a, lo, aux, lo, hi - lo +1);
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
