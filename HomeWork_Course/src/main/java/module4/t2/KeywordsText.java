package module4.t2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class KeywordsText {

    private String stringFromInput = "";

    private void initInput(String file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader buf = new BufferedReader(new FileReader(".\\src\\main\\resources\\module4\\t2\\textCode.txt"))) {
            String str;
            while ((str = buf.readLine()) != null) {
                stringBuilder.append(str);
            }
            stringFromInput = stringBuilder.toString();
        }
    }

    private List getListOfKeyWordsFromFile() throws IOException {
        StringBuilder stringFromKeywordsFile = new StringBuilder();
        try (BufferedReader buf = new BufferedReader(new FileReader(".\\src\\main\\resources\\module4\\keywords.txt"))) {
            String str;
            while ((str = buf.readLine()) != null) {
                stringFromKeywordsFile.append(str).append("\n");
            }
        }
        List<String> listOfKeyWords = new ArrayList<>();
        Collections.addAll(listOfKeyWords, stringFromKeywordsFile.toString().split("\\s+"));
        return listOfKeyWords;
    }

    private Map getUsedKeywordsFromInput() throws IOException {
        TreeMap<String, Integer> mapOfUsedKeywords = new TreeMap<>();
        String[] tempStringArray = stringFromInput.split("\\s+|\\({1}");
        List listOfKeywords = getListOfKeyWordsFromFile();
        for (String str : tempStringArray) {
            if (listOfKeywords.contains(str)) {
                if (mapOfUsedKeywords.containsKey(str)) {
                    mapOfUsedKeywords.put(str, mapOfUsedKeywords.get(str) + 1);
                } else mapOfUsedKeywords.put(str, 1);
            }
        }
        return mapOfUsedKeywords;
    }

    String setUsedKeywordsToFile(String file) throws IOException {
        initInput(file);
        try (FileWriter fileOutput = new FileWriter("out\\outputM42.txt")) {
            fileOutput.write(getUsedKeywordsFromInput().toString());
            fileOutput.write("\nSize: ");
            fileOutput.write(String.valueOf(getUsedKeywordsFromInput().size()));
        }
        return getUsedKeywordsFromInput().toString();
    }
}
