package common.thread.pool;

import java.util.concurrent.*;

/**
 * @author huoxianwei
 * @date 2019/2/15 14:28
 * Executors提供的四种线程池
 */
public class TestExecutors {

    private static final int FIVE = 5;

    /**
     * newSingleThreadExecutor 创建单线程的线程池，
     * 优点：用一个线程执行任务，保证了任务的执行顺序
     * 缺点：可能排队等候的线程多，占用非常大的内存
     */
    private static void testSingleThread () {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < FIVE; i++) {
            int key = i + 1;
            System.out.println("start----"+i);
            executorService.execute(() -> {
                try {
                    Thread.sleep(TimeUnit.SECONDS.toSeconds(1));
                    System.out.println(key);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("end----"+i);
        }
        executorService.shutdown();
    }

    /**
     * newFixedThreadPool 创建一个固定线程数的线程池
     * 优点：控制线程最大并发数
     * 缺点：等待的线程特别多时，占用很大的内存，可能造成OOM
     */
    private static void testFixedThread () {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < FIVE; i++) {
            int sum = i * i;
            // Runnable
            executorService.submit(() -> {
                try {
                    System.out.println(sum);
                    Thread.sleep(TimeUnit.SECONDS.toSeconds(1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * newCachedThreadPool可缓存的线程池，最大值=Integer.MAX_VALUE
     * 优点：灵活的创建和回收线程池
     * 缺点：可能创建非常多的线程，造成OOM
     */
    private static void testCachedThread () {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // Callable
        Future<Integer> submit = executorService.submit(() -> {
            int num = 0;
            for (int i = 0; i < FIVE; i++) {
                num = num + i;
            }
            return num;
        });
        try {
            Integer num = submit.get();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    /**
     * newScheduledThreadPool创建一个定长线程池
     * 优点：定时周期性执行任务
     * 缺点：
     */
    private static void testScheduledThread () {
        System.out.println(System.currentTimeMillis());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        ScheduledFuture<Integer> schedule = scheduledExecutorService.schedule(() -> {
            int sum = 0;
            for (int i = 1; i <= FIVE; i++) {
                sum = sum + i;
            }
            return sum;
        }, TimeUnit.SECONDS.toSeconds(3), TimeUnit.SECONDS);
        try {
            Integer sum = schedule.get();
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
        scheduledExecutorService.shutdown();
    }

    public static void main(String[] args) {
        testSingleThread();
        testFixedThread();
        testCachedThread();
        testScheduledThread();
    }
}
