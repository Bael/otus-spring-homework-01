package ru.otus.spring01.hw.dao;

import org.junit.jupiter.api.Test;
import ru.otus.spring01.hw.domain.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionDAOCSVImplTest {

    @Test
    void loadQuestions() {

        QuestionDAOCSVImpl impl = new QuestionDAOCSVImpl();

        ArrayList<String[]> input = new ArrayList<>();
        input.add("Тип строки, текст, вес (вопроса в целом или выбранного варианта ответа), максимальное количество вариантов выбора".split(","));

        input.add("Question, 2+2, 1, 1".split(","));
        input.add(", 4, 1".split(","));
        input.add(", 14, 0".split(","));
        input.add(", 1, 0".split(","));

        input.add("Question, Земля какая по счету планета от солнца?, 1, 1".split(","));
        input.add(", 4, 0".split(","));
        input.add(", 3, 1".split(","));
        input.add(", 1, 0".split(","));


        input.add("Question, Могут ли наследоваться интерфейсы в Java?, 1, 1".split(","));
        input.add(", Да, 1".split(","));
        input.add(", Нет, 0".split(","));


        List<Question> questions = impl.getQuestions(input);
        assertEquals(3, questions.size());

        assertEquals(3, questions.get(0).getOptions().size());

    }
}