package com.example.practice.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class LockExample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        final Account account = new Account();
        for (int counter = 0; counter < 100; counter++) {
            executorService.submit(new Thread(() -> account.debit(10), "D1-" + counter));
            executorService.submit(new Thread(() -> account.debit(10), "D2-" + counter));
            executorService.submit(new Thread(() -> account.debit(10), "D3-" + counter));
            executorService.submit(new Thread(() -> account.credit(10)));
            executorService.submit(new Thread(() -> account.credit(10)));
        }

        executorService.shutdown();

        executorService.awaitTermination(60, TimeUnit.SECONDS);

        while (executorService.isTerminated()) {
            System.out.println("account.getAmount() = " + account.getAmount());
            break;
        }


    }
}

class Account {
    int amount = 30;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int getAmount() {
        return amount;
    }

    public void credit(final int credit) {
        readWriteLock.writeLock().lock();
        this.amount += credit;
        readWriteLock.writeLock().unlock();
    }

    public void debit(final int debit) {
        readWriteLock.writeLock().lock();
        if (amount >= debit) {
            System.out.println(Thread.currentThread().getName() + " amount before debit = " + amount);
            this.amount -= debit;
            System.out.println(Thread.currentThread().getName() + " amount after debit = " + amount);
        }
        readWriteLock.writeLock().unlock();
    }
}
