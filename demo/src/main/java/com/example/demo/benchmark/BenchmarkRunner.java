package com.example.demo.benchmark;

import com.example.demo.Timing.*;
import com.example.demo.benchmark.cpu.fixedpoint.CPUDhrystone;
import com.example.demo.benchmark.cpu.floatingpoint.CPUDigitsOfPi;
import com.example.demo.benchmark.cpu.threading.CPUThreading;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;


public class BenchmarkRunner {

    private double piScore;
    private double threadingScore;
    private double dhrystoneScore;
    private double totalScore;
    @FXML
    public void runBenchmarks(boolean pi, boolean threading, boolean dhrystone) {

        double piTime = 0;
        double threadingTime = 0;
        double dhrystoneTime = 0;

        piScore = 0;
        threadingScore = 0;
        dhrystoneScore = 0;
        totalScore = 0;

        ITimer timer = new Timer();
        int counter = 0;

        if (pi) {
            counter++;
            IBenchmark b = new CPUDigitsOfPi();

            b.initialize(50000);
            b.warmUp();

            int i;
            double sum = 0;
            for (i = 0; i < 10; i++) {
                timer.start();
                b.run();
                sum += (double) timer.stop() /1000000;
            }

            piTime = sum / i;

            double min = 500; // Worst running time (ms) scenario
            double max = 180; // Best running time (ms) scenario

            piScore = computeScore(piTime, min, max);
            piScore = validateScore(piScore);

        }

        if (threading) {
            counter++;
            IBenchmark b = new CPUThreading();
            b.initialize(10000000);
            b.warmUp(4);

            int i;
            double localTime = 0;
            double sum = 0;
            for (i = 0; i < 5; i++) {
                localTime = 0;
                for (int threads = 1; threads <= 8; threads *= 2) {
                    timer.start();
                    b.run(Integer.valueOf(threads));
                    localTime += (double) timer.stop() / 1000000;
                }
                sum += localTime / 4;
            }

            threadingTime = sum / i;

            double min = 2800; // Worst running time (ms) scenario
            double max = 500; // Best running time (ms) scenario
            threadingScore = computeScore(threadingTime, min, max);
            threadingScore = validateScore(threadingScore);
        }

        if (dhrystone) {
            counter++;
            IBenchmark b = new CPUDhrystone();
            b.initialize(10000000);
            b.warmUp();

            double sum = 0;
            int i = 0;
            for (i = 0; i < 10; i++) {
                timer.start();
                b.run();
                sum += (double) timer.stop() / 1000000;
            }

            dhrystoneTime = sum / i;

            double min = 700; // Worst running time (ms) scenario
            double max = 270; // Best running time (ms) scenario
            dhrystoneScore = computeScore(dhrystoneTime, min, max);
            dhrystoneScore = validateScore(dhrystoneScore);
        }

        if (counter == 0)
            throw new IllegalArgumentException();
        totalScore = (piScore + threadingScore + dhrystoneScore) / counter;
    }

    private double computeScore(double runningTime, double min, double max) {
        return ((10 - 1) * (runningTime - min) / (max - min)) + 1;
    }


    /**
     * Make sure that score is between 1 and 10
     */
    private double validateScore(double piScore) {

        if (piScore > 10)
            return 10;
        if (piScore < 1)
            return 1;


        return piScore;
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

    public double getTotalScore() {
        return totalScore;
    }
}
