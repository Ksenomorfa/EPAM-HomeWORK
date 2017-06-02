package testing;

import java.util.BitSet;

public class BitSetSieve {
    BitSet bitSet = new BitSet();

    public String printPrimeNumbers(int lastNumber) {
        bitSet.set(1,lastNumber,true);
        for (int i = 2; i < Math.sqrt(lastNumber); i++) {
            for (int j = i*2; j < lastNumber; j=j+i) {
                bitSet.clear(j);
            }
        }
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < lastNumber; i++) {
            if (bitSet.get(i)) {
                string.append(i).append("\n");
            }
        }
        return string.toString();
    }
    public boolean getBit(int index) {
        return bitSet.get(index);
    }
    public int getSizeBitTrue() {
        return bitSet.cardinality();
    }
}

