package module4.t1;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class KeywordsBinaryTest {
    KeywordsBinary keywordsBinary;

    @Test
    public void test() throws IOException {
        keywordsBinary = new KeywordsBinary();

        assertEquals("{static=3, void=1, boolean=4, public=4, assert=3, for=1, char=1, while=2, class=1, if=1, int=3, return=2}",
                keywordsBinary.setUsedKeywordsToFile("binaryCode.txt"));

    }
}