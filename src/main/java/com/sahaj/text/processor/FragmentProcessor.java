package com.sahaj.text.processor;

import com.sahaj.text.score.CommonWordScoreCalculator;
import com.sahaj.text.stemmer.BasicStemmer;

public class FragmentProcessor {
    private static final int WINDOW_SIZE = 80;

    public String fragmentProcessor(int startIndex, int endIndex, String inputText){
        String  probableAns = inputText.substring(startIndex,endIndex);

        String beforeText = beforeText(startIndex, inputText);
        String afterText = afterText(endIndex, inputText);

        return  new QuestionProcessor(new CommonWordScoreCalculator(new BasicStemmer())).process(beforeText.concat(probableAns),
                probableAns.concat(afterText));

    }

    private String  afterText(int endIndex, String inputText) {
        if(endIndex+WINDOW_SIZE < inputText.length())
            return  inputText.substring(endIndex+1,endIndex+WINDOW_SIZE);
        else
            return  inputText.substring(endIndex+1,inputText.length());
    }

    private String beforeText(int startIndex, String inputText) {

        if(startIndex-WINDOW_SIZE > 0)
            return  inputText.substring(startIndex-WINDOW_SIZE,startIndex);
        else
           return  inputText.substring(0,startIndex);
    }
}
