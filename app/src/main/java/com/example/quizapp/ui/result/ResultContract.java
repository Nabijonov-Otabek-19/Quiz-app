package com.example.quizapp.ui.result;

public interface ResultContract {

    interface Model{

    }

    interface View{
        void BackMenu();
        void setAnswers();
        void showAllAnswers();
    }

    interface Presenter{
        void showAllAnswers();
        void clickBtnBackMenu();
        void setAnswers();
    }
}
