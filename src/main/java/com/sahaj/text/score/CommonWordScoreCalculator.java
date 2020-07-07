package com.sahaj.text.score;

import com.sahaj.text.stemmer.Stemmer;

public class CommonWordScoreCalculator implements ScoreCalculator {

    private Stemmer stemmer;
    public CommonWordScoreCalculator(Stemmer stemmer) {
        this.stemmer = stemmer;
    }

    @Override
    public int calculateScore(String sourceString, String destString) {
        if(destString == null  ||destString.length() ==0  || sourceString ==null || sourceString.length() ==0) return 0;
        String source = stemmer.stem(sourceString);
        String dest = stemmer.stem(destString);

        int score=0;
        String[] tokens = dest.split("[?, ]+");
        for(String token : tokens){
            if(source.contains(token)){
                score++;
            }
        }
        return score;
    }
}
