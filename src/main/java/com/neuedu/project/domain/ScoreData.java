package com.neuedu.project.domain;

public class ScoreData {

    private int testId;

    private double average;

    private double max;

    private double min;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public ScoreData(int testId, double average, double max, double min) {
        this.testId = testId;
        this.average = average;
        this.max = max;
        this.min = min;
    }

    public ScoreData(){

    }

    @Override
    public String toString() {
        return "ScoreData{" +
                "testId=" + testId +
                ", average=" + average +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
