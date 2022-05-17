package edu.laverno.dao;

import edu.laverno.domain.Answer;
import edu.laverno.domain.Question;

import java.util.List;

public interface TestDAO {

    List<Question> getQuestion();

    List<Answer> getAnswer();
}
