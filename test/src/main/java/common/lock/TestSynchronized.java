package common.lock;

import common.thread.pool.TestThreadFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huoxianwei
 * @date 2019/2/18 16:48
 */
public class TestSynchronized implements Runnable {

    private static Integer num = 0;

    @Override
    public void run() {
        synchronized (this) {
            num = num + 1;
            System.out.println(Thread.currentThread().getName());
        }
    }

    private static void test1 () {
        int five = 5;
        ScheduledThreadPoolExecutor threadPoolExecutor = TestThreadFactory.testThreadFactoryBuilder();
        for (int i = 0; i < five; i++) {
            threadPoolExecutor.submit(new TestSynchronized());
        }
    }

    public static void main(String[] args) {
        test1();
        try {
            Thread.sleep(TimeUnit.SECONDS.toSeconds(5));
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
