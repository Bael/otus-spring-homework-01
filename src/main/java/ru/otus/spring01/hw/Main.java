package ru.otus.spring01.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring01.hw.service.ExamService;

public class Main {

    public static void main(String[] args) {
        try {

            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            ExamService examService = context.getBean(ExamService.class);
            examService.examine();
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }
}
