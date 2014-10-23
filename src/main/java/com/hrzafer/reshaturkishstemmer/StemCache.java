package com.hrzafer.reshaturkishstemmer;

public class StemCache {

    private String[] stems;
    private int index;

    public StemCache(int size) {
        stems = new String[size];
        init();
        index = 0;
    }

    private void init(){
        for (int i = 0; i < stems.length; i++) {
            stems[i] = "";
        }
    }

    public int indexOf(String stem) {
        for (int i = 0; i < stems.length; i++) {
            if (stems[i].equals(stem)) {
                return i;
            }
        }
        return -1;
    }

    public void put(String stem) {
        stems[index] = stem;
        index = (index + 1) % stems.length;

    }

    public String get(int i) {
        if (i > -1 && i < stems.length) {
            return stems[i];
        }
        return null;
    }
}
