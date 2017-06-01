package module4.t3;

import org.junit.Test;

import java.io.IOException;

public class ByteTextTest {

    @Test
    public void testDecode() throws IOException {
        ByteTextUTF8ToUT16 byteText = new ByteTextUTF8ToUT16();
        byteText.writeTextToUTF16();
    }
}