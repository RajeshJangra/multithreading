package com.example.practice;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class Join {
    public static void main(String[] args) {
        final Thread t1 = new Thread(() -> {
            try {
                System.out.println("Great");
                Thread.sleep(2000);
                System.out.println("People");
            } catch (InterruptedException e) {
                System.out.println("Error occurred");
            }
        });

        System.out.println("Hello");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Error occurred while joining");
        }
        System.out.println("World");
        //final Thread t2 = new Thread(() -> System.out.println("Hello World"));

    }

}
