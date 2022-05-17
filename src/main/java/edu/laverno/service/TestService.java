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
        System.out.println("Hello, dear student!\nTest:");

        Scanner scr = new Scanner(System.in);

        List<Question> questionList = dao.getQuestion();
        List<Integer> answers = new ArrayList<>();

        for (Question question : questionList) {
            System.out.println(question.toString());
            System.out.print("Your answer is: ");
            answers.add(scr.nextInt());
        }

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
