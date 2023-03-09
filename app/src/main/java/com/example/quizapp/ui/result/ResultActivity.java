package com.example.quizapp.ui.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizapp.R;
import com.example.quizapp.model.AnswerData;
import com.example.quizapp.repository.AppRepository;

import java.util.List;

public class ResultActivity extends AppCompatActivity implements ResultContract.View {

    private TextView correctAns;
    private TextView wrongtAns;
    private TextView skippedAns;
    private TextView id, userAns, corrAns;
    private ImageView image;
    private AppCompatButton back2menu;
    private LayoutInflater inflater;

    private List<AnswerData> list;

    private LinearLayoutCompat container;
    private ResultContract.Presenter presenter;

    private AppRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        presenter = new ResultPresenter(this);
        repository = AppRepository.getInstance();

        loadViews();

    }

    private void loadViews() {
        correctAns = findViewById(R.id.txt_correctAnswer);
        wrongtAns = findViewById(R.id.txt_wrongAnswer);
        skippedAns = findViewById(R.id.txt_skippedAnswer);
        back2menu = findViewById(R.id.btn_back2menu);

        inflater = LayoutInflater.from(this);
        container = findViewById(R.id.container);

        presenter.setAnswers();
        presenter.showAllAnswers();
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

        back2menu.setOnClickListener(view -> presenter.clickBtnBackMenu());
    }

    @Override
    public void showAllAnswers() {

        list = repository.getAnswerDataList();
        if (list.size() != 0) {
            list.forEach(answerData -> {
                View view = inflater.inflate(R.layout.item_answers, container, false);
                image = view.findViewById(R.id.img_Ans);
                userAns = view.findViewById(R.id.txt_userAns);
                correctAns = view.findViewById(R.id.txt_corrAns);
                id = view.findViewById(R.id.txt_id);

                image.setImageResource(answerData.getImage());
                correctAns.setText(answerData.getCorrectAns());
                correctAns.setTextColor(getColor(R.color.green));
                id.setText(String.valueOf(answerData.getId()));
                userAns.setText(answerData.getUserAns());

                if (answerData.getCorrectAns().equals(answerData.getUserAns())) {
                    userAns.setTextColor(getColor(R.color.green));
                } else userAns.setTextColor(getColor(R.color.red));


                container.addView(view);
            });
        }

    }
}