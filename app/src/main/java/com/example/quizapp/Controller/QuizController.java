package com.example.quizapp.Controller;

import com.example.quizapp.R;
import com.example.quizapp.model.TestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class QuizController {
    private List<TestData> list_flag;
    private List<TestData> list_logo;
    private List<TestData> list_animal;
    private List<TestData> list_food;
    private List<TestData> list_fruit;
    private List<TestData> list_vegetable;

    private final int MAX_COUNT = 10;
    private int currentPos = 0;
    private int wrongCount;
    private int correctCount;

    {
        loadTests();
    }

    private QuizController() {
    }

    private static QuizController controller;

    public static QuizController getInstance() {
        if (controller == null)
            controller = new QuizController();
        return controller;
    }

    public int getMAX_COUNT() {
        return MAX_COUNT;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getSkipCount() {
        return currentPos - correctCount - wrongCount;
    }

    private void loadTests() {
        shuffleListFlag();
        shuffleListLogo();
        shuffleListAnimal();
        shuffleListFood();
        shuffleListFruit();
        shuffleListVegetable();
    }

    private void shuffleListFlag() {
        list_flag = new ArrayList<>(10);
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.german, "Uzbekistan", "India", "Brazil", "German", "German"));
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.america, "Uzbekistan", "America", "Brazil", "German", "America"));
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.argentina, "Argentina", "India", "Brazil", "America", "Argentina"));
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.britian, "Pakistan", "India", "Great Britian", "German", "Great Britian"));
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.canada, "Uzbekistan", "Canada", "Brazil", "German", "Canada"));
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.india, "Uzbekistan", "India", "Brazil", "German", "India"));
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.japan, "Uzbekistan", "India", "Brazil", "Japan", "Japan"));
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.korea, "Korea", "India", "Brazil", "German", "Korea"));
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.russia, "Uzbekistan", "India", "Russia", "German", "Russia"));
        list_flag.add(new TestData("Which country's flag is this?", R.drawable.ukraina, "Ukraina", "India", "Brazil", "German", "Ukraina"));
        Collections.shuffle(list_flag);
    }

    private void shuffleListLogo() {
        list_logo = new ArrayList<>(10);
        list_logo.add(new TestData("Name this logo", R.drawable.german, "Uzbekistan", "India", "Brazil", "German", "German"));
        Collections.shuffle(list_logo);
    }

    private void shuffleListAnimal() {
        list_animal = new ArrayList<>(10);
        list_animal.add(new TestData("Name this animal", R.drawable.german, "Uzbekistan", "India", "Brazil", "German", "German"));
        Collections.shuffle(list_animal);
    }

    private void shuffleListFood() {
        list_food = new ArrayList<>(10);
        list_food.add(new TestData("Name this food", R.drawable.german, "Uzbekistan", "India", "Brazil", "German", "German"));
        Collections.shuffle(list_food);
    }

    private void shuffleListFruit() {
        list_fruit = new ArrayList<>(10);
        list_fruit.add(new TestData("Name this fruit", R.drawable.german, "Uzbekistan", "India", "Brazil", "German", "German"));
        Collections.shuffle(list_fruit);
    }

    private void shuffleListVegetable() {
        list_vegetable = new ArrayList<>(10);
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.german, "Uzbekistan", "India", "Brazil", "German", "German"));
        Collections.shuffle(list_vegetable);
    }


    public TestData getNextTestDataFlag() {
        return list_flag.get(currentPos++);
    }

    public TestData getNextTestDataLogo() {
        return list_logo.get(currentPos++);
    }

    public TestData getNextTestDataAnimal() {
        return list_animal.get(currentPos++);
    }

    public TestData getNextTestDataFood() {
        return list_food.get(currentPos++);
    }

    public TestData getNextTestDataFruit() {
        return list_fruit.get(currentPos++);
    }

    public TestData getNextTestDataVegetable() {
        return list_vegetable.get(currentPos++);
    }


    public boolean isLastQuestion() {
        return currentPos < MAX_COUNT;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public void testCheck(String userAnswer) {
        if (list_flag.get(currentPos - 1).getAnswer().toLowerCase(Locale.ROOT).equals(userAnswer.toLowerCase()))
            correctCount++;
        else wrongCount++;
    }
}