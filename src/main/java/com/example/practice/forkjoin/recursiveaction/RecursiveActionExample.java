package com.example.practice.forkjoin.recursiveaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class RecursiveActionExample {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(new RecursiveActionImpl(getWorkList()));
        forkJoinPool.shutdown();
        try {
            forkJoinPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List getWorkList() {
        List workList = new ArrayList(100);
        for (int counter = 0; counter < 100; counter++) {
            workList.add("Task: " + counter);
        }
        return workList;
    }
}

class RecursiveActionImpl extends RecursiveAction {
    List workList;

    public RecursiveActionImpl(final List workList) {
        this.workList = workList;
    }

    @Override
    protected void compute() {
        if (workList.size() > 1) {
            final int half = workList.size() / 2;
            new RecursiveActionImpl(workList.subList(0, half)).fork();
            new RecursiveActionImpl(workList.subList(half, workList.size())).fork();
        } else {
            System.out.println("workList: " + workList.get(0));
        }
    }
}
