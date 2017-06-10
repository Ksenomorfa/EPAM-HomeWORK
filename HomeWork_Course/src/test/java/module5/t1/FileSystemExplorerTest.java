package module5.t1;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FileSystemExplorerTest {
    private FileSystemExplorer fileSystemExplorer;
    private String filePathOK = "\\C:\\Users\\Polina\\Documents\\1.txt";
    private String filePathWrong = "\\C:\\Users\\PolinaWrong\\Documents\\1.txt";

    @Before
    public void init() {
        fileSystemExplorer = new FileSystemExplorer();
    }

    @Test
    public void testGetPathFromFileSystem() {
        System.out.println(Arrays.toString(fileSystemExplorer.getFilesInPath("\\")));
        System.out.println(Arrays.toString(fileSystemExplorer.getFilesInPath("\\Windows")));
        assertArrayEquals(null, fileSystemExplorer.getFilesInPath("\\Windows101"));
    }

    @Test
    public void testCreateFileInUserDocuments() throws IOException {
        assertTrue(fileSystemExplorer.createNewTXTFile(filePathOK));
        assertTrue(fileSystemExplorer.deleteFile(filePathOK));
    }

    @Test (expected = IOException.class)
    public void testCreateFileInUserWrongDocuments() throws IOException {
        assertFalse(fileSystemExplorer.createNewTXTFile(filePathWrong));
    }

    @Test
    public void testCreateFileDuplicate() throws IOException {
        assertTrue(fileSystemExplorer.createNewTXTFile(filePathOK));
        assertFalse(fileSystemExplorer.createNewTXTFile(filePathOK));
        assertTrue(fileSystemExplorer.deleteFile(filePathOK));
    }

    @Test
    public void testCreateFileAndAddDataTest() throws IOException {
        assertTrue(fileSystemExplorer.createNewTXTFile(filePathOK));
        fileSystemExplorer.addTextToFile(filePathOK, "Some Text1\r\n");
        fileSystemExplorer.addTextToFile(filePathOK, "Some Text2\r\n");
        fileSystemExplorer.addTextToFile(filePathOK, "Some Text3");
        String string = "Some Text1\r\nSome Text2\r\nSome Text3";
        assertEquals(string, fileSystemExplorer.getDataFromFile(filePathOK));
        assertTrue(fileSystemExplorer.deleteFile(filePathOK));
    }

    @Test
    public void testPrintCurrDir() throws IOException {
        System.out.println(fileSystemExplorer.getCurrentFileSystem());
    }

}


