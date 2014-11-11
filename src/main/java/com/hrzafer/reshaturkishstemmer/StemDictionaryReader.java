package com.hrzafer.reshaturkishstemmer;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads a stem dictionary into a Map(string, string)
 * Used by all dictionary based Stemmers
 */
public class StemDictionaryReader {

    private static final String manual = "/manual.dict";
    private static final String generated = "/generated.dict";

    public static Map<String, String> GetMap() {

        Map<String, String> generatedStems = ReadFaster(generated);

        Map<String, String> manualStems = ReadFaster(manual);

        generatedStems.putAll(manualStems);

        return generatedStems;
    }

    public static Map<String, String> ReadFaster(String path) {

        Map<String, String> map = new HashMap<String, String>();

        try {

            URL url = StemDictionaryReader.class.getResource(path);

            List<String> lines = Files.readAllLines(Paths.get(url.toURI()), Charset.forName("UTF-8"));

            for (String line : lines) {

                if (!line.isEmpty() && line.charAt(0) != '#') {

                    String[] columns = line.split("\t");

                    String s = map.put(columns[0], columns[1].intern());

                    if (s != null) {
                        System.out.println("Warning: Duplicate enrty in the stem dictionary: " + columns[0]);
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
