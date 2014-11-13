package com.hrzafer.reshaturkishstemmer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Reads a stem dictionary into a Map(string, string)
 * Used by all dictionary based Stemmers
 */
public class StemDictionaryReader {

    private static final String manual = "/manual.dict";
    private static final String generated = "/generated.dict";

    public static Map<String, String> GetMap() {

        Map<String, String> generatedStems = Read2(generated);

        Map<String, String> manualStems = Read2(manual);

        generatedStems.putAll(manualStems);

        return generatedStems;
    }

    public static Map<String, String> Read2(String path) {

        //Get file from resources folder
        Map<String, String> map = new HashMap<>();
        try {

            InputStream in = StemDictionaryReader.class.getResourceAsStream(path);

            BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.isEmpty() && line.charAt(0) != '#') {

                    String[] columns = line.split("\t");

                    String s = map.put(columns[0], columns[1].intern());

                    if (s != null) {
                        System.out.println("Warning: Duplicate enrty in the stem dictionary: " + columns[0]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;

    }

}
