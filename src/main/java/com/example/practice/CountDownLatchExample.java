package com.example.practice;

import java.util.concurrent.CountDownLatch;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class CountDownLatchExample {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            System.out.println("Worker is awaiting at the latch");
            try {
                countDownLatch.await();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Latch is down, start working!");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                countDownLatch.countDown();
                System.out.println("Count Down dropped, Current value: " + countDownLatch.getCount());
                Thread.sleep(1000);
                countDownLatch.countDown();
                System.out.println("Count Down dropped, Current value: " + countDownLatch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
