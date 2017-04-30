package com.example.practice;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class Synchronization {

    public static void main(String[] args) throws InterruptedException {
        final Incementer target = new Incementer();
        final Thread t1 = new Thread(target);
        t1.start();
        final Thread t2 = new Thread(target);
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Processing count="+target.getCounter());
    }
}

class Incementer implements Runnable {
    int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter++);
        }
    }
}