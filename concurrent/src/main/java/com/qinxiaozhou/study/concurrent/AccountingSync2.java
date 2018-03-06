package com.qinxiaozhou.study.concurrent;

/**
 * @Author MoonLion
 * @Date Create in 2018/1/8 0008
 * @Description
 */
public class AccountingSync2 implements Runnable {

    private static AccountingSync2 instance = new AccountingSync2();
    private static int i = 0;

    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int j = 0; j < 10000000; j++) {
            increase();
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
