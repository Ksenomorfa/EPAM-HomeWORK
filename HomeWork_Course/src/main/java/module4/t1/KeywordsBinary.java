package module4.t1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class KeywordsBinary {
    private String stringFromInput = "";

    private void initInput(String file) throws IOException {
        Class<KeywordsBinary> clss = KeywordsBinary.class;
        try(InputStream inputStream = clss.getResourceAsStream(file)) {
            try(ByteArrayOutputStream result2 = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer))!=-1) {
                    result2.write(buffer,0,length);
                }
                stringFromInput = result2.toString("UTF-8");
            }
        }
    }

    private List getListOfKeyWordsFromFile() throws IOException {
        String stringFromKeywordsFile = new String(Files.readAllBytes(Paths.get((".\\src\\main\\resources\\module4\\keywords.txt"))));
        List<String> listOfKeyWords = new ArrayList<>();
        Collections.addAll(listOfKeyWords, stringFromKeywordsFile.split("\\s+"));
        return listOfKeyWords;
    }

    private Map getUsedKeywordsFromInput() throws IOException {
        TreeMap<String,Integer> mapOfUsedKeywords = new TreeMap<>();
        String [] tempStringArray =  stringFromInput.split("\\s+|\\({1}");
        List listOfUsedKeywords = getListOfKeyWordsFromFile();
        for (String str:tempStringArray) {
            if (listOfUsedKeywords.contains(str)) {
                if (mapOfUsedKeywords.containsKey(str)) {
                    mapOfUsedKeywords.put(str, mapOfUsedKeywords.get(str) +1);
                }
                else mapOfUsedKeywords.put(str,1);
            }
        }
        return mapOfUsedKeywords;
    }

    String setUsedKeywordsToFile (String file) throws IOException {
        initInput(file);
        try(OutputStream outputStream = new FileOutputStream("out\\outputM41.txt")) {
            outputStream.write(getUsedKeywordsFromInput().toString().getBytes("UTF-8"));
            outputStream.write("\nSize: ".getBytes("UTF-8"));
            outputStream.write(String.valueOf(getUsedKeywordsFromInput().size()).getBytes("UTF-8"));
        }
        return getUsedKeywordsFromInput().toString();
    }
}


