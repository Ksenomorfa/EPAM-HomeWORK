package module3.t2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ResourceBundleAppTest {
    private static ResourceBundleApp app;
    private static ResourceBundle bundleSettings;

    @Before
    public void init() {
        app = new ResourceBundleApp();
    }

    @Test
    public void testPrintBundlesQuestionsRU() {
        Locale.setDefault(Locale.forLanguageTag("ru-RU"));
        app = new ResourceBundleApp(Locale.getDefault());

        assertEquals(Arrays.toString(app.getListBundleQuestions().toArray()),
                "[1. Как называется наша планета?, " +
                        "2. Где мы сейчас находимся?, " +
                        "3. Какой класс звезды у нашего Солнца?, " +
                        "4. Как называется наша Галактика?, " +
                        "5. Какая галактика ближайшая к нашей?]");
    }

    @Test
    public void testPrintBundlesQuestionsEN() {
        Locale.setDefault(Locale.forLanguageTag("en-US"));
        app = new ResourceBundleApp(Locale.getDefault());

        assertEquals(Arrays.toString(app.getListBundleQuestions().toArray()),
                "[1. What is the name of our planet?, " +
                        "2. Where are we now?, " +
                        "3. What it the class of our Sun?, " +
                        "4. What is the name of our Galaxy?, " +
                        "5. What is tne nearest galaxy to our Galaxy?]");

    }

    @Test
    public void testSelectQuestions() {
        testPrintBundlesQuestionsEN();
        assertEquals(app.getBundleAnswer("1"), "Earth.");
        assertEquals(app.getBundleAnswer("2"), "In Saint-Petersburg.");
        assertEquals(app.getBundleAnswer("3"), "Class G2.");
        assertEquals(app.getBundleAnswer("4"), "Milky Way.");
        assertEquals(app.getBundleAnswer("5"), "Andromeda.");

    }

    public static void main(String... args) {
        //Create bundle for settings: all string in interface will be shown in locale,
        // that user will choose.
        bundleSettings = ResourceBundle.getBundle("settings", Locale.getDefault());
        System.out.println(bundleSettings.getString("current") + Locale.getDefault());

        //Request for changing locale, if needed
        System.out.println(bundleSettings.getString("change"));
        Scanner scanner = new Scanner(System.in);
        String locale = scanner.nextLine();

        switch (locale) {
            case "en_US":
                Locale.setDefault(Locale.forLanguageTag("en-US"));
                break;
            case "ru_RU":
                Locale.setDefault(Locale.forLanguageTag("ru-RU"));
                break;
        }
        //Reset settings to selected locale
        bundleSettings = ResourceBundle.getBundle("settings", Locale.getDefault());

        //Creating app with selected locale
        app = new ResourceBundleApp(Locale.getDefault());
        app.printBundleQuestions();

        //Select questions by user or quit if symbol is not from list of questions
        System.out.println(bundleSettings.getString("select"));
        String key;
        while (scanner.hasNextLine()) {
            key = scanner.nextLine();
            if (app.getBundleQuestions().containsKey(key)) {
                System.out.println(app.getBundleAnswer(key));
            } else break;
        }
    }
}
