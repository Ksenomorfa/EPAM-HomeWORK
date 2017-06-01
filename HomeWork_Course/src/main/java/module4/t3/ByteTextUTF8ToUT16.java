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
        final int bufferSize = 4096;
        final char[] buffer = new char[bufferSize];
        InputStream file = ByteTextUTF8ToUT16.class.getResourceAsStream("cyrillicUTF-8.txt");
        try (InputStreamReader inputStreamReader = new InputStreamReader(file, "UTF-8")) {
            while (inputStreamReader.ready()) {
                int rsz = inputStreamReader.read(buffer, 0, buffer.length);
                stringFromInput.append(buffer, 0, rsz);
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
