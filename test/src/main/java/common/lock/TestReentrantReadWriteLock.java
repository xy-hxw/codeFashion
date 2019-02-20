package common.lock;

import common.thread.pool.TestThreadFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author huoxianwei
 * @date 2019/2/19 18:01
 * ReentrantReadWriteLock 读锁和写锁分离
 */
public class TestReentrantReadWriteLock<T> {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Object obj = null;

    private void write (Object t) {
        try {
            lock.writeLock().lock();
            sleep(2);
            System.out.println("write "+ t);
            this.obj = t;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void read () {
        try {
            lock.readLock().lock();
            sleep(1);
            System.out.println("read " + obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    private static void test () {
        TestReentrantReadWriteLock readWriteLock = new TestReentrantReadWriteLock();
        ScheduledThreadPoolExecutor threadPoolExecutor = TestThreadFactory.testThreadFactoryBuilder();
        int num = 5;
        for (int i = 0; i < num; i++) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                threadPoolExecutor.submit(()-> {
                    for (int j = 0; j < num; j++) {
                        readWriteLock.write(ThreadLocalRandom.current().nextInt(10000));
                    }
                });
            } else {
                threadPoolExecutor.submit(()-> {
                    for (int j = 0; j < num; j++) {
                        readWriteLock.read();
                    }
                });
            }
        }
    }

    private static void sleep (int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
        sleep(10);
    }
}
