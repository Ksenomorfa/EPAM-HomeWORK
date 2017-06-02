package module5.t2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UniversalPropReaderTest {
    UniversalPropReader uni;

    @Before
    public void init() {
        uni = new UniversalPropReader();
    }

    @Test
    public void testOK() throws IOException, NotSuchFileException, NotSuchValueException {
        assertEquals("http://webserver:80/mysql", uni.getValueFromPropertiesFile
                ("server", ".\\src\\main\\resources\\module5.properties"));
        assertEquals("root", uni.getValueFromPropertiesFile
                ("login", ".\\src\\main\\resources\\module5.properties"));
        assertEquals("root", uni.getValueFromPropertiesFile
                ("pass", ".\\src\\main\\resources\\module5.properties"));
    }

    @Test(expected = NotSuchValueException.class)
    public void testExceptionValue() throws IOException, NotSuchFileException, NotSuchValueException {
        assertEquals("root", uni.getValueFromPropertiesFile
                ("password", ".\\src\\main\\resources\\module5.properties"));
    }

    @Test(expected = NotSuchFileException.class)
    public void testExceptionFile() throws IOException, NotSuchFileException, NotSuchValueException {
        assertEquals("root", uni.getValueFromPropertiesFile
                ("pass", ".\\src\\main\\resources\\module6.properties"));
    }

    //If we have exception on file, we don't go forward with trying to get property, it will be null
    @Test(expected = NotSuchFileException.class)
    public void testExceptionFileValue() throws IOException, NotSuchFileException, NotSuchValueException {
        assertEquals("root", uni.getValueFromPropertiesFile
                ("password", ".\\src\\main\\resources\\module6.properties"));
    }
}