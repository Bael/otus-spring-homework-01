package ru.otus.spring01.hw.service;

import org.springframework.stereotype.Service;
import ru.otus.spring01.hw.dao.QuestionDAO;
import ru.otus.spring01.hw.domain.AnswerOption;
import ru.otus.spring01.hw.domain.Exam;
import ru.otus.spring01.hw.domain.Question;
import ru.otus.spring01.hw.ui.ExamUI;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private QuestionDAO questionDAO;

    private ExamUI examUI;

    public ExamServiceImpl(QuestionDAO questionDAO, ExamUI examUI) {

        this.questionDAO = questionDAO;
        this.examUI = examUI;
    }


    @Override
    public void examine() {

        String userName = examUI.getUserName();

        List<Question> questions = this.questionDAO.loadQuestions();
        Exam exam = new Exam(userName, questions);

        while (exam.hasNext()) {
            Question q = exam.getNext();
            List<AnswerOption> answerOptions = examUI.askQuestion(q);
            exam.putUserAnswers(q, answerOptions);
        }

        examUI.reportResult("Тест закончен. Ваш результат: " + exam.getPercentScore() + "%");

    }

}
