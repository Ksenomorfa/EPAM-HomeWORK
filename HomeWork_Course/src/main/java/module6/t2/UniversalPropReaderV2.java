package module6.t2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/* Задание 2. Использование Map
Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
Физическое чтение файла должно происходить только один раз. Результаты чтения храните в коллекции типа Map.

Ответьте на вопрос: как ведет себя map-коллекция если в нее добавить элемент с ключом,
который уже присутствует? -
Ответ: если значение value для этого ключа совпадает, то ничего не меняется, если не совпадает -
значение перезаписывается.
*/
public class UniversalPropReaderV2 {
    /**
     * @param key  - the key in properties file for which we search the value
     * @param file - the properties file in which we search key
     * @return String of value for key
     */
    private HashMap<String, String> propertiesMap = new HashMap<>();
    ;
    private String fileToRead;

    public UniversalPropReaderV2(String file) {
        fileToRead = file;
    }

    public void readPropertiesFromFile() throws IOException {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileToRead))) {
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 0) continue;
                if (line.charAt(0) == '#') continue;
                int delimPosition = line.indexOf("=");
                String keyProp = line.substring(0, delimPosition - 1).trim();
                String valueProp = line.substring(delimPosition + 1).trim();
                propertiesMap.put(keyProp, valueProp);
            }
        }
    }

    public String getValueFromPropertiesFile(String key) {
        return propertiesMap.get(key);
    }
}