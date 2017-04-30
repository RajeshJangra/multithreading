package com.example.practice;

/**
 * Created by rajeshkumar on 30/04/17.
 */
public class ThreadLockExample {

    public static void main(String[] args) {
        String o1 = "11", o2 = "22";
        new Thread(new ThreadLock(o1, o2), "Thread 1").start();
        new Thread(new ThreadLock(o2, o1), "Thread 2").start();
    }
}

class ThreadLock implements Runnable {
    String o1, o2;

    public ThreadLock(final String o1, final String o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " Got Lock On: " + o1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + " Got Lock On: " + o2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(3000);
                    System.out.println("Executed: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
