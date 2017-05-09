package module2.t4;

import module2.t2.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ComparatorTest {
    private static final ModelComparator modelComparator = new ModelComparator();
    private static final PriceComparator priceComparator = new PriceComparator();
    private static final ModelPriceComparator modelPriceComparator =
            new ModelPriceComparator(modelComparator, priceComparator);
    List<Chancery> starterKitList;

    @Before
    public void init() {
        starterKitList = new ArrayList<>();
        starterKitList.add(new Pencil("Erich", "X123", 12.43));
        starterKitList.add(new Ruler("Factic", "23UY2", 10.20));
        starterKitList.add(new Eraser("Factic", "23UY2", 4.50));
        starterKitList.add(new Pen("Fabio", "26782", 4.43));
    }

    @Test
    public void starterKitSortModel() {
        Collections.sort(starterKitList, modelComparator);
        printCollection(starterKitList);
    }

    @Test
    public void starterKitSortPrice() {
        Collections.sort(starterKitList, priceComparator);
        printCollection(starterKitList);
    }

    @Test
    public void starterKitSortModelPrice() {
        Collections.sort(starterKitList, modelPriceComparator);
        printCollection(starterKitList);
    }

    public void printCollection(List<Chancery> list) {
        for (Chancery chancery : list) {
            System.out.println(chancery);
        }
    }
}