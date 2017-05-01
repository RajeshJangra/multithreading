package com.example.practice.executorservice;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callableSet = new HashSet<>();

        callableSet.add(() -> {
            System.out.println("Running Task 1");
            throw new Exception("Task 1");
        });
        callableSet.add(() -> {
            System.out.println("Running Task 2");
            throw new Exception("Task 2");
        });
        callableSet.add(() -> {
            System.out.println("Running Task 3");
            Thread.sleep(2000);
            return "Task 3";
        });

        String result = executorService.invokeAny(callableSet);

        // Only task 3 result will be returned, exception will not show
        System.out.println("result = " + result);

/*      // All three will execute and exception will show
        List<Future<String>> futures = executorService.invokeAll(callableSet);

        for (Future<String> future: futures) {
            System.out.println("result = " + future.get());
        }*/

        executorService.shutdown();
    }
}
