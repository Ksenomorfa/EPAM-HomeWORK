package testing;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlImage {
    public String urlConnectionReader() throws IOException {
        URL url = new URL("http://horstmann.com");
        URLConnection urlConnection = url.openConnection();
        StringBuilder string = new StringBuilder();
        final int bufferSize = 4096;
        final char[] buffer = new char[bufferSize];
        try (InputStreamReader reader = new InputStreamReader(urlConnection.getInputStream())) {
            while (reader.ready()) {
                int rsz = reader.read(buffer, 0, buffer.length);
                string.append(buffer, 0, rsz);
            }
        }
        List list = getImageAddresses(string.toString(), url);
        getImagesFromURL(list, url);
        return string.toString();
    }

    public List<String> getImageAddresses(String inputString, URL url) {
        List<String> imagesList = new ArrayList<>();
        Pattern pattern = Pattern.compile("<img.*(src=\")(.*\\.(gif|jpg))");
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            imagesList.add(matcher.group(2));
        }
        return imagesList;
    }

    public void getImagesFromURL(List<String> list, URL url) throws IOException {
        for (String string : list) {
            URL urlPicture = new URL("http://" + url.getHost() + "/" + string);
            URLConnection urlConnection = urlPicture.openConnection();
            try (InputStream reader = urlConnection.getInputStream()) {
                try (ByteArrayOutputStream result2 = new ByteArrayOutputStream()) {
                    File pictureName = new File(string);
                    OutputStream outputStream = new FileOutputStream(pictureName);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = reader.read(buffer))!=-1) {
                        result2.write(buffer,0,length);
                    }
                    result2.writeTo(outputStream);
                }
            }
        }
    }
}

