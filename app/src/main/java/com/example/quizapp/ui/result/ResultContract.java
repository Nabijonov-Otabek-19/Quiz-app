package com.example.quizapp.ui.result;

public interface ResultContract {

    interface Model{

    }

    interface View{
        void BackMenu();
        void setAnswers();
    }

    interface Presenter{
        void clickBtnBackMenu();
        void setAnswers();
    }
}
