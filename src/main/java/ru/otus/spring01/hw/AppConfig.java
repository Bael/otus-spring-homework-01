package ru.otus.spring01.hw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring01.hw.dao.QuestionDAO;
import ru.otus.spring01.hw.dao.QuestionDAOCSVImpl;
import ru.otus.spring01.hw.ui.ExamUI;
import ru.otus.spring01.hw.ui.ExamUIConsoleImpl;

@Configuration
@ComponentScan("ru.otus.spring01.hw")
public class AppConfig {

    @Bean
    public ExamUI examUI() {
        return new ExamUIConsoleImpl();
    }

    @Bean
    public QuestionDAO questionDAO() {
        return new QuestionDAOCSVImpl();
    }

}
