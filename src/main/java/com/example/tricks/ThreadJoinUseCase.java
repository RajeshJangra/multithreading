package com.example.tricks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajeshkumar on 01/05/17.
 */

class ThreadJoinUseCase {
    public static void main(String... args) throws InterruptedException {
        //Makes sure each thread started first ends first. Not a good way to doing things though
        System.out.println("Start");
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("\tStarting: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println("\tExecuting: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\tEnding: " + Thread.currentThread().getName() + "\n");
        };
        List<Thread> threads = new ArrayList<>(5);

        for (int counter = 0; counter < 5; counter++) {
            threads.add(new Thread(runnable));
        }

        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }

        System.out.println("The End");
    }
}
