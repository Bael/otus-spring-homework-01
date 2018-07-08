package ru.otus.spring01.hw.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuestionTest {

    private Question question;

    @Test
    void getWeight() {
    }

    @Test
    void getText() {
    }

    @Test
    void getUserScore() {

        List<AnswerOption> humanOptions = new ArrayList<>();
        humanOptions.add(new AnswerOption("Люди", 0, 1));
        assertEquals(0, question.getUserScore(humanOptions));

        List<AnswerOption> mouseOptions = new ArrayList<>();
        humanOptions.add(new AnswerOption("Мыши", 1, 2));
        assertEquals(0, question.getUserScore(mouseOptions));

    }

    @Test
        // проверяем что коллекцию нельзя изменить по составу элементов
    void getOptions() {
        assertThrows(UnsupportedOperationException.class, () -> question.getOptions().remove(0));
    }

    @BeforeEach
    void setUp() {
        List<AnswerOption> options = new ArrayList<>();
        options.add(new AnswerOption("Люди", 0, 1));
        options.add(new AnswerOption("Дельфины", 0, 2));
        options.add(new AnswerOption("Мыши", 1, 3));
        options.add(new AnswerOption("Верблюды", 0, 4));

        question = new Question(10, "Назовите самых разумных созданий на земле согласно кнгие 'Автостопом по галактике' Дугласа Адамса.", options, 1);

    }

    @AfterEach
    void tearDown() {
    }
}