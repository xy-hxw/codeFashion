package common.thread;

import common.constant.Constant;
import common.thread.pool.TestThreadFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author huoxianwei
 * @date 2019/2/15 14:16
 * Callable
 */
public class TestCallable implements Callable<Integer> {

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < Constant.FIVE; i++) {
            sum = sum + i;
        }
        return sum;
    }

    private static void test () {
        ScheduledThreadPoolExecutor threadPoolExecutor = TestThreadFactory.testThreadFactoryBuilder();
        TestCallable testCallable = new TestCallable();
        Future<Integer> submit = threadPoolExecutor.submit(testCallable);
        try {
            Integer num = submit.get();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
