package com.example.practice.forkjoin.recursivetask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by rajeshkumar on 01/05/17.
 */
public class RecursiveTaskExample {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        final String result = forkJoinPool.invoke(new RecursiveTaskImpl(getWorkList()));
        System.out.println("result = " + result);
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

class RecursiveTaskImpl extends RecursiveTask<String> {
    List workList;

    public RecursiveTaskImpl(final List workList) {
        this.workList = workList;
    }

    @Override
    protected String compute() {
        String result = "";
        if (workList.size() > 1) {
            final int half = workList.size() / 2;
            List<RecursiveTaskImpl> tasks = new ArrayList<>(2);
            tasks.add(new RecursiveTaskImpl(workList.subList(0, half)));
            tasks.add(new RecursiveTaskImpl(workList.subList(half, workList.size())));

            for (RecursiveTask task : tasks) {
                task.fork();
            }

            for (RecursiveTask task : tasks) {
                result += task.join();
            }
        } else {
            result += "\nworkList: " + workList.get(0);
        }
        return result;
    }
}
