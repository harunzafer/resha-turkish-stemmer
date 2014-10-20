package com.hrzafer.reshaturkishstemmer;

import org.junit.Test;
import junit.framework.TestCase;

/**
 *
 * @author hrzafer
 */
public class ReshaStemmerTest extends TestCase {
    
    @Test
    public void testNuveDictStemmer(){
        Stemmer stemmer = Resha.Instance;

        String actual = stemmer.stem("kitapçıdaki");
        assertEquals("kitapçı", actual);

        actual = stemmer.stem("İstanbul'da");
        assertEquals("İstanbul", actual);
        
        //Characters after first aphostrope is trimmed including the aphos. itself
        actual = stemmer.stem("aaa'aaa'aa");
        assertEquals("aaa", actual);
                
        actual = stemmer.stem("aaa'''");
        assertEquals("aaa", actual);
        
        //If a word is not in the dictionary it remains unstemmed.
        actual = stemmer.stem("xxxx");
        assertEquals("xxxx", actual);

        //Stem definitions in manual.dict overrides the ones in generated.dict
        actual = stemmer.stem("neden");
        assertEquals("neden", actual);

        
    }
    
}
