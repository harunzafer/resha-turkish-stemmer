package com.hrzafer.reshaturkishstemmer;

import java.util.List;

/**
 * This interface has two methods for stemming
 */
public interface Stemmer
{
    /**
     * Finds and returns stem of the word
     * @param token is the word
     * @return stem of the word
     */
    public abstract String stem(String token);

    /**
     * Finds the most possible stem of the word according to the words before and/or after the word.
     * WARNING: Some implementations of the Stemmer interface may not support this method and throws
     * UnsupportedOperationException.
     * @param tokens series of words including the word to be stemmed
     * @param index index of the word to be stemmed in the list
     * @return most possible stem of the word
     */
    public abstract String stem(List<String> tokens, int index) throws UnsupportedOperationException;
}
