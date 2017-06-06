package module6.t2;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UniversalPropReaderV2Test {
    UniversalPropReaderV2 uni;

    @Before
    public void init() throws IOException {
        uni = new UniversalPropReaderV2(".\\src\\main\\resources\\module6.properties");
        uni.readPropertiesFromFile();
    }

    @Test
    public void testOK() throws IOException {
        assertEquals("http://webserver:80/mysql", uni.getValueFromPropertiesFile("server"));
        assertEquals("root", uni.getValueFromPropertiesFile("login"));
        assertEquals("root", uni.getValueFromPropertiesFile("pass"));
        assertNotEquals("root", uni.getValueFromPropertiesFile("password"));
    }
}