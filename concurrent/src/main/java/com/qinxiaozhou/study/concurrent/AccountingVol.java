package com.qinxiaozhou.study.concurrent;

/**
 * @Author MoonLion
 * @Date Create in 2018/1/8 0008
 * @Description
 */
public class AccountingVol implements Runnable {

    private static AccountingVol instance = new AccountingVol();
    private static volatile int i = 0;

    public static void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
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
