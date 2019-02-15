package common.thread;


import common.thread.pool.TestThreadFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huoxianwei
 * @date 2019/2/15 14:14
 * FutureTask
 */

public class TestFutureTask {

    class MyCallable implements Callable<String> {

        private Integer time;

        MyCallable(Integer time) {
            this.time = time;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(TimeUnit.SECONDS.toSeconds(time));
            return Thread.currentThread().getName();
        }
    }

    public void test () {
        MyCallable myCallable1 = new MyCallable(1);
        MyCallable myCallable2 = new MyCallable(4);
        FutureTask futureTask1 = new FutureTask<>(myCallable1);
        FutureTask futureTask2 = new FutureTask<>(myCallable2);
        ScheduledThreadPoolExecutor threadPoolExecutor = TestThreadFactory.testThreadFactoryBuilder();
        threadPoolExecutor.submit(futureTask1);
        threadPoolExecutor.submit(futureTask2);
        System.out.println("submit task over");
        while (true) {
            if (!futureTask1.isDone()) {
                System.out.println("futureTask1 execute ...");
            }
            if (!futureTask2.isDone()) {
                System.out.println("futureTask2 execute ...");
            }
            if (futureTask1.isDone() && futureTask2.isDone()) {
                System.out.println("task over");
                return;
            }
            try {
                Thread.sleep(TimeUnit.SECONDS.toSeconds(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("begin.....");
        new TestFutureTask().test();
        System.out.println("end.....");
    }
}
