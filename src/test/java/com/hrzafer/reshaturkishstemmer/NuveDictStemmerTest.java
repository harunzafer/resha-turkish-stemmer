/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrzafer.reshaturkishstemmer;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import junit.framework.TestCase;

/**
 *
 * @author hrzafer
 */
public class NuveDictStemmerTest extends TestCase {
    
    @Test
    public void testNuveDictStemmer(){
        Stemmer stemmer = Resha.Instance;
        
        String actual = stemmer.stem("İstanbul'da");
        assertEquals("İstanbul", actual);
        
        //Characters after first aphostrope is trimmed including the aphos. itself
        actual = stemmer.stem("aaa'aaa'aa");
        assertEquals("aaa", actual);
                
        actual = stemmer.stem("aaa'''");
        assertEquals("aaa", actual);
        
        //If a word is not in the dictionary it remains unstemmed.
        actual = stemmer.stem("xxxx");
        assertEquals("xxxx", actual);
        
    }
    
}
