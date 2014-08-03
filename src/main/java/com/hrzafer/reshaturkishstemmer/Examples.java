package com.hrzafer.reshaturkishstemmer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class Examples 
{
    public static void main( String[] args )
    {
        
        try {
            System.out.println("started");
                Thread.sleep(10000);
            Stemmer stemmer = Resha.Instance;
            System.out.println("initialized");
            Thread.sleep(10000);            
            stemmer.stem("kitapçıdaki");
            System.out.println("stemmed");
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Examples.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
