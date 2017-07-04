package module5.t1;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileSystemException;

/**
 * Задание 1. Обработка исключительных ситуаций
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой
 * системы,  а также создавать и удалять  текстовые файлы. Для работы с
 * текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл.
 * Требуется определить исключения для каждого слоя приложения
 * и корректно их обработать.
 */
class FileSystemExplorer {

    /**
     * Method observes directory path content
     *
     * @param dirPath Directory for which we want to get list of all catalogs and files in format with \\
     * @return array of File in specified path
     */

    File[] getFilesInPath(String dirPath) {
        File file = new File(dirPath);
        return file.listFiles();
    }

    /**
     * Method creates file in specified directory
     *
     * @param filePath path to file in format with \\
     * @return boolean type true if file is created and false if not.
     * @throws IOException if we have problem with access of reading the filesystem
     */
    boolean createNewTXTFile(String filePath) throws IOException {
        try {
            File file = new File(filePath);
            if (!file.exists()) System.out.println("File is created.");
            else {
                System.out.println("The file is already exists.");
            }
            return file.createNewFile();
        } catch (AccessDeniedException e) {
            System.out.println("You don't have access to create file here: " + filePath);
            throw e;
        } catch (FileSystemException e) {
            System.out.println("We have a problem with file system, please try again, while creating here: " + filePath);
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Method adds data from String to file in specified path. If file isn't exist, it will be created
     *
     * @param filePath path to file in format with \\
     * @param info     in String for adding
     * @throws IOException if we have problem with access of reading the filesystem
     */
    void addTextToFile(String filePath, String info) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) createNewTXTFile(filePath);
        try (FileOutputStream outputStream = new FileOutputStream(file, true)) {
            outputStream.write(info.getBytes("UTF-8"));
        }
    }

    /**
     * Method deletes file in specified path
     *
     * @param filePath path to file in format with \\
     * @return @return boolean type true if file is deleted and false if not.
     * @throws IOException if we have problem with access of reading the filesystem
     */
    boolean deleteFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("The file isn't exists.");
        } else {
            System.out.println("File is deleted.");
        }
        return file.delete();
    }

    /**
     * Method gets data from specified file.
     *
     * @param filePath path to file in format with \\
     * @return String with data
     * @throws IOException if we have problem with access of reading the filesystem
     */
    String getDataFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file), "UTF-8")) {
            while (inputStream.ready()) {
                int rsz = inputStream.read(buffer, 0, buffer.length);
                stringBuilder.append(buffer, 0, rsz);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Method only checks current file system name
     */
    String getCurrentFileSystem() {
        return File.listRoots()[0].getAbsolutePath();
    }
}

