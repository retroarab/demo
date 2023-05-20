package com.example.demo;

public class DataObject {
    private String computerName;
    private double piScore;
    private double threadingScore;
    private double dhrystoneScore;

    public DataObject(String computerName, double piScore, double threadingScore, double dhrystoneScore) {
        this.computerName = computerName;
        this.piScore = piScore;
        this.threadingScore = threadingScore;
        this.dhrystoneScore = dhrystoneScore;
    }

    public String getComputerName() {
        return computerName;
    }

    public double getPiScore() {
        return piScore;
    }

    public double getThreadingScore() {
        return threadingScore;
    }

    public double getDhrystoneScore() {
        return dhrystoneScore;
    }
}
