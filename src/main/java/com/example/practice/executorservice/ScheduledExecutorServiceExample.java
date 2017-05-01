package com.example.practice.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class ScheduledExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        final Runnable runnable = () -> {
            System.out.println("Running Task 1");
        };

        executorService.scheduleAtFixedRate(runnable, 2, 2, TimeUnit.SECONDS);

        Thread.sleep(20000);
        executorService.shutdown();
    }
}
