package testing;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlImage {
    public String readImageFilesFromURL(String urlString) throws IOException {
        URL url = new URL("http://" + urlString);
        URLConnection urlConnection = url.openConnection();
        StringBuilder string = new StringBuilder();
        try (InputStream reader = urlConnection.getInputStream()) {
            string.append(IOUtils.toString(reader, StandardCharsets.UTF_8));
        }
        List<String> list = getImageAddresses(string.toString(), url);
        getImagesFromURL(list, url);
        return string.toString();
    }

    private List<String> getImageAddresses(String inputString, URL url) {
        List<String> imagesList = new ArrayList<>();
        Pattern pattern = Pattern.compile("<img.*(src=\")(.*?)(?=\\\")");
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            imagesList.add(matcher.group(2));
        }
        return imagesList;
    }

    private void getImagesFromURL(List<String> list, URL url) throws IOException {
        for (String string : list) {
            URL urlPicture = new URL("http://" + url.getHost() + "/" + string);
            URLConnection urlConnection = urlPicture.openConnection();
            File pictureName = new File(string);
            try (InputStream reader = urlConnection.getInputStream();
                 OutputStream outputStream = new FileOutputStream(pictureName)) {
                byte[] buffer = new byte[reader.available()];
                reader.read(buffer);
                outputStream.write(buffer);
            }
        }
    }
}

