package ru.otus.spring01.hw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.hw.service.ExamService;
import ru.otus.spring01.hw.ui.ExamUI;

public class Main {
    public static void main(String[] args) {
        try {

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

            ExamService examService = context.getBean(ExamService.class);

            ExamUI ui = context.getBean(ExamUI.class);

            ui.examine(examService);


        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }
}
