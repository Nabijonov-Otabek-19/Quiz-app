package com.example.quizapp.ui.game;

import com.example.quizapp.model.AnswerData;
import com.example.quizapp.model.TestData;
import com.example.quizapp.repository.AppRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GameModel implements GameContract.Model {

    private final int MAX_COUNT = 10;
    private AppRepository repository;
    private List<TestData> test;
    private int currentPos = 0;
    private int wrongCount;
    private int correctCount;


    public GameModel(int category) {
        repository = AppRepository.getInstance();
        test = new ArrayList<>();
        test.addAll(repository.getNeedDataByCount(category));
    }

    @Override
    public void check(String userAnswer) {
        if (test.get(currentPos - 1).getAnswer().toLowerCase(Locale.ROOT)
                .equals(userAnswer.toLowerCase(Locale.ROOT))) {
            correctCount++;
            repository.setAnswerDataList(currentPos - 1, test.get(currentPos - 1).getImage(), userAnswer, test.get(currentPos - 1).getAnswer());
        } else {
            wrongCount++;
            repository.setAnswerDataList(currentPos - 1, test.get(currentPos - 1).getImage(), userAnswer, test.get(currentPos - 1).getAnswer());
        }
    }

    @Override
    public TestData getNextTest() {
        return test.get(currentPos++);
    }

    @Override
    public boolean isLastQuestion() {
        return currentPos < MAX_COUNT;
    }

    @Override
    public int getCurrentPos() {
        return currentPos;
    }

    @Override
    public int getCorrectAns() {
        return correctCount;
    }

    @Override
    public int getWrongAns() {
        return wrongCount;
    }

    @Override
    public int getSkippedAns() {
        return MAX_COUNT - correctCount - wrongCount;
    }

    @Override
    public int getTotalCount() {
        return MAX_COUNT;
    }

}