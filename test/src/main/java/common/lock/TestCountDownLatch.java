package common.lock;

import common.thread.pool.TestThreadFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author huoxianwei
 * @date 2019/2/18 18:16
 */
public class TestCountDownLatch {

    private static int num = 0;

    private static void test1 () {
        int five = 5;
        CountDownLatch countDownLatch = new CountDownLatch(five);
        ScheduledThreadPoolExecutor threadPoolExecutor = TestThreadFactory.testThreadFactoryBuilder();
        for (int i = 0; i < five; i++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(" "+num);
                num = num +1;
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            test1();
            System.out.println("sum="+num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
