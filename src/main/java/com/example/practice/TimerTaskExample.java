package com.example.practice;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class TimerTaskExample {
    public static void main(String[] args) throws InterruptedException {

        TimerTask timerTask = new TimerTask() {
            private int counter = 0;

            @Override
            public void run() {
                System.out.println("Task: " + counter + " started");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task: " + counter + " ended");
                counter++;
            }
        };

        TimerTask timerTask2 = new TimerTask() {
            private int counter = 0;

            @Override
            public void run() {
                System.out.println("2 Task: " + counter + " started");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2 Task: " + counter + " ended");
                counter++;
            }
        };

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
        timer.scheduleAtFixedRate(timerTask2, 0, 1000);

        System.out.println("Task Started");
        Thread.sleep(30 * 1000);
        timer.cancel();
        System.out.println("All Tasks Done, Make sure each task is started and ended without any other task interjecting");
    }
}