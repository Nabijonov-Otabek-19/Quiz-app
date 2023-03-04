package com.example.quizapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.quizapp.R;
import com.example.quizapp.ui.game.GameActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        loadViews();
    }

    private void loadViews() {
        findViewById(R.id.card_flags).setOnClickListener(view -> {
            presenter.clickCategoryButton(1);
        });

        findViewById(R.id.card_logos).setOnClickListener(view -> {
            presenter.clickCategoryButton(2);
        });

        findViewById(R.id.card_animals).setOnClickListener(view -> {
            presenter.clickCategoryButton(3);
        });

        findViewById(R.id.card_foods).setOnClickListener(view -> {
            presenter.clickCategoryButton(4);
        });

        findViewById(R.id.card_fruits).setOnClickListener(view -> {
            presenter.clickCategoryButton(5);
        });

        findViewById(R.id.card_vegetables).setOnClickListener(view -> {
            presenter.clickCategoryButton(6);
        });
    }

    @Override
    public void openGameActivity(int category) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("number", category);
        startActivity(intent);
    }
}