package ru.otus.spring01.hw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.hw.service.ExamService;

public class Main {
    public static void main(String[] args) {
        try {

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

            ExamService examService = context.getBean(ExamService.class);
            examService.examine();


        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }
}
