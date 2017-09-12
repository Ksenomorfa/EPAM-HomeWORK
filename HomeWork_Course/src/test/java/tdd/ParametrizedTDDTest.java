package tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParametrizedTDDTest {

    // tests normal with parameters
    @DisplayName("Factorial tests")
    @ParameterizedTest(name = "result of factorial({0}) should be {1}")
    @CsvSource({"1, 1", "2, 2", "3, 6", "5, 120"})
    void testFactorial(int n, int result) {
        assertEquals(result, ParametrizedTDD.factorial(n));
    }


    @DisplayName("Multiply tests")
    @ParameterizedTest(name = "result of {0}*{1} should be {2}")
    @CsvSource({"1, 2, 2", "1, 3, 3", "0, 1, 0"})
    void testMultiply(int a, int b, int result) {
        assertEquals(result, ParametrizedTDD.multiply(a, b));
    }

    @DisplayName("Division tests")
    @ParameterizedTest(name = "result of {0}/{1} should be {2}")
    @CsvSource({"0, 1, 0", "1, 2, 0.5", "5, 5, 1"})
    void testDivision(int a, int b, double result) {
        assertEquals(result, ParametrizedTDD.division(a, b));
    }

    //generate exception
    @DisplayName("Division exception by zero")
    @Test
    void testDivisionException() {
        assertThrows(ArithmeticException.class,
                () -> ParametrizedTDD.division(100, 0));
    }

    @DisplayName("Factorial exception by overflow")
    @Test
    void testFactorialException() {
        assertThrows(ArithmeticException.class,
                () -> ParametrizedTDD.factorial(100));
    }

    // ignored test
    @Disabled
    void testIgnored() {
        System.out.println("some");
        assertThrows(ArithmeticException.class,
                () -> {
                    double result = ParametrizedTDD.division(100, 0);
                });
    }
}