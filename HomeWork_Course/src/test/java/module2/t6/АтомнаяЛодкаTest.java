package module2.t6;

import org.hamcrest.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class АтомнаяЛодкаTest {

    @Test
    public void плыть()  {
        АтомнаяЛодка атомнаяЛодка1 = new АтомнаяЛодка();
        атомнаяЛодка1.плыть();
        assertEquals(100,атомнаяЛодка1.сколькоЕдем());
        assertThat(атомнаяЛодка1.сколькоЕдем(),is(100));
    }

    @Test
    public void остановиться()  {
        АтомнаяЛодка атомнаяЛодка1 = new АтомнаяЛодка();
        атомнаяЛодка1.плыть();
        атомнаяЛодка1.остановиться();
        assertEquals(0,атомнаяЛодка1.сколькоЕдем());
    }
}