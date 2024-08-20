package com.minesaber.interview.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Minesaber
 *
 * <p>两个线程交替打印数字
 */
public class AlternatingThreadPrinter {
    static final int MAX_COUNT = 100;
    static int printCount = 0;

    /**
     * 方法一：使用 ReentrantLock 和 Condition
     */
    static void ReentrantLockAndCondition() {
        int[] count = {1};
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Thread t1 = new Thread(() -> {
            while (count[0] <= MAX_COUNT) {
                lock.lock();
                try {
                    if (count[0] % 2 == 1) {
                        printAndCheck("Thread 1", count[0]++);
                        condition2.signal();
                    } else
                        condition1.await();
                } catch (InterruptedException ignored) {
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (count[0] <= MAX_COUNT) {
                lock.lock();
                try {
                    if (count[0] % 2 == 0) {
                        printAndCheck("Thread 2", count[0]++);
                        condition1.signal();
                    } else
                        condition2.await();
                } catch (InterruptedException ignored) {
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * 方法二：使用 Synchronized 和 wait/notify
     */
    static void SynchronizedAndWaitNotify() {
        int[] count = {1};
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (count[0] <= MAX_COUNT) {
                    try {
                        if (count[0] % 2 == 1) {
                            printAndCheck("Thread 1", count[0]++);
                            lock.notify();
                        } else
                            lock.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                while (count[0] <= MAX_COUNT) {
                    try {
                        if (count[0] % 2 == 0) {
                            printAndCheck("Thread 2", count[0]++);
                            lock.notify();
                        } else
                            lock.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * 方法三：使用 Semaphore
     */
    static void SemaphoreExample() {
        int[] count = {1};
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);
        Thread t1 = new Thread(() -> {
            while (count[0] <= MAX_COUNT) {
                try {
                    semaphore1.acquire();
                    if (count[0] <= MAX_COUNT) {
                        printAndCheck("Thread 1", count[0]++);
                    }
                    semaphore2.release();
                } catch (InterruptedException ignored) {
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (count[0] <= MAX_COUNT) {
                try {
                    semaphore2.acquire();
                    if (count[0] <= MAX_COUNT) {
                        printAndCheck("Thread 2", count[0]++);
                    }
                    semaphore1.release();
                } catch (InterruptedException ignored) {
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * 打印数字并检查是否需要换行
     */
    private static void printAndCheck(String threadName, int num) {
        System.out.print(threadName + "：" + num + "|");
        printCount++;
        if (printCount % 10 == 0)
            System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("方法一：使用 ReentrantLock 和 Condition");
        ReentrantLockAndCondition();
        System.out.println("方法二：使用 Synchronized 和 wait/notify");
        SynchronizedAndWaitNotify();
        System.out.println("方法三：使用 Semaphore");
        SemaphoreExample();
    }
}