package module4.t2;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class KeywordsTextTest {
    KeywordsText keywordsText;

    @Test
    public void test() throws IOException {
        keywordsText = new KeywordsText();

        assertEquals("{assert=3, boolean=4, char=1, class=1, for=1, if=1, int=3, public=4, return=2, static=3, void=1, while=2}",
                keywordsText.setUsedKeywordsToFile("textCode.txt"));
    }
}