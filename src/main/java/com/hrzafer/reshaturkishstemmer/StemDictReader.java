package com.hrzafer.reshaturkishstemmer;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Reads a stem dictionary into a Map(string, string)
 * Used by all dictionary based Stemmers
 */
public class StemDictReader {
    public static Map<String, String> read(String resourcePath) {
        InputStream is = StemDictReader.class.getResourceAsStream(resourcePath);
        Scanner scanner = new Scanner(is, "UTF-8");
        Map<String, String> map = new HashMap<String, String>();
        int lineNum = 0;
        while (scanner.hasNextLine()) {
            lineNum++;
            String line = scanner.nextLine();
            if (line.charAt(0) != '#') {
                try {
                    String[] columns = line.split("\t");
                    if (map.put(columns[0], columns[1]) != null) {
                        System.out.println("Warning: There is a duplicate in the stem dictionary: " + columns[0]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error at line " + lineNum + " in the stem dictionary.");
                }

            }
        }
        return map;
    }
}
