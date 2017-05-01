package com.example.practice.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class ExecutorServiceRunnableSubmit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future result = executorService.submit((() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Running Task 1");
        }));


        System.out.println("result = " + result.isDone());
        Thread.sleep(3000);
        System.out.println("result = " + result.isDone());

        executorService.shutdown();
    }
}
