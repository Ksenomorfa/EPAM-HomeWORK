package module4.t1;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class KeywordsBinaryTest {
    KeywordsBinary keywordsBinary;

    @Test
    public void test() throws IOException {
        keywordsBinary = new KeywordsBinary();

        assertEquals("{assert=3, boolean=4, char=1, class=1, for=1, if=1, int=3, public=4, return=2, static=3, void=1, while=2}",
                keywordsBinary.setUsedKeywordsToFile("binaryCode.txt"));
    }
}