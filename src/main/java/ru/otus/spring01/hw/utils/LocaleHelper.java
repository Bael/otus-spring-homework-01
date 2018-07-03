package ru.otus.spring01.hw.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocaleHelper {

    public static final String TEXT_WELCOME = "test.welcome";
    public static final String TEXT_ASK_USER_NAME = "test.askUserName";
    public static final String TEXT_SHOW_RULES_OF_ANSWER = "test.showRulesOfAnswering";
    public static final String TEXT_QUESTION = "test.questionName";
    public static final String TEXT_ASK_SELECT_OPTIONS = "test.askSelectOptions";
    public static final String TEXT_REPORT_SUCESS_RESULT = "test.reportSucessResult";
    public static final String TEXT_REPORT_FAILURE_RESULT = "test.reportFailureResult";
    private final Locale locale;
    private final MessageSource messageSource;

    @Autowired
    private LocaleHelper(@Value("${locale}") String localeString, MessageSource messageSource) {
        this.locale = detectLocale(localeString);
        this.messageSource = messageSource;
    }

    private Locale detectLocale(String localeString) {
        switch (localeString.toLowerCase()) {
            case "en":
                return Locale.ENGLISH;
            case "ru":
                return new Locale("RU");
            default:
                return new Locale("RU");
        }
    }

    public String getLocalizedMessage(String messageType, String[] params) {
        return messageSource.getMessage(messageType, params, locale);
    }

}
