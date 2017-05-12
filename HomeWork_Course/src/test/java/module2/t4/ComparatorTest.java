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
        assertEquals("Manufactor: Factic, model: 23UY2, price: 10.2",
                starterKitList.get(0).toString());
        assertEquals("Manufactor: Factic, model: 23UY2, price: 4.5",
                starterKitList.get(1).toString());
        assertEquals("Manufactor: Fabio, model: 26782, price: 4.43",
                starterKitList.get(2).toString());
        assertEquals("Manufactor: Erich, model: X123, price: 12.43",
                starterKitList.get(3).toString());
    }

    @Test
    public void starterKitSortPrice() {
        Collections.sort(starterKitList, priceComparator);
        assertEquals("Manufactor: Fabio, model: 26782, price: 4.43",
                starterKitList.get(0).toString());
        assertEquals("Manufactor: Factic, model: 23UY2, price: 4.5",
                starterKitList.get(1).toString());
        assertEquals("Manufactor: Factic, model: 23UY2, price: 10.2",
                starterKitList.get(2).toString());
        assertEquals("Manufactor: Erich, model: X123, price: 12.43",
                starterKitList.get(3).toString());
    }

    @Test
    public void starterKitSortModelPrice() {
        Collections.sort(starterKitList, modelPriceComparator);
        assertEquals("Manufactor: Factic, model: 23UY2, price: 4.5",
                starterKitList.get(0).toString());
        assertEquals("Manufactor: Factic, model: 23UY2, price: 10.2",
                starterKitList.get(1).toString());
        assertEquals("Manufactor: Fabio, model: 26782, price: 4.43",
                starterKitList.get(2).toString());
        assertEquals("Manufactor: Erich, model: X123, price: 12.43",
                starterKitList.get(3).toString());    }

    public void printCollection(List<Chancery> list) {
        for (Chancery chancery : list) {
            System.out.println(chancery);
        }
    }
}