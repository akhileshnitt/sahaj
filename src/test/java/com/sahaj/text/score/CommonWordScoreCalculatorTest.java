package com.sahaj.text.score;

import com.sahaj.text.stemmer.BasicStemmer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommonWordScoreCalculatorTest {

    @Test
    public void calculateScore() {
        String source = "The plains zebra and the mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra is the sole species of subgenus Dolichohippus. The latter resembles an ass, to which it is closely related, while the former two are more horse-like.";
        String dest = "Which subgenus do the plains zebra and the mountain zebra belong to?";

        CommonWordScoreCalculator commonWordScoreCalculator = new CommonWordScoreCalculator(new BasicStemmer());
        int score = commonWordScoreCalculator.calculateScore(source,dest);
        assertEquals(6,score);
    }


    @Test
    public void calculateScoreAns() {
        String source = "The plains zebra and the mountain zebra belong to the subgenus Hippotigris. The latter resembles an ass, to which it is closely related, while the former two are more horse-like.";
        String dest = "subgenus Hippotigris";

        CommonWordScoreCalculator commonWordScoreCalculator = new CommonWordScoreCalculator(new BasicStemmer());
        int score = commonWordScoreCalculator.calculateScore(source,dest);
        assertEquals(2,score);
    }

    @Test
    public void calculateScoreWithEmptyDestination() {
        String source = "The plains zebra and the mountain zebra belong to the subgenus Hippotigris. The latter resembles an ass, to which it is closely related, while the former two are more horse-like.";
        String dest = "";

        CommonWordScoreCalculator commonWordScoreCalculator = new CommonWordScoreCalculator(new BasicStemmer());
        int score = commonWordScoreCalculator.calculateScore(source,dest);
        assertEquals(0,score);
    }

    @Test
    public void calculateScoreWithNullDestination() {
        String source = "The plains zebra and the mountain zebra belong to the subgenus Hippotigris. The latter resembles an ass, to which it is closely related, while the former two are more horse-like.";
        String dest = "";

        CommonWordScoreCalculator commonWordScoreCalculator = new CommonWordScoreCalculator(new BasicStemmer());
        int score = commonWordScoreCalculator.calculateScore(source,dest);
        assertEquals(0,score);
    }


    @Test
    public void calculateScoreWithEmptySource() {
        String dest = "The plains zebra and the mountain zebra belong to the subgenus Hippotigris. The latter resembles an ass, to which it is closely related, while the former two are more horse-like.";
        String source = "";

        CommonWordScoreCalculator commonWordScoreCalculator = new CommonWordScoreCalculator(new BasicStemmer());
        int score = commonWordScoreCalculator.calculateScore(source,dest);
        assertEquals(0,score);
    }

    @Test
    public void calculateScoreWithNullSource() {
        String dest = "The plains zebra and the mountain zebra belong to the subgenus Hippotigris. The latter resembles an ass, to which it is closely related, while the former two are more horse-like.";
        String source = "";

        CommonWordScoreCalculator commonWordScoreCalculator = new CommonWordScoreCalculator(new BasicStemmer());
        int score = commonWordScoreCalculator.calculateScore(source,dest);
        assertEquals(0,score);
    }
}