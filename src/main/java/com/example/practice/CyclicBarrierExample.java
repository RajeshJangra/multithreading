package com.example.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        final Thread barrierAction = new Thread(() -> {
            System.out.println("Barrier is raised, welcome to dream land!");
        });

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, barrierAction);
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread one is awaiting at barrier");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread two is awaiting at barrier");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
