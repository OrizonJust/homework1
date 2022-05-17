package edu.laverno.domain;

public class Answer {

    private final String name;
    private final String rightAnswer;

    public Answer(String name, String rightAnswer) {
        this.name = name;
        this.rightAnswer = rightAnswer;
    }

    public String getName() {
        return name;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public String toString() {
        return name + ": " + rightAnswer;
    }
}
