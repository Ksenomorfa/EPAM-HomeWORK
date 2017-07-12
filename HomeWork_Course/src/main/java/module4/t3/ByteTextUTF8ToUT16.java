package module4.t3;

import java.io.*;

/**
 * Задание 3. Работа с байтовыми и символьными потоками ввода-вывода
 Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8.
 Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.
 */
class ByteTextUTF8ToUT16 {

    /**
     * Method initialize input file and get string from it by  InoutStreamReader in UTF-8
     * @return string contains all lines from file
     * @throws IOException if file path didn't exists
     */
    private String initInputFile() throws IOException {
        StringBuilder stringFromInput = new StringBuilder();
        InputStream file = ByteTextUTF8ToUT16.class.getResourceAsStream("cyrillicUTF-8.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file, "UTF-8"))) {
            String str;
            while ((str=br.readLine())!=null) {
                stringFromInput.append(str).append("\n");
            }
        }
        return stringFromInput.toString();
    }

    /**
     * Method writes string from input to output file in UTF-16
     * @throws IOException if file path didn't exists
     */
    void writeTextToUTF16() throws IOException {
        initInputFile();
        try (OutputStream outputStream = new FileOutputStream("out\\cyrillicUTF-16.txt")) {
            outputStream.write(initInputFile().getBytes("UTF-16"));
        }
    }
}
