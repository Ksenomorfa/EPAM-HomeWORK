package module1.t3;

/**
 * Class for calculation of math function: F(x) = tg(2*x)-3
 */
public class FunctionTangensCalc {

    /**
     * @param start start of segment
     * @param end   end of segment
     * @param step  step of argument calculation
     * @return double massive - result table with two columns: argument and function
     * calculation
     */
    static double[][] calcFunction(float start, float end, float step) {
        int massiveLength = Math.round((end - start) / step);
        double resultTable[][] = new double[massiveLength][2];
        for (int i = 0; i < massiveLength; i++, start = start + step) {
            resultTable[i][0] = start;
            resultTable[i][1] = Math.tan(2 * start) - 3;
        }
        return resultTable;
    }

    /**
     * @param table you must transfer double massive to print it
     */
    public static void printResult(double[][] table) {
        System.out.printf("Argument | F(x) |\n");
        for (double[] aTable : table) {
            System.out.printf("   %5.2f | %5.2f|\n", aTable[0], aTable[1]);
        }
    }

    public static void main(String[] args) {
        printResult(calcFunction(1, 15, 2.2f));
    }
}
