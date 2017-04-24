package module1.t5;

public class MatrixZeroOne {

    /**
     * Method is printing matrix size n*n elements, where elements on both
     * diagonals = 1 and other elements = 0
     *
     * @param n - size of matrix
     */

    private static void printMatrix(int n) {
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
                if ((i == j) || (i == n - j - 1)) {
                    matrix[i][j] = 1;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMatrix(14);
    }
}
