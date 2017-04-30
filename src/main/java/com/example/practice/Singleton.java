package com.example.practice;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class Singleton {

    private static volatile Singleton instance = null;
    private static Object lock = new Object();

    private Singleton() {
    }

    private static Singleton getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance != null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
