package ru.otus.spring01.hw.service;

import ru.otus.spring01.hw.dao.QuestionDAO;
import ru.otus.spring01.hw.domain.Exam;
import ru.otus.spring01.hw.domain.Question;

import java.util.List;

public class ExamServiceImpl implements ExamService {

    private QuestionDAO questionDAO;

    public ExamServiceImpl(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    public Exam prepareExam(String userName) {
        List<Question> questions = this.questionDAO.loadQuestions();
        return new Exam(userName, questions);


    }
}
