package com.hrzafer.reshaturkishstemmer;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Reads a stem dictionary into a Map(string, string)
 * Used by all dictionary based Stemmers
 */
public class StemDictionaryReader {

    private static final String manual = "/manual.dict";
    private static final String generated = "/generated.dict";

    public static Map<String, String> GetMap() {

        Map<String, String> generatedStems = Read(generated);

        Map<String, String> manualStems = Read(manual);

        generatedStems.putAll(manualStems);

        return generatedStems;
    }

    public static Map<String, String> Read(String path) {

        InputStream is = StemDictionaryReader.class.getResourceAsStream(path);
        Scanner scanner = new Scanner(is, "UTF-8");
        Map<String, String> map = new TreeMap<String, String>();
        StemCache cache = new StemCache(3);

        int lineNum = 0;
        while (scanner.hasNextLine()) {

            lineNum++;
            String line = scanner.nextLine();

            if (!line.isEmpty() && line.charAt(0) != '#') {
                try {
                    String[] columns = line.split("\t");
                    if (columns[0].equals("kitapçıdaki")) {
                        System.out.println();
                    }
                    int index = cache.indexOf(columns[1]);

                    if (index > -1) {
                        map.put(columns[0], cache.get(index));
                    } else {
                        String s = map.put(columns[0], columns[1]);
                        if (s != null) {
                            System.out.println("Warning: Duplicate enrty in the stem dictionary: " + columns[0]);
                        }
                        cache.put(columns[1]);
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error at line " + lineNum + " in the stem dictionary.");
                }

            }
        }
        return map;
    }


}
