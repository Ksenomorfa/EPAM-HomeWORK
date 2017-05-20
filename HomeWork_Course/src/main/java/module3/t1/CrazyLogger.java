package module3.t1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class with crazy logging: can log whatever you want to log and can not log what you do not want to log.
 * <p>
 * Adding to class can be realized with
 * Enjoy!
 */
public class CrazyLogger {

    private StringBuilder logString;
    private List<StringBuilder> foundStrings = new ArrayList<>();

    /**
     * Instance can be created with constructor by default
     */
    public CrazyLogger() {
        logString = new StringBuilder();
    }

    /**
     * You can give him an existing StringBuilder to create new CrazyLogger.
     *
     * @param logString
     */
    public CrazyLogger(StringBuilder logString) {
        this.logString = logString;
    }

    public StringBuilder getLogString() {
        return logString;
    }

    public void setLogString(StringBuilder logString) {
        this.logString = logString;
    }

    /**
     * Methos that can search in existing logger with 2 matchers: first patternString is checking if we a in right
     * format of string, and make a group of whole string for next step and second patternSearchingString checks
     * if the searching string is in group of first matcher.
     *
     * @param searchString parameter for searching the string, date and so on.
     * @return list of all found strings
     */
    public List<StringBuilder> findByString(String searchString) {
        foundStrings = new ArrayList<>();
        Pattern patternString = Pattern.compile("((\\d{2}-\\d{2}-\\d{4}\\s:\\s\\d{2}-\\d{2})\\W*\\w*\\r\\n)");
        Matcher matcherString = patternString.matcher(logString);
        Pattern patternSearchingString = Pattern.compile(searchString);
        Matcher matcherSearchingString;
        while (matcherString.find()) {
            matcherSearchingString = patternSearchingString.matcher(matcherString.group());
            if (matcherSearchingString.find()) {
                foundStrings.add(new StringBuilder(matcherString.group()));
            }
        }
        return foundStrings;
    }

    /**
     * Util method for inclass formatting date, if we adding strings to log in program, for right format.
     *
     * @param dateTime is the LocalDateTime instance that we must format
     * @return formatted String we date in format dd-MM-YYYY : HH-mm
     */
    private String formatDate(LocalDateTime dateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.
                ofPattern("dd-MM-YYYY : HH-mm");
        return dateTime.format(dateTimeFormatter);
    }

    /**
     * If we want to add message with Instant time, we can use this method
     *
     * @param string any message of this moment to logging
     */
    public void addMessage(String string) {

        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.systemDefault());
        this.addMessagePrivate(string, dateTime);
    }

    /**
     * If we want to add message with any DateTime, we can use this method
     *
     * @param string   any message of this moment to logging
     * @param dateTime is the LocalDateTime instance
     */

    public void addMessage(String string, LocalDateTime dateTime) {
        this.addMessagePrivate(string, dateTime);
    }

    private void addMessagePrivate(String string, LocalDateTime dateTime) {
        logString.append(formatDate(dateTime));
        logString.append(" - ");
        logString.append(string);
        logString.append("\r\n");
    }

    @Override
    public String toString() {
        return logString.toString();
    }
}