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

    private int currentList;

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

    private void loadTests() {
        shuffleListFlag();
        shuffleListLogo();
        shuffleListAnimal();
        shuffleListFood();
        shuffleListFruit();
        shuffleListVegetable();
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

    public void setCurrentList(int list) {
        this.currentList = list;
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
        list_logo.add(new TestData("Name this logo", R.drawable.wikipedia, "Youtube", "Google", "Wikipedia", "Pinterest", "Wikipedia"));
        list_logo.add(new TestData("Name this logo", R.drawable.snapchat, "Snapchat", "Google", "Wikipedia", "Twitter", "Snapchat"));
        list_logo.add(new TestData("Name this logo", R.drawable.twitch, "Youtube", "Vimeo", "Wikipedia", "Twitch", "Twitch"));
        list_logo.add(new TestData("Name this logo", R.drawable.pinterest, "Github", "Google", "Pinterest", "LinkedIn", "Pinterest"));
        list_logo.add(new TestData("Name this logo", R.drawable.twitter, "Youtube", "Twitter", "Dropbox", "Pinterest", "Twitter"));
        list_logo.add(new TestData("Name this logo", R.drawable.linkedin, "LinkedIn", "Google", "Wikipedia", "Pinterest", "LinkedIn"));
        list_logo.add(new TestData("Name this logo", R.drawable.github, "Youtube", "Github", "Wikipedia", "Twitch", "Github"));
        list_logo.add(new TestData("Name this logo", R.drawable.stackoverflow, "StackOverFlow", "Youtube", "Wikipedia", "Pinterest", "StackOverFlow"));
        list_logo.add(new TestData("Name this logo", R.drawable.spotify, "Youtube", "Facebook", "Wikipedia", "Spotify", "Spotify"));
        list_logo.add(new TestData("Name this logo", R.drawable.vimeo, "Facebook", "Google", "Vimeo", "Vine", "Vimeo"));
        Collections.shuffle(list_logo);
    }

    private void shuffleListAnimal() {
        list_animal = new ArrayList<>(10);
        list_animal.add(new TestData("Name this animal", R.drawable.bear, "Bear", "Fox", "Bull", "Rabbit", "Bear"));
        list_animal.add(new TestData("Name this animal", R.drawable.lion, "Bear", "Lion", "Bull", "Rabbit", "Lion"));
        list_animal.add(new TestData("Name this animal", R.drawable.surikat, "Bear", "Fox", "Suricata", "Wolf", "Suricata"));
        list_animal.add(new TestData("Name this animal", R.drawable.koala, "Lion", "Fox", "Bull", "Koala", "Koala"));
        list_animal.add(new TestData("Name this animal", R.drawable.owl, "Bear", "Owl", "Bull", "Rabbit", "Owl"));
        list_animal.add(new TestData("Name this animal", R.drawable.elephant, "Monkey", "Fox", "Bull", "Elephant", "Elephant"));
        list_animal.add(new TestData("Name this animal", R.drawable.squirrel, "Squirrel", "Fox", "Bear", "Rabbit", "Squirrel"));
        list_animal.add(new TestData("Name this animal", R.drawable.monkey, "Bear", "Wolf", "Monkey", "Bull", "Monkey"));
        list_animal.add(new TestData("Name this animal", R.drawable.bull, "Bear", "Fox", "Bull", "Rabbit", "Bull"));
        list_animal.add(new TestData("Name this animal", R.drawable.rabbit, "Bear", "Wolf", "Bull", "Rabbit", "Rabbit"));
        Collections.shuffle(list_animal);
    }

    private void shuffleListFood() {
        list_food = new ArrayList<>(10);
        list_food.add(new TestData("Name this food", R.drawable.cake, "Cake", "Burger", "Cheese", "Pizza", "Cake"));
        list_food.add(new TestData("Name this food", R.drawable.sausage, "Cake", "Sausage", "Cheese", "Norin", "Sausage"));
        list_food.add(new TestData("Name this food", R.drawable.cheese, "Ice Cream", "Burger", "Cheese", "Pizza", "Cheese"));
        list_food.add(new TestData("Name this food", R.drawable.egg, "Cake", "Burger", "Cheese", "Egg", "Egg"));
        list_food.add(new TestData("Name this food", R.drawable.kebab, "Kebab", "Burger", "Lavash", "Pizza", "Kebab"));
        list_food.add(new TestData("Name this food", R.drawable.stake, "Egg", "Burger", "Stake", "Pizza", "Stake"));
        list_food.add(new TestData("Name this food", R.drawable.palov, "Cake", "Palov", "Cheese", "Milk", "Palov"));
        list_food.add(new TestData("Name this food", R.drawable.pizza, "Egg", "Burger", "Cheese", "Pizza", "Pizza"));
        list_food.add(new TestData("Name this food", R.drawable.milk, "Cake", "Burger", "Milk", "Stake", "Milk"));
        list_food.add(new TestData("Name this food", R.drawable.ice_cream, "Cake", "Ice Cream", "Cheese", "Pizza", "Ice Cream"));
        Collections.shuffle(list_food);
    }

    private void shuffleListFruit() {
        list_fruit = new ArrayList<>(10);
        list_fruit.add(new TestData("Name this fruit", R.drawable.raspberry, "Raspberry", "Grape", "Pineapple", "Cherry", "Raspberry"));
        list_fruit.add(new TestData("Name this fruit", R.drawable.strawberry, "Raspberry", "Strawberry", "Pineapple", "Cherry", "Strawberry"));
        list_fruit.add(new TestData("Name this fruit", R.drawable.watermelon, "Raspberry", "Grape", "Watermelon", "Cherry", "Watermelon"));
        list_fruit.add(new TestData("Name this fruit", R.drawable.grape, "Raspberry", "Grape", "Apple", "Cherry", "Grape"));
        list_fruit.add(new TestData("Name this fruit", R.drawable.apple, "Apple", "Grape", "Pineapple", "Cherry", "Apple"));
        list_fruit.add(new TestData("Name this fruit", R.drawable.cherry, "Watermelon", "Grape", "Pineapple", "Cherry", "Cherry"));
        list_fruit.add(new TestData("Name this fruit", R.drawable.pineapple, "Raspberry", "Grape", "Pineapple", "Raspberry", "Pineapple"));
        list_fruit.add(new TestData("Name this fruit", R.drawable.orange, "Apple", "Grape", "Orange", "Cherry", "Orange"));
        list_fruit.add(new TestData("Name this fruit", R.drawable.fig, "Raspberry", "Grape", "Fig", "Strawberry", "Fig"));
        list_fruit.add(new TestData("Name this fruit", R.drawable.pear, "Raspberry", "Pear", "Pineapple", "Cherry", "Pear"));
        Collections.shuffle(list_fruit);
    }

    private void shuffleListVegetable() {
        list_vegetable = new ArrayList<>(10);
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.potato, "Potato", "Pepper", "Tomato", "Garlic", "Potato"));
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.cabbage, "Pepper", "Potato", "Cabbage", "Garlic", "Cabbage"));
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.onion, "Potato", "Onion", "Cabbage", "Garlic", "Onion"));
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.garlic, "Cabbage", "Pepper", "Tomato", "Garlic", "Garlic"));
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.cucumber, "Potato", "Pepper", "Cucumber", "Eggplant", "Cucumber"));
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.tomato, "Carrot", "Pepper", "Tomato", "Garlic", "Tomato"));
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.carrot, "Potato", "Carrot", "Cucumber", "Garlic", "Carrot"));
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.eggplant, "Potato", "Eggplant", "Tomato", "Pepper", "Eggplant"));
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.pepper, "Potato", "Pepper", "Tomato", "Garlic", "Pepper"));
        list_vegetable.add(new TestData("Name this vegetable", R.drawable.cauiflower, "Potato", "Cauiflower", "Cabbage", "Cucumber", "Cauiflower"));
        Collections.shuffle(list_vegetable);
    }

    public boolean isLastQuestion() {
        return currentPos < MAX_COUNT;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public void setCorrectAns(int correctAns) {
        this.correctCount = correctAns;
    }

    public void setWrongAns(int wrongAns) {
        this.wrongCount = wrongAns;
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


    public void testCheck(String userAnswer) {
        if (currentList == 1) {
            if (list_flag.get(currentPos - 1).getAnswer().toLowerCase(Locale.ROOT).equals(userAnswer.toLowerCase()))
                correctCount++;
            else wrongCount++;

        } else if (currentList == 2) {
            if (list_logo.get(currentPos - 1).getAnswer().toLowerCase(Locale.ROOT).equals(userAnswer.toLowerCase()))
                correctCount++;
            else wrongCount++;

        } else if (currentList == 3) {
            if (list_animal.get(currentPos - 1).getAnswer().toLowerCase(Locale.ROOT).equals(userAnswer.toLowerCase()))
                correctCount++;
            else wrongCount++;

        } else if (currentList == 4) {
            if (list_food.get(currentPos - 1).getAnswer().toLowerCase(Locale.ROOT).equals(userAnswer.toLowerCase()))
                correctCount++;
            else wrongCount++;

        } else if (currentList == 5) {
            if (list_fruit.get(currentPos - 1).getAnswer().toLowerCase(Locale.ROOT).equals(userAnswer.toLowerCase()))
                correctCount++;
            else wrongCount++;

        } else if (currentList == 6) {
            if (list_vegetable.get(currentPos - 1).getAnswer().toLowerCase(Locale.ROOT).equals(userAnswer.toLowerCase()))
                correctCount++;
            else wrongCount++;
        }

    }
}