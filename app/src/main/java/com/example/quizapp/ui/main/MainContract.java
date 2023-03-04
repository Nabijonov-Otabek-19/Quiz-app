package com.example.quizapp.ui.main;

public interface MainContract {

    interface Model {
    }

    interface View {
        void openGameActivity(int category);
    }

    interface Presenter {
        void clickCategoryButton(int category);
    }
}
