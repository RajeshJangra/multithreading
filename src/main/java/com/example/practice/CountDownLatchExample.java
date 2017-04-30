package com.example.practice;

import java.util.concurrent.CountDownLatch;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        final Thread worker = new Thread(new Worker(countDownLatch), "Worker");
        worker.start();
        final Thread countDowner = new Thread(new CountDowner(countDownLatch), "Count Downer");
        countDowner.start();

        worker.join();
        countDowner.join();
    }
}

class Worker implements Runnable {
    CountDownLatch countDownLatch;

    public Worker(final CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Latch is open now");
    }
}

class CountDowner implements Runnable {
    CountDownLatch countDownLatch;

    public CountDowner(final CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
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
    }
}
