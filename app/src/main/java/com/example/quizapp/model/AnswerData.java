package com.example.quizapp.model;

import java.io.Serializable;

public class AnswerData implements Serializable {
    private final int id;
    private final int image;
    private final String userAns;
    private final String correctAns;

    public AnswerData(int id, int image, String userAns, String correctAns) {
        this.id = id;
        this.image = image;
        this.userAns = userAns;
        this.correctAns = correctAns;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getUserAns() {
        return userAns;
    }

    public String getCorrectAns() {
        return correctAns;
    }
}
