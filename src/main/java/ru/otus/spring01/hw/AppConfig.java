package ru.otus.spring01.hw;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.spring01.hw.dao.QuestionDAO;
import ru.otus.spring01.hw.dao.QuestionDAOCSVImpl;

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan("ru.otus.spring01.hw")
public class AppConfig {


    // чтение application.properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public QuestionDAO questionDAO() {
        return new QuestionDAOCSVImpl();
    }

    // i18n
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("i18n/bundle");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
