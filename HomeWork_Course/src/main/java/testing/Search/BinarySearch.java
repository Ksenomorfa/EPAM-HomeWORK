package testing.Search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int a[] = new int[]{1,7,5,3,2,6,3,25,7,10,3,3,3};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(" element:" + searchIter(a,5));
        System.out.println(searchRecurBinary(a,10));
    }

    private static int searchRecurBinary(int[] a, int key) {
        return binarySearch(a,0,a.length-1,key);
    }

    private static int binarySearch(int[] a, int lo, int hi, int key) {
        if (lo>hi) return -1;
        int middle = lo + (hi-lo)/2;
        if (key == a[middle]) return middle;
        else if(key<a[middle]) return binarySearch(a,lo,middle-1,key);
        else return binarySearch(a,middle+1,hi,key);
    }

    private static int searchIter(int[] a, int key) {
        int lo=0;
        int hi = a.length-1;
        while(lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if (key<a[mid]) hi = mid-1;
            else if(key>a[mid]) lo = mid+1;
            else return mid;
        }
        return -1;
    }
}

