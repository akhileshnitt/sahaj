package com.sahaj.text.processor;

import com.sahaj.text.holder.QuestionHolder;
import com.sahaj.text.score.ScoreCalculator;

import java.util.List;

public class QuestionProcessor {

    private ScoreCalculator scoreCalculator;

    public QuestionProcessor(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public String process(String beforeText, String afterText) {
        List<String> questiosn = QuestionHolder.getQuestions();

        // process beforeText
        int maxBScore = Integer.MIN_VALUE;
        String correctB="";
        for (String value : questiosn) {
            int score = scoreCalculator.calculateScore(beforeText, value);
            if (score > maxBScore) {
                maxBScore = score;
                correctB = value;
            }
        }

        // process afterText
        int maxAScore = Integer.MIN_VALUE;
        String correctA="";
        for (String s : questiosn) {
            int score = scoreCalculator.calculateScore(afterText, s);
            if (score > maxAScore) {
                maxAScore = score;
                correctA = s;
            }
        }
        if(maxBScore >maxAScore) {
            QuestionHolder.removeQuestion(correctB);
            return correctB;
        }
        else {
            QuestionHolder.removeQuestion(correctA);
            return correctA;
        }
    }
}
