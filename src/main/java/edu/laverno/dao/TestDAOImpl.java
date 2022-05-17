package edu.laverno.dao;

import edu.laverno.domain.Answer;
import edu.laverno.domain.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDAOImpl implements TestDAO {

    private final String path;

    public TestDAOImpl(String path) {
        this.path = path;
    }

    @Override
    public List<Question> getQuestion() {
        try (BufferedReader br = new BufferedReader(new FileReader(path + "/test.csv"))) {
            String row;
            List<Question> list = new ArrayList<>();
            while ((row = br.readLine()) != null) {
                String[] data = row.split(",");

                if (!data[0].equals("QUESTION"))
                    list.add(new Question(data[0], data[1], data[2], data[3]));

            }

            return list;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public List<Answer> getAnswer() {
        try (BufferedReader br = new BufferedReader(new FileReader(path + "/answer.csv"))) {
            String row;
            List<Answer> list = new ArrayList<>();

            while ((row = br.readLine()) != null) {
                String[] data = row.split(",");
                if (!data[0].equals("QUESTION"))
                    list.add(new Answer(data[0], data[1]));

            }

            return list;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return new ArrayList<>();
    }
}
