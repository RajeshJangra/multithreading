package com.example.practice;

import java.util.Date;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class ThreadLocalExample {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(new LocalDate(), "Thread " + i).start();
            Thread.sleep(1000);
        }
    }
}

class LocalDate implements Runnable {
    private ThreadLocal<Date> localDate = ThreadLocal.withInitial(() -> new Date());

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " localDate before change = " + localDate.get().getTime());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        localDate.set(new Date());
        System.out.println(Thread.currentThread().getName() + " localDate after change  = " + localDate.get().getTime());
    }
}
