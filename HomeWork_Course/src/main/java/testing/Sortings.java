package testing;

public class Sortings {
    public int [] sort (int [] mass) {

        int temp;
        int [] sortedMass = mass.clone();

        for (int i = 0; i < sortedMass.length; i++) {
            int max = i;
            for (int j = i+1; j < sortedMass.length; j++) {
                // find maximal element
                if (sortedMass[max] < sortedMass[j]) {
                    max = j;
                }
             }
            temp = sortedMass[i];
            sortedMass[i] = sortedMass[max];
            sortedMass[max] = temp;
        }
        return sortedMass;
    }

}
