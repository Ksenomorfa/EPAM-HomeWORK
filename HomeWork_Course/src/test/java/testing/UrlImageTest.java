package testing;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class UrlImageTest {
    @Test
    public void testReading() throws IOException {
        UrlImage urlImage = new UrlImage();
        System.out.println(urlImage.urlConnectionReader());

    }


}