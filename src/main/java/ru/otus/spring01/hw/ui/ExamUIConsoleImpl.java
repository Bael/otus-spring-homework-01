package ru.otus.spring01.hw.ui;

import ru.otus.spring01.hw.domain.AnswerOption;
import ru.otus.spring01.hw.domain.Question;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamUIConsoleImpl implements ExamUI {

    private Scanner in;
    private String userName;

    @Override
    public String getUserName() {

        in = new Scanner(System.in);
        System.out.println("Добро пожаловать в систему тестирования!");

        do {
            System.out.print("Пожалуйста укажите свое имя(не пустое):");
            userName = in.nextLine();
        } while (userName.trim().equals(""));
        return userName;
    }

    /// извлекаем выбранные опции
    private List<AnswerOption> parseAnswer(Question q, String input) {

        Set<Long> answers = Stream.of(input.split(",")).map(Long::parseLong).collect(Collectors.toSet());

        return q.getOptions().stream()
                .filter(answerOption -> answers.contains(answerOption.getId()))
                .collect(Collectors.toList());
    }


    @Override
    public List<AnswerOption> askQuestion(Question q) {
        String input = getAnswer(q);
        return parseAnswer(q, input);
    }

    private String getAnswer(Question question) {
        String input;
        do {
            printQuestion(question);
            input = in.nextLine();
            if (isValid(input, question)) {
                break;
            } else {
                System.out.print("Нужно перечислить варианты ответа через запятую. Например 1,2. Попробуйте еще раз.\r \n");
            }
        } while (true);

        return input;
    }


    /// верной считаем строку с перечислением номеров через запятую
    private boolean isValid(String input, Question question) {
        if (input.equals(""))
            return false;

        // to do add checking max available count

        return input.replace(" ", "").matches("(\\d,)*\\d,?");
    }


    private void printQuestion(Question question) {
        System.out.println("Вопрос: " + question.getText());
        System.out.println(String.format("Выберите варианты(%d верных):", question.getAvailableOptionsCount()));
        question.getOptions().forEach(answerOption -> System.out.println(answerOption.toString()));
    }

    @Override
    public void reportResult(String result) {
        System.out.println(result);
    }
}
