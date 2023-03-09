package com.example.quizapp.ui.game;


import com.example.quizapp.model.AnswerData;
import com.example.quizapp.model.TestData;

import java.util.List;

public interface GameContract {
    interface Model {
        void check(String userAnswer);
        TestData getNextTest();
        boolean isLastQuestion();
        int getCurrentPos();
        int getCorrectAns();
        int getWrongAns();
        int getSkippedAns();
        int getTotalCount();

    }

    interface View {
        void clearOldAnswer();
        void closeScreen();
        void describeTest(TestData testData, int currentPos, int totalCount);
        void stateNextButton(boolean bool);
        void openResultActivity();
    }

    interface Presenter {
        void showCustomDialog();
        int getCorrectAns();
        int getWrongAns();
        int getSkippedAns();
        void clickSkipButton();
        void clickNextButton();
        void clickBackButton();
        void selectUserAnswer(String userAns);

    }
}