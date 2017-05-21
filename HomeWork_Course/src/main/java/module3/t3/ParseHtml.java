package module3.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание 3. Регулярные выражения
 * Необходимо определить в тексте статьи* (html-файл), ссылается ли автор на рисунки
 * последовательно или нет, а также выделить все предложения, в которых встречаются
 * ссылки на рисунки. Для разбора текста использовать регулярные выражения.
 * Статья приведена в приложении к данному файлу заданий.
 */

public class ParseHtml {

    public static void main(String[] args) throws URISyntaxException {
        StringBuilder wholeFile = readFile();
        checkImagesUsage(wholeFile);
        findStringsWithImages(wholeFile);
    }

    private static void findStringsWithImages(StringBuilder wholeFile) {
        //This is awful. Strings that contains only link on images aren't match pattern
        Pattern patternString = Pattern.compile("[А-Я][^\\.?]*(\\(?[Рр]ис[унк]*.?\\s*(\\d{1,2}),?\\s?[и-]?\\s?" +
                "(\\d{1,2})?[абвгд]?\\,?[абвгд]*\\)*)[\\sё\\(<sub>)?«»,а-яА-ЯC0-9\\-\\–]+(\\(?[Рр]ис[унк]" +
                "*\\s*(\\d{1,2}),?\\s?[и-]?\\s?(\\d{1,2})?\\))*[^\\.?]*([,.\\s0-9\\)а-я«»]*)");
        Matcher matcherString = patternString.matcher(wholeFile);
        List<String> listOfStrings = new ArrayList<>();
        while(matcherString.find()) {
            listOfStrings.add(matcherString.group());
        }
        System.out.println("Список строк со ссылками на рисунки:");
        print(listOfStrings);
    }

    private static void checkImagesUsage(StringBuilder wholeFile) {
        Pattern patternImage = Pattern.compile("\\(?[Рр]ис[унк]*.?\\s*(\\d{1,2}),?\\s?[и-]?\\s?(\\d{1,2})?[абвгд]?\\,?[абвгд]*\\)*");
        Matcher matcherImage = patternImage.matcher(wholeFile);
        List<Integer> listOfImages = new ArrayList<>();

        while(matcherImage.find()) {
                if(matcherImage.group(1)!=null) listOfImages.add(Integer.parseInt(matcherImage.group(1)));
                if(matcherImage.group(2)!=null) listOfImages.add(Integer.parseInt(matcherImage.group(1)));
        }
        System.out.println(listOfImages);

        Integer[] arrayOfImages = listOfImages.toArray(new Integer[listOfImages.size()]);

        for(int i=0;i<arrayOfImages.length-1;i++) {
            if(arrayOfImages[i]>arrayOfImages[i+1]) {
                System.out.println("Порядок ссылок на рисунки = \"разнобой\"");
                break;
            }
            System.out.println("Порядок рисунков нормальный.");
        }
    }

    private static InputStreamReader getResource() throws UnsupportedEncodingException {
        Class<ParseHtml> cls = ParseHtml.class;
        return new InputStreamReader(cls.getResourceAsStream("mod3task3.html"),"windows-1251");
    }

    private static StringBuilder readFile() {
        StringBuilder read = new StringBuilder();
        try (BufferedReader br = new BufferedReader(getResource())) {
            while (br.ready()) {
                String string = br.readLine();
                read.append(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return read;
    }

    private static void print(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}

