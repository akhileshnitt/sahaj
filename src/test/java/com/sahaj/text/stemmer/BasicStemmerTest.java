package com.sahaj.text.stemmer;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicStemmerTest {



    @Test
    public void removeStopWords() {
        String s = "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes.";
        Stemmer stemmer = new BasicStemmer();
        assertEquals("Zebras several species African equids (horse family) united distinctive black white stripes.",
                stemmer.removeStopWords(s));
    }

    @Test
    public void tokenize() {

        String s = "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes.";
        Stemmer stemmer = new BasicStemmer();
        assertEquals(s,
                stemmer.tokenize(s));
    }

    @Test
    public void lemmatize() {
        String s = "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes.";
        Stemmer stemmer = new BasicStemmer();
        assertEquals(s,
                stemmer.lemmatize(s));

    }


    @Test
    public void testStem(){
        String s = "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes.";
        Stemmer stemmer = new BasicStemmer();
        assertEquals("zebras several species african equids (horse family) united distinctive black white stripes.",
                stemmer.stem(s));
    }

}