package com.sahaj.text.holder;

public class InputHolder {

    private String inputText;


    public void addInputText(String inputText){
        this.inputText = inputText;
    }

    public String getInputText() {
        return inputText.toLowerCase();
    }
}
