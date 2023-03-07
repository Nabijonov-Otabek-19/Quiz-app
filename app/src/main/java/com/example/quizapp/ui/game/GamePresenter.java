package com.example.quizapp.ui.game;

import android.app.Dialog;
import android.content.Context;

import androidx.appcompat.widget.AppCompatButton;

import com.example.quizapp.R;

public class GamePresenter implements GameContract.Presenter {

    private GameContract.Model model;
    private GameContract.View view;
    private String userAnswer;


    GamePresenter(GameContract.View view, int category) {
        this.model = new GameModel(category);
        this.view = view;

        loadNextTest();
    }


    private void loadNextTest() {
        if (model.isLastQuestion()) {
            view.clearOldAnswer();
            view.describeTest(model.getNextTest(), model.getCurrentPos(), model.getTotalCount());
        } else {
            view.openResultActivity();
        }
    }

    @Override
    public void showCustomDialog() {
        Dialog dialog = new Dialog((Context) view);
        dialog.setContentView(R.layout.custom_exit_dialog);

        AppCompatButton btnNo = dialog.findViewById(R.id.textViewNo);
        AppCompatButton btnYes = dialog.findViewById(R.id.textViewYes);

        btnNo.setOnClickListener(view -> {
            dialog.dismiss();
        });

        btnYes.setOnClickListener(view -> {
            dialog.dismiss();
            this.view.closeScreen();
        });
        dialog.create();
        dialog.show();
    }

    @Override
    public int getCorrectAns() {
        return model.getCorrectAns();
    }

    @Override
    public int getWrongAns() {
        return model.getWrongAns();
    }

    @Override
    public int getSkippedAns() {
        return model.getSkippedAns();
    }

    @Override
    public void clickSkipButton() {
        loadNextTest();
    }

    @Override
    public void clickNextButton() {
        model.check(userAnswer);
        loadNextTest();
        view.stateNextButton(false);
    }

    @Override
    public void clickBackButton() {
        view.closeScreen();
    }


    @Override
    public void selectUserAnswer(String userAns) {
        this.userAnswer = userAns;
        view.stateNextButton(true);
    }
}