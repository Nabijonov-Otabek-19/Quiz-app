package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.quizapp.Controller.QuizController;

public class ResultActivity extends AppCompatActivity {

    private TextView correctAns;
    private TextView wrongtAns;
    private TextView skippedAns;
    private AppCompatButton back2menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        loadViews();
    }

    private void loadViews() {
        QuizController controller = QuizController.getInstance();

        correctAns = findViewById(R.id.txt_correctAnswer);
        wrongtAns = findViewById(R.id.txt_wrongAnswer);
        skippedAns = findViewById(R.id.txt_skippedAnswer);

        back2menu = findViewById(R.id.btn_back2menu);

        correctAns.setText(String.valueOf(controller.getCorrectCount()));
        wrongtAns.setText(String.valueOf(controller.getWrongCount()));
        skippedAns.setText(String.valueOf(controller.getMAX_COUNT() - controller.getCorrectCount() - controller.getWrongCount()));

        back2menu.setOnClickListener(view -> {
            finish();
        });
    }
}