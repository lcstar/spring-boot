package com.lc.thread;

/**
 * Created by lc
 * createTime 2019/1/19.
 */
public class PlusTask implements Runnable {
    public static Integer j = 0;
    public synchronized void add(){
        for (int i = 0; i < 10000; i++) {
            j++;
        }
    }


    @Override
    public void run() {
        synchronized (PlusTask.class) {
            add();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        PlusTask task = new PlusTask();
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(j);
    }
}
