package module1.t2;

public class Sequence {

    /**
     * @param e    - epsilon in sequence, for being min index, aN must be < e
     * @param size - number of elements in sequence
     * @return min index of element in sequence for which the condition
     * aN < e is fulfilled
     */
    private static int calcSequence(double e, int size) {
        double[] massive = new double[size];
        int min = size;
        for (int i = 1; i < size; i++) {
            massive[i] = 1 / ((i + 1.0) * (i + 1.0));
            System.out.println("a[" + i + "] = " + massive[i]);

        }
        for (int i = 1; i < size; i++) {
            if (massive[i] < e) {
                min = i;
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        double e = 0.0002;
        int n = 100;
        System.out.println("Min element: " + calcSequence(e, n));

    }
}
