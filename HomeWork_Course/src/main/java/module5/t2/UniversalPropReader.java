package module5.t2;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.Properties;

/**
 * Задание 2. Обработка исключительных ситуаций
 * Создать “универсальный” класс, позволяющий получить значение из любого
 * properties-файла. Физическое чтение файла должно происходить только один раз.
 * Обработайте следующие исключительные ситуации: нет файла *.properties,
 * нет ключа в properties-файле.
 */
public class UniversalPropReader {

    /**
     *
     * @param key - the key in properties file for which we search the value
     * @param file - the properties file in which we search key
     * @return
     * @throws NotSuchFileException if we didn't find file in specific location
     * @throws NotSuchValueException if we didn't find value in specific properties file
     * @throws IOException for major exceptions of input-output operations
     */
    public String getValueFromPropertiesFile(String key, String file)
            throws NotSuchFileException, NotSuchValueException, IOException {

        Properties properties = new Properties();
        try {
            FileInputStream inputFile = new FileInputStream(file);
            properties.load(inputFile);
        } catch (FileNotFoundException e) {
            throw new NotSuchFileException(file);
        }
        String value = null;
        if ((value = properties.getProperty(key)) == null) {
            throw new NotSuchValueException(value);
        }
        return value;
    }
}
