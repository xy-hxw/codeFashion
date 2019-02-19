package common.lock;

import common.thread.pool.TestThreadFactory;

import java.util.LinkedList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huoxianwei
 * @date 2019/2/19 14:18
 */
public class TestReentrantLock<T> {

    private final LinkedList<T> list = new LinkedList<>();

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    private void create(T t) {
        int max = 3;
        try {
            lock.lock();
            while (list.size() == max) {
                producer.await();
            }
            list.add(t);
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private T consumer() {
        T t = null;
        try {
            lock.lock();
            while (list.size() == 0) {
                consumer.await();
            }
            t = list.removeFirst();
            producer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public void test() {
        int consumerMax = 5;
        int consumerNum = 2;
        int createMax = 2;
        int createNum = 3;
        TestReentrantLock<Object> reentrantLock = new TestReentrantLock<>();
        // 启动消费线程
        ScheduledThreadPoolExecutor threadPoolExecutor = TestThreadFactory.testThreadFactoryBuilder();
        for (int i = 0; i < consumerMax; i++) {
            int num = i;
            threadPoolExecutor.submit(() -> {
                for (int j = 0; j < consumerNum; j++) {
                    Object consumer = reentrantLock.consumer();
                    System.out.println("消费线程="+num+"-"+j+"  消费了【"+consumer+"】");
                }
            });
        }

        for (int i = 0; i < createMax; i++) {
            int num = i;
            threadPoolExecutor.submit(() -> {
                for (int j = 0; j < createNum; j++) {
                    String str = "生成 ->" + num + "--" + j;
                    reentrantLock.create(str);
                    System.out.println(str);
                }
            });
        }
    }

    public static void main(String[] args) {
        TestReentrantLock testReentrantLock = new TestReentrantLock();
        testReentrantLock.test();
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
