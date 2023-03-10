package com.example.quizapp.ui.main;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void clickCategoryButton(int category) {
        view.openGameActivity(category);
    }
}
