package common.threa;

import java.util.concurrent.TimeUnit;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 13:59
 * @Description Test1
 */
public class TestThread {
    // start方法，线程被放入等待队列，等待CPU调度，并不一定马上执行
    public static void test() {
        System.out.println("线程启动前");
        Thread thread = new Thread(() -> {
            try {
                System.out.println("线程沉睡");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("线程启动中");
        thread.start();
        System.out.println("线程启动后");
    }

    // run方法当做普通方法的调用方式，方法顺序执行
    public static void test1() {
        System.out.println("线程启动前1");
        Thread thread = new Thread(() -> {
            try {
                System.out.println("线程沉睡1");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("线程启动中1");
        thread.run();
        System.out.println("线程启动后1");
    }

    public static void main(String[] args) {
        test();
        System.out.println("--------------");
        test1();
    }
}
