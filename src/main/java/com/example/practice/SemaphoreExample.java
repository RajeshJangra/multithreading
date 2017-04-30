package com.example.practice;

import java.util.concurrent.Semaphore;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        new Thread(() -> {
            System.out.println("Available Permits: " + semaphore.availablePermits());
            try {
                semaphore.acquire(2);
                System.out.println("two permits acquired");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println("One permit released");
        }).start();

        new Thread(() -> {
            System.out.println("Available Permits: " + semaphore.availablePermits());
            boolean tryAcquire = semaphore.tryAcquire(1);
            System.out.println("tried acquiring " + (tryAcquire ? "Successfully" : "Unsuccessfully"));
            if(semaphore.hasQueuedThreads()){
                System.out.println("Queued Threads");
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tryAcquire = semaphore.tryAcquire(1);
            System.out.println("tried acquiring " + (tryAcquire ? "Successfully" : "Unsuccessfully"));
        }).start();
    }
}
