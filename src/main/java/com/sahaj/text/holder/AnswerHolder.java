package com.sahaj.text.holder;

public class AnswerHolder {

    private static String answers;


    public static void addAnswers(String answers) {
        AnswerHolder.answers = answers;
    }

    public static String [] getAnswers() {
        return answers.toLowerCase().split(";");
    }
}
