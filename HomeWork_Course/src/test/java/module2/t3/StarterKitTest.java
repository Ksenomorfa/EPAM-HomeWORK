package module2.t3;

import module2.t2.Eraser;
import module2.t2.Pen;
import module2.t2.Pencil;
import module2.t2.Ruler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StarterKitTest {
    Pencil pencil;
    Ruler ruler;
    Eraser eraser;
    Pen pen;

    @Before
    public void init() {
        pencil = new Pencil("Erich", "X123", 12.43);
        ruler = new Ruler("Factic", "23UY2", 10.20);
        eraser = new Eraser("Factic", "2T42-2", 4.50);
        pen = new Pen("Fabio", "26782", 4.43);
    }

    @Test
    public void testStarterKit() {
        StarterKit starterKit = new StarterKit(pen, pencil, ruler, eraser);
        System.out.println(starterKit);
    }
}