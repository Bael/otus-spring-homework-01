package ru.otus.spring01.hw.domain;

public class ExamResult {


    private final double rate;
    private final double successRate;

    ExamResult(double rate, double successRate) {

        this.rate = rate;
        this.successRate = successRate;

    }

    public Boolean IsPassed() {
        return rate > successRate;
    }

    public double getRate() {
        return rate;
    }

    public double getSuccessRate() {
        return successRate;
    }

}
