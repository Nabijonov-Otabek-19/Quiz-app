package com.example.quizapp.ui.game;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.quizapp.R;
import com.example.quizapp.ui.main.MainContract;
import com.example.quizapp.ui.result.ResultActivity;
import com.example.quizapp.model.TestData;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity implements GameContract.View {

    private GameContract.Presenter presenter;
    private GameContract.Model model;

    private List<RadioButton> radios;
    private List<AppCompatTextView> variants;
    private AppCompatTextView questionText;
    private AppCompatTextView currentPosText;
    private AppCompatButton buttonSkip;
    private AppCompatButton buttonNext;
    private AppCompatImageView buttonBack;
    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        loadViews();
        attachClickListener();
        int number = getIntent().getIntExtra("number", 0);
        presenter = new GamePresenter(this, number);
    }

    private void loadViews() {
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

        questionText = findViewById(R.id.textQuestion);
        currentPosText = findViewById(R.id.textCurrentPos);
        buttonSkip = findViewById(R.id.buttonSkip);
        buttonNext = findViewById(R.id.buttonNext);
        buttonBack = findViewById(R.id.btn_back);

        image = findViewById(R.id.img_flag);
    }

    private void attachClickListener() {
        buttonNext.setOnClickListener(v -> {
            presenter.clickNextButton();
        });

        buttonSkip.setOnClickListener(v -> {
            presenter.clickSkipButton();
        });

        buttonBack.setOnClickListener(v -> {
            presenter.clickBackButton();
        });

        for (int i = 0; i < radios.size(); i++) {
            radios.get(i).setTag(i);
            radios.get(i).setOnClickListener(v -> {
                int pos = (int) v.getTag();
                if (radios.get(pos).isChecked()) {
                    clearOldAnswer();
                    radios.get(pos).setChecked(true);
                    presenter.selectUserAnswer(variants.get(pos).getText().toString());
                }
            });
        }
    }

    @Override
    public void clearOldAnswer() {
        for (int i = 0; i < radios.size(); i++) {
            if (radios.get(i).isChecked()) radios.get(i).setChecked(false);
        }
    }

    @Override
    public void closeScreen() {
        onBackPressed();
    }

    @Override
    public void describeTest(TestData testData, int currentPos, int totalCount) {
        currentPosText.setText(currentPos + "/" + totalCount);
        questionText.setText(testData.getQuestion());
        image.setImageResource(testData.getImage());

        variants.get(0).setText(testData.getVariant1());
        variants.get(1).setText(testData.getVariant2());
        variants.get(2).setText(testData.getVariant3());
        variants.get(3).setText(testData.getVariant4());
    }

    @Override
    public void stateNextButton(boolean bool) {
        buttonNext.setEnabled(bool);
    }

    @Override
    public void openResultActivity() {
        Toast.makeText(GameActivity.this, "Finish", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
        intent.putExtra("correct", presenter.getCorrectAns());
        intent.putExtra("wrong", presenter.getWrongAns());
        intent.putExtra("skip", presenter.getSkippedAns());
        startActivity(intent);
        presenter.clickBackButton();
    }
}