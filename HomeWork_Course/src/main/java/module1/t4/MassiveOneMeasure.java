package module1.t4;

import java.util.Random;

public class MassiveOneMeasure {

    /** Calculate max number of (a1+a2,a3+a4,...,an+an+1) for even number and
     * of(a1+a2,a3+a4,...,an+an+1, an+2) for odd number
     * @param size    - size of one measuring massive
     * @param massive - massive containing numbers to calculate
     *
     */
    private static void maxInMassive(int size, int[] massive) {
        int max = 0;
        int index = 0;
        if (size%2==0) {
            for (int i = 0; i < (size - 1); i=i+2) {
                if ((massive[i] + massive[i + 1]) > max) {
                    max = massive[i] + massive[i + 1];
                    index = i;
                }
            }
        }
        else {
            max = massive[size-1];
            for (int i = 0; i < (size - 2); i=i+2) {
                if ((massive[i] + massive[i + 1]) > max) {
                    max = massive[i] + massive[i + 1];
                    index = i;
                }
            }
        }
        System.out.println("Max for i[" + index + "] + i[" + (index+1) + "] = " + max);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(25);
        System.out.println("n = " + n);

        int[] massive = new int[n];
        for (int i = 0; i < n; i++) {
            massive[i] = random.nextInt(15);
            System.out.println("i[" + i + "] = " + massive[i]);
        }
        maxInMassive(n, massive);

        maxInMassive(5, new int []{1,2,3,5,10}); //10
        maxInMassive(6, new int []{1,2,3,4,5,6}); //11
    }
}
