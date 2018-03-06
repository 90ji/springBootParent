package com.qinxiaozhou.study.concurrent;

/**
 * @Author MoonLion
 * @Date Create in 2018/1/8 0008
 * @Description
 */
public class AccountingSync implements Runnable {

    private static AccountingSync instance = new AccountingSync();
    private static int i = 0;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int j = 0; j < 10000000; j++) {
            synchronized (instance) {
                i++;
            }
        }
        long end = System.currentTimeMillis() - start;
        System.out.println(end);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
