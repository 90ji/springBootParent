package com.qinxiaozhou.study.concurrent;

import java.util.ArrayList;

/**
 * @Author MoonLion
 * @Date Create in 2018/1/8 0008
 * @Description
 */
public class ArrayListMultiThread {
    private static ArrayList<Integer> al = new ArrayList<>();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread());
        Thread thread2 = new Thread(new AddThread());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(al.size());
    }
}
