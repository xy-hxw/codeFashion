package common.thread.pool;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * @author huoxianwei
 * @date 2019/2/15 16:05
 * 推荐使用的线程池创建方式
 */
public class TestThreadFactory {

    private static final Integer FIVE = 5;

    /**
     * 使用google的ThreadFactoryBuilder创建ThreadFactory
     * 1：ThreadFactory指定线程名称
     * 2：设置线程是否是守护线程
     * 3：设置线程优先级
     */
    public static ScheduledThreadPoolExecutor testThreadFactoryBuilder () {
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        // 线程名称
        threadFactoryBuilder.setNameFormat("THREAD");
        // 线程是否是守护线程
        threadFactoryBuilder.setDaemon(true);
        // 线程优先级  1-10
        threadFactoryBuilder.setPriority(1);
        ThreadFactory build = threadFactoryBuilder.build();
        return new ScheduledThreadPoolExecutor(100, build);
    }

    private static void test () {
        ScheduledThreadPoolExecutor threadPoolExecutor = testThreadFactoryBuilder();
        threadPoolExecutor.execute(() -> {
            int num = 0;
            for (int i = 0; i < FIVE; i++) {
                num = num + i;
            }
            System.out.println(num);
        });
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        test();
    }
}
