package module5.t2;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UniversalPropReaderTest {
    UniversalPropReader uni;

    @Before
    public void init() throws IOException, NotSuchFileException {
        uni = new UniversalPropReader(".\\src\\main\\resources\\module5.properties");
        uni.readPropertiesFromFile();
    }

    @Test
    public void testOK() throws NotSuchValueException {
        assertEquals("http://webserver:80/mysql", uni.getValueFromPropertiesFile("server"));
        assertEquals("root", uni.getValueFromPropertiesFile("login"));
        assertEquals("root", uni.getValueFromPropertiesFile("pass"));
    }

    @Test(expected = NotSuchValueException.class)
    public void testExceptionValue() throws NotSuchValueException {
        assertEquals("root", uni.getValueFromPropertiesFile("password"));
    }

    @Test(expected = NotSuchFileException.class)
    public void testExceptionFile() throws IOException, NotSuchFileException {
        uni = new UniversalPropReader(".\\src\\main\\resources\\module7.properties");
        uni.readPropertiesFromFile();
    }

    //If we have exception on file, we don't go forward with trying to get property, it will be null
    @Test(expected = NotSuchFileException.class)
    public void testExceptionFileValue() throws IOException, NotSuchFileException, NotSuchValueException {
        uni = new UniversalPropReader(".\\src\\main\\resources\\module7.properties");
        uni.readPropertiesFromFile();
        assertEquals("root", uni.getValueFromPropertiesFile("password"));
    }
}