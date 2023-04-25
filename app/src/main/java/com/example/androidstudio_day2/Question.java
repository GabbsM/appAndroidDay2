package com.example.androidstudio_day2;

// Este es nuestro modelo:

public class Question {

    private String questionTitle;
    private boolean answer ;
    private int points;


    public Question(String questionTitle, boolean answer, int points) {
        this.questionTitle = questionTitle;
        this.answer = answer;
        this.points = points;

    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public boolean answerIsTrue() {
        return answer;
    }

    public int getPoints(){
        return points;
    }
}
