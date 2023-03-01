package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quizapp.Controller.QuizController;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.card_flags).setOnClickListener(view -> {
            setGame();
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            intent.putExtra("number", 1);
            startActivity(intent);
        });


        findViewById(R.id.card_logos).setOnClickListener(view -> {
            setGame();
            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
            intent.putExtra("number", 2);
            startActivity(intent);
        });

//        findViewById(R.id.card_animals).setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
//            intent.putExtra("number", 3);
//            startActivity(intent);
//        });
//
//        findViewById(R.id.card_foods).setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
//            intent.putExtra("number", 4);
//            startActivity(intent);
//        });
//
//        findViewById(R.id.card_fruits).setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
//            intent.putExtra("number", 5);
//            startActivity(intent);
//        });
//
//        findViewById(R.id.card_vegetables).setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
//            intent.putExtra("number", 6);
//            startActivity(intent);
//        });
    }

    private void setGame() {
        QuizController controller = QuizController.getInstance();
        controller.setCurrentPos(0);
    }
}