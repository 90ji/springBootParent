package com.qinxiaozhou.study.concurrent;

/**
 * @Author MoonLion
 * @Date Create in 2018/1/12 0012
 * @Description
 */
public class ReenterLock implements Runnable {
//    private static ReentrantLock lock = new ReentrantLock();
//    private static Condition condition = lock.newCondition();
//    private static Semaphore semaphore = new Semaphore();
//    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
//    private static Lock readLock  = reentrantReadWriteLock.readLock();
//    private static Lock writeLock  = reentrantReadWriteLock.writeLock();
//
//    private static CountDownLatch countDownLatch = new CountDownLatch(10);
//    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);


    private static int i = 0;

    @Override
    public void run() {

    }

    public static void main(String[] args) {
    }
}
