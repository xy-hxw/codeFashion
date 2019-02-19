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
 */
public class TestReentrantReadWriteLock<T> {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Object obj = null;

    private void write (Object t) {
        try {
            lock.writeLock().lock();
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
            System.out.println("read" + obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    private static void test () {
        TestReentrantReadWriteLock readWriteLock = new TestReentrantReadWriteLock();
        ScheduledThreadPoolExecutor threadPoolExecutor = TestThreadFactory.testThreadFactoryBuilder();
        int num = 10;
        for (int i = 0; i < num; i++) {
            threadPoolExecutor.submit(()-> readWriteLock.write(ThreadLocalRandom.current().nextInt(10000)));
        }
        for (int i = 0; i < num; i++) {
            threadPoolExecutor.submit(readWriteLock::read);
        }
    }

    private static void sleep () {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
        sleep();
    }
}
