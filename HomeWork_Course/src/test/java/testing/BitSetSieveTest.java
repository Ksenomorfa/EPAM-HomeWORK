package testing;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitSetSieveTest {
    @Test
    public void testPrimes() {
        BitSetSieve bitSetSieve = new BitSetSieve();
        System.out.println(bitSetSieve.printPrimeNumbers(1_000_000));
        assertTrue(bitSetSieve.getBit(2017));
        System.out.println(bitSetSieve.getSizeBitTrue());
    }
}