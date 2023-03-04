package com.example.quizapp.ui.result;

public class ResultPresenter implements ResultContract.Presenter {

    private ResultContract.View view;

    public ResultPresenter(ResultContract.View view) {
        this.view = view;
    }


    @Override
    public void clickBtnBackMenu() {
        view.BackMenu();
    }

    @Override
    public void setAnswers() {
        view.setAnswers();
    }
}
