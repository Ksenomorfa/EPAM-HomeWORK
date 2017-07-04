package module5.t2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
     * @param key  - the key in properties file for which we search the value
     * @param file - the properties file in which we search key
     * @return
     * @throws NotSuchFileException  if we didn't find file in specific location
     * @throws NotSuchValueException if we didn't find value in specific properties file
     * @throws IOException           for major exceptions of input-output operations
     */

    private Properties properties = new Properties();
    private String fileToRead;

    public UniversalPropReader(String file) {
        fileToRead = file;
    }

    public void readPropertiesFromFile() throws NotSuchFileException, IOException {
        try {
            FileInputStream inputFile = new FileInputStream(fileToRead);
            properties.load(inputFile);
        } catch (FileNotFoundException e) {
            NotSuchFileException nsfe = new NotSuchFileException(fileToRead);
            nsfe.printStackTrace();
            throw nsfe;
        }
    }

    public String getValueFromPropertiesFile(String key)
            throws NotSuchValueException {
        String value = null;
        if ((value = properties.getProperty(key)) == null) {
            NotSuchValueException nsve = new NotSuchValueException(value);
            nsve.printStackTrace();
            throw nsve;
        }
        return value;
    }
}
