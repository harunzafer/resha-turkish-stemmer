package com.hrzafer.reshaturkishstemmer;
/**
 * See unit tests for more examples
 */
public class Examples 
{
    public static void main( String[] args )
    {
        Stemmer stemmer = Resha.Instance;
        System.out.println(stemmer.stem("kitapçıdaki"));
        System.out.println(stemmer.stem("neden"));
    }
}
