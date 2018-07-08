package ru.otus.spring01.hw.ui;

import ru.otus.spring01.hw.domain.AnswerOption;
import ru.otus.spring01.hw.domain.ExamResult;
import ru.otus.spring01.hw.domain.Question;

import java.util.List;

public interface ExamUI {

    String getUserName();

    List<AnswerOption> askQuestion(Question q);

    void reportResult(ExamResult result);

}
