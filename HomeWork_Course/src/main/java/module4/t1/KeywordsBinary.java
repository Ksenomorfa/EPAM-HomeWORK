package module4.t1;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class KeywordsBinary {

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
    /* I tried few methods to get file in stream
    public InputStream initThroughDirectory() throws FileNotFoundException {
        inputStream = new FileInputStream(".\\src\\main\\resources\\module4\\t1\\binaryCode.txt");
        System.out.println(inputStream);
        return inputStream;
    }

    public String initThroughPaths() throws IOException {
        String string = new String(Files.readAllBytes(Paths.get(".\\src\\main\\resources\\module4\\t1\\binaryCode.txt")));
        return string;
    }
     */

    private List getListOfKeyWordsFromFile() throws IOException {
        String stringFromKeywordsFile = new String(Files.readAllBytes(Paths.get((".\\src\\main\\resources\\module4\\keywords.txt"))));
        List<String> listOfKeyWords = new ArrayList<>();
        Collections.addAll(listOfKeyWords, stringFromKeywordsFile.split("\\s+"));
        return listOfKeyWords;
    }

    private Map getUsedKeywordsFromInput() throws IOException {
        HashMap<String,Integer> mapOfUsedKeywords = new HashMap<>();
        String [] tempStringArray =  stringFromInput.split("\\s+|\\({1}");
        for (String str:tempStringArray) {
            if (getListOfKeyWordsFromFile().contains(str)) {
                if (mapOfUsedKeywords.containsKey(str)) {
                    mapOfUsedKeywords.put(str, mapOfUsedKeywords.get(str) +1);
                }
                else mapOfUsedKeywords.put(str,1);
            }
        }
        return mapOfUsedKeywords;
    }

    public String setUsedKeywordsToFile (String file) throws IOException {
        initInput(file);
        getUsedKeywordsFromInput();
        try(OutputStream outputStream = new FileOutputStream("output.txt")) {
            outputStream.write(getUsedKeywordsFromInput().toString().getBytes("UTF-8"));
        }
        return getUsedKeywordsFromInput().toString();
    }
}


