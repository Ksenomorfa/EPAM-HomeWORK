package module3.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Задание 2. Locale и ResourceBundle
 * Разработать приложение, позволяющее по выбору пользователя использовать
 * русский или английский язык, для отображения информации.
 * Приложение должно представлять собой перечень вопросов под номерами
 * (на английском или русском соответственно). Выбрав номер вопроса
 * пользователь может узнать ответ на него.
 * <p>
 * Class contains 2 bundles: for Questions and Answers, the direct to each other by
 * key.
 */
public class ResourceBundleApp {
    private ResourceBundle bundleQuestions;
    private ResourceBundle bundleAnswers;

    /**
     * Constructor without locale, setting it based on default locale.
     */
    public ResourceBundleApp() {
        bundleQuestions = ResourceBundle.getBundle("questions");
        bundleAnswers = ResourceBundle.getBundle("answers");
    }

    /**
     * Constructor to set locale
     *
     * @param locale locale to setting by default for questions and answers bundles
     */
    public ResourceBundleApp(Locale locale) {
        bundleQuestions = ResourceBundle.getBundle("questions", locale);
        bundleAnswers = ResourceBundle.getBundle("answers", locale);
    }

    public ResourceBundle getBundleQuestions() {
        return bundleQuestions;
    }

    public void setBundleQuestions(ResourceBundle bundleQuestions) {
        this.bundleQuestions = bundleQuestions;
    }

    public ResourceBundle getBundleAnswers() {
        return bundleAnswers;
    }

    public void setBundleAnswers(ResourceBundle bundleAnswers) {
        this.bundleAnswers = bundleAnswers;
    }

    /**
     * Method to print questions in "beautiful" form
     */
    public void printBundleQuestions() {
        for (String questions : bundleQuestions.keySet()) {
            System.out.println(questions + ". " + bundleQuestions.getString(questions));
        }
    }

    /**
     * Method formats list of questions to key and it's values from created bundle.
     *
     * @return list of questions with default locale
     */
    public List<String> getListBundleQuestions() {
        List<String> listOfQuestions = new ArrayList<>();
        for (String key : bundleQuestions.keySet()) {
            listOfQuestions.add(key + ". " + bundleQuestions.getString(key));
        }
        return listOfQuestions;
    }

    public String getBundleAnswer(String key) {
        return bundleAnswers.getString(key);
    }

}
