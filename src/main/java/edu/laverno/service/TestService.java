package edu.laverno.service;

import edu.laverno.dao.TestDAO;
import edu.laverno.domain.Answer;
import edu.laverno.domain.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestService {

    private final TestDAO dao;

    public TestService(TestDAO dao) {
        this.dao = dao;
    }

    public void startTesting() {
        Scanner scr = new Scanner(System.in);
        String name = scr.nextLine();

        System.out.println("Hello, " + name + "!\nTest:");

        List<Question> questionList = dao.getQuestion();
        List<Integer> answers = new ArrayList<>();

        for (Question question : questionList) {
            System.out.println(question.toString());
            System.out.print("Your answer is: ");
            answers.add(scr.nextInt());
        }

        System.out.print("Student " + name + "\n");
        System.out.println(checkAnswers(answers) + "/" + questionList.size());
    }

    private int checkAnswers(List<Integer> answers) {
        int correct = 0;
        List<Answer> rightAnswers = dao.getAnswer();

        for (int i = 0; i < rightAnswers.size(); i++) {
            if (rightAnswers.get(i).getRightAnswer().equals(String.valueOf(answers.get(i))))
                correct++;
        }

        return correct;
    }
}
