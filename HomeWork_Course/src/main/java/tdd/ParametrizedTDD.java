package tdd;

public class ParametrizedTDD {

    public static long factorial(long n) {
        long factorial = n;
        for (long i = (n - 1); i > 1; i--) {
            factorial = factorial * i;
            if (factorial < 0) {
                throw new ArithmeticException();
            }
        }
        return factorial;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double division(int dividend, int divider) {
        if (divider == 0) {
            throw new ArithmeticException();
        }
        return (double) dividend / divider;
    }
}
