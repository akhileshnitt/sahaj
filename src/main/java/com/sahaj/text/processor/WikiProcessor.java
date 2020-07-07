package com.sahaj.text.processor;

import com.sahaj.text.holder.AnswerHolder;
import com.sahaj.text.holder.InputHolder;
import com.sahaj.text.holder.QuestionHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikiProcessor {


    public List<String> process(InputHolder inputHolder){

        int start,end;
        String reg;

        String [] answers = AnswerHolder.getAnswers();

        //Save a copy of Questions
        List<String> questions = new ArrayList<>();
        QuestionHolder.getQuestions().forEach(e->questions.add(e));

        Map<String,String> correctOut = new HashMap<>();

        for(int i=0;i<answers.length;i++)
        {
            reg=getRegex(answers[i].toLowerCase());

            Pattern pat = Pattern.compile(reg);
            Matcher mat =pat.matcher(inputHolder.getInputText());
            String correctQuestion="";
            while(mat.find())
            {
                start=mat.start();
                end=mat.end();
                correctQuestion = new FragmentProcessor().fragmentProcessor(start,end,inputHolder.getInputText());
                if(correctQuestion.length()>0){
                    break;
                }

            }
            correctOut.put(correctQuestion,answers[i]);
        }
        return processAnswers(correctOut,questions);
    }

    private List<String> processAnswers(Map<String, String> correctOut, List<String> questions) {
        List<String> answer = new ArrayList<>();
        for(String ques : questions){
            if(correctOut.get(ques) != null){
                answer.add(correctOut.get(ques));
            }
        }
        return answer;
    }

    private String getRegex(String input)
    {
        input=input.replace("(","\\(");
        input=input.replace(")","\\)");
        input=input.replace(".","\\.");
        return input;
    }
}
