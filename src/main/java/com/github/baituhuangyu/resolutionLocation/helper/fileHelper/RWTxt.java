package com.github.baituhuangyu.resolutionLocation.helper.fileHelper;

import com.github.baituhuangyu.resolutionLocation.resolution.QQWry;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;


/**
 *
 */
public class RWTxt {

    /**
     * 读入TXT文件
     */
    public static ArrayList<String> readFileLines(String s) {
        ArrayList<String> arr = new ArrayList<>();
        String pathname = s;
        return getFileStrings(pathname, arr);
    }

    /**
     * 写入TXT文件
     */
    public static void writeFile(String s, String content) {
        try {
            File writeName = new File(s);
            writeName.createNewFile();
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write(content);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String ReadResourceString(String name) throws IOException {
        final InputStream in = QQWry.class.getClassLoader().getResourceAsStream(name);
        final ByteArrayOutputStream out = new ByteArrayOutputStream(10 * 1024 * 1024); // 10MB
        final byte[] buffer = new byte[4096];
        final String string;

        while (true) {
            final int r = in.read(buffer);
            if (r == -1) {
                break;
            }
            out.write(buffer, 0, r);
        }
        string = out.toString();
        return string;
    }

    public static ArrayList<String> ReadResourceStringLine(String name) {
        final URL url = QQWry.class.getClassLoader().getResource(name);
        ArrayList<String> arr = new ArrayList<>();

        String pathname = url.getFile();
        if (pathname != null){
            return getFileStrings(pathname, arr);
        }
        return arr;
    }

    private static ArrayList<String> getFileStrings(String pathname, ArrayList<String> arr) {
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                arr.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
