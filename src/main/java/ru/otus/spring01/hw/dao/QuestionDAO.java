package ru.otus.spring01.hw.dao;

import ru.otus.spring01.hw.domain.Question;

import java.util.List;

public interface QuestionDAO {

    List<Question> loadQuestions();
}
