package com.example.practice;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class Synchronization {

    public static void main(String[] args) throws InterruptedException {
        final Runnable target = new Runnable() {
            private int counter = 0;

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(100);
                        System.out.println(counter++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        final Thread t1 = new Thread(target);
        t1.start();
        final Thread t2 = new Thread(target);
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Counter should be 38 but it will not be");
    }
}
