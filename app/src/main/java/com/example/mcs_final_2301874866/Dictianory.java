package com.example.mcs_final_2301874866;

public class Dictianory {

    String word;
    String definition;
    String type;
    String imageurl;

    public Dictianory(String word, String definition, String type, String imageurl) {
        this.word = word;
        this.definition = definition;
        this.type = type;
        this.imageurl = imageurl;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}

