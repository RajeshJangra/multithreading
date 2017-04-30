package com.example.practice;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class SimpleThread {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello World")).start();
    }
}
