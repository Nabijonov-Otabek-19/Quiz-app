package com.example.quizapp.model;

public class TestData {
    private final String question;
    private final int image;
    private final String variant1;
    private final String variant2;
    private final String variant3;
    private final String variant4;
    private final String answer;

    public TestData(String question, int image, String variant1, String variant2, String variant3, String variant4, String answer) {
        this.question = question;
        this.image = image;
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.variant4 = variant4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public int getImage() {
        return image;
    }

    public String getVariant1() {
        return variant1;
    }

    public String getVariant2() {
        return variant2;
    }

    public String getVariant3() {
        return variant3;
    }

    public String getVariant4() {
        return variant4;
    }

    public String getAnswer() {
        return answer;
    }
}
