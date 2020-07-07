package com.sahaj.text.holder;

import java.util.ArrayList;
import java.util.List;

public class QuestionHolder {

    private static List<String> questions = new ArrayList<>();

    public static void addQuestion(String question){
        questions.add(question.toLowerCase());
    }

    public static List<String> getQuestions() {
        return questions;
    }

    public static void removeQuestion(String removedQuestion) {
        questions.remove(removedQuestion);
    }
}
