package com.neuedu.project.domain;

public class Arrangement {

    private int testId;
    private String startTime;
    private int duration;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Arrangement(int testId, String startTime, int duration) {
        this.testId = testId;
        this.startTime = startTime;
        this.duration = duration;
    }
    public Arrangement(){

    }

    @Override
    public String toString() {
        return "Arrangement{" +
                "testId=" + testId +
                ", startTime='" + startTime + '\'' +
                ", duration=" + duration +
                '}';
    }
}
