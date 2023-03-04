package com.example.quizapp.ui.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quizapp.R;

public class ResultActivity extends AppCompatActivity implements ResultContract.View {

    private TextView correctAns;
    private TextView wrongtAns;
    private TextView skippedAns;
    private AppCompatButton back2menu;

    private ResultContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        presenter = new ResultPresenter(this);

        loadViews();

    }

    private void loadViews() {
        correctAns = findViewById(R.id.txt_correctAnswer);
        wrongtAns = findViewById(R.id.txt_wrongAnswer);
        skippedAns = findViewById(R.id.txt_skippedAnswer);
        back2menu = findViewById(R.id.btn_back2menu);

        presenter.setAnswers();
    }

    @Override
    public void BackMenu() {
        finish();
    }

    @Override
    public void setAnswers() {
        Intent intent = getIntent();

        correctAns.setText(String.valueOf(intent.getIntExtra("correct", 0)));
        wrongtAns.setText(String.valueOf(intent.getIntExtra("wrong", 0)));
        skippedAns.setText(String.valueOf(intent.getIntExtra("skip", 0)));

        back2menu.setOnClickListener(view -> {
            presenter.clickBtnBackMenu();
        });
    }
}