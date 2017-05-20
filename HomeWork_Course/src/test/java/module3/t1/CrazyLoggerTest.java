package module3.t1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class CrazyLoggerTest {
    CrazyLogger crazyLogger;
    CrazyLogger crazyLoggerWithStringBuilder;

    @Before
    public void init() {
        crazyLogger = new CrazyLogger();
    }

    @Test
    public void testAddMessagesToLog() {
        LocalDateTime dateTime = LocalDateTime.of(2017, Month.MAY, 20, 19, 24);
        LocalDateTime dateTime2 = LocalDateTime.of(2017, Month.MAY, 22, 19, 24);
        crazyLogger.addMessage("message", dateTime);
        crazyLogger.addMessage("message2", dateTime);
        crazyLogger.addMessage("message3", dateTime2);
        crazyLogger.addMessage("message4", dateTime);

        assertEquals(crazyLogger.toString(),
                        "20-05-2017 : 19-24 - message\r\n" +
                        "20-05-2017 : 19-24 - message2\r\n" +
                        "22-05-2017 : 19-24 - message3\r\n" +
                        "20-05-2017 : 19-24 - message4\r\n");
    }

    @Test
    public void testAddExistingStringToLogger() {
        StringBuilder stringBuilder = new StringBuilder(
                "20-05-2017 : 19-24 - message\r\n" +
                "20-05-2017 : 19-24 - message2\r\n" +
                "22-05-2017 : 19-24 - message in this\r\n");
        crazyLoggerWithStringBuilder = new CrazyLogger(stringBuilder);
        assertEquals(crazyLoggerWithStringBuilder.toString(),
                        "20-05-2017 : 19-24 - message\r\n" +
                        "20-05-2017 : 19-24 - message2\r\n" +
                        "22-05-2017 : 19-24 - message in this\r\n");
    }

    @Test
    public void testFindMessagesByString() {
        testAddMessagesToLog();
        assertEquals(crazyLogger.findByString("message4").toString(),
                "[20-05-2017 : 19-24 - message4\r\n]");
        assertEquals(crazyLogger.findByString("message").toString(),
                "[20-05-2017 : 19-24 - message\r\n, " +
                "20-05-2017 : 19-24 - message2\r\n, " +
                "22-05-2017 : 19-24 - message3\r\n, " +
                "20-05-2017 : 19-24 - message4\r\n]");
        assertEquals(crazyLogger.findByString("22-05-2017").toString(),
                "[22-05-2017 : 19-24 - message3\r\n]");
    }
}