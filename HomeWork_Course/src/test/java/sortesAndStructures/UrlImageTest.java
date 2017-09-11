package sortesAndStructures;

import org.junit.Test;

import java.io.IOException;

public class UrlImageTest {
    @Test
    public void testReading() throws IOException {
        UrlImage urlImage = new UrlImage();
        System.out.println(urlImage.readImageFilesFromURL("horstmann.com"));
    }
}