package common.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huoxianwei
 * @date 2019/2/14 11:11
 * Runnable
 */
public class TestRunnable implements Runnable{

    private static AtomicInteger num = new AtomicInteger(0);

    @Override
    public void run() {
        num.addAndGet(1);
    }

    public static void main(String[] args) {
        TestRunnable testRunnable = new TestRunnable();
        Thread thread = new Thread(testRunnable);
        thread.start();
        System.out.println(num);
    }
}
