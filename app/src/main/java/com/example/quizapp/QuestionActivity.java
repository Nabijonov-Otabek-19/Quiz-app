package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.quizapp.Controller.QuizController;
import com.example.quizapp.model.TestData;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private List<RadioButton> radios;
    private List<AppCompatTextView> variants;
    private AppCompatTextView questionText;
    private AppCompatTextView currentPos;
    private AppCompatTextView textAction;
    private ImageView image;
    private QuizController quizController;
    private AppCompatButton buttonSkip;
    private AppCompatButton buttonNext;
    private AppCompatImageView buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        quizController = QuizController.getInstance();
        loadViews();
        loadQuestions();

    }


    private void loadViews() {
        questionText = findViewById(R.id.textQuestion);
        currentPos = findViewById(R.id.textCurrentPos);
        textAction = findViewById(R.id.textAction);
        image = findViewById(R.id.img_flag);

        radios = new ArrayList<>(4);
        radios.add(findViewById(R.id.radio1));
        radios.add(findViewById(R.id.radio2));
        radios.add(findViewById(R.id.radio3));
        radios.add(findViewById(R.id.radio4));

        variants = new ArrayList<>(4);
        variants.add(findViewById(R.id.text1));
        variants.add(findViewById(R.id.text2));
        variants.add(findViewById(R.id.text3));
        variants.add(findViewById(R.id.text4));

        buttonSkip = findViewById(R.id.buttonSkip);
        buttonNext = findViewById(R.id.buttonNext);
        buttonBack = findViewById(R.id.btn_back);

        buttonSkip.setOnClickListener(v -> checkData());
        buttonBack.setOnClickListener(v -> finish());

        for (int i = 0; i < radios.size(); i++) {
            radios.get(i).setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (!isChecked) return;
                clearOldSelect();
                buttonView.setChecked(true);
                stateNextButton(true);
            });
        }
    }

    private void loadQuestions() {
        Intent intent = getIntent();
        int number = intent.getIntExtra("number", 0);

        if (number == 1) {
            describeTestData(quizController.getNextTestDataFlag());
            textAction.setText("Flags");

        } else if (number == 2) {
            describeTestData(quizController.getNextTestDataLogo());
            textAction.setText("Logos");

        } else if (number == 3) {
            describeTestData(quizController.getNextTestDataAnimal());
            textAction.setText("Animal");

        } else if (number == 4) {
            describeTestData(quizController.getNextTestDataFood());
            textAction.setText("Foods");

        } else if (number == 5) {
            describeTestData(quizController.getNextTestDataFruit());
            textAction.setText("Fruits");

        } else if (number == 6) {
            describeTestData(quizController.getNextTestDataVegetable());
            textAction.setText("Vegetables");
        }
    }

    private void clearOldSelect() {
        for (int i = 0; i < radios.size(); i++) {
            radios.get(i).setChecked(false);
        }
    }

    private void describeTestData(TestData data) {
        currentPos.setText((quizController.getCurrentPos()) + "/" + quizController.getMAX_COUNT());
        questionText.setText(data.getQuestion());
        image.setImageResource(data.getImage());
        variants.get(0).setText(data.getVariant1());
        variants.get(1).setText(data.getVariant2());
        variants.get(2).setText(data.getVariant3());
        variants.get(3).setText(data.getVariant4());
        clearOldSelect();
    }

    private void stateNextButton(boolean bool) {
        buttonNext.setEnabled(bool);
        buttonNext.setOnClickListener(v -> {
            quizController.testCheck(getUserAnswer());
            checkData();
        });
    }

    private String getUserAnswer() {
        int pos = 0;
        for (int i = 0; i < radios.size(); i++) {
            Log.d("TTT", radios.get(i).isChecked() + "");
            if (radios.get(i).isChecked())
                pos = i;
        }
        Log.d("TTT", "pos +" + pos);
        return variants.get(pos).getText().toString();
    }

    private void checkData() {
        if (quizController.isLastQuestion()) {
            describeTestData(quizController.getNextTestDataFlag());
            buttonNext.setEnabled(false);
        } else {
            startActivity(new Intent(this, ResultActivity.class));
            Toast.makeText(this, "FINISH", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}