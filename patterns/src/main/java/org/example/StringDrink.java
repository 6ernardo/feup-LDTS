package org.example;

public class StringDrink {

    String text;

    public StringDrink(String text){
        this.text= new String(text);
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text= new String(text);
    }
}
