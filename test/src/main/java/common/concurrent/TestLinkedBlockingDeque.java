package common.concurrent;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author huoxianwei
 * @date 2019/2/18 16:39
 * LinkedBlockingDeque 双端阻塞队列
 *      任何一端可以进行元素的出入
 *      线程安全
 *      使用ReentrantLock加锁
 *
 */
public class TestLinkedBlockingDeque {

    private static LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();

    public static void test1 () {
        String poll = linkedBlockingDeque.poll();
        String s = linkedBlockingDeque.pollFirst();
        linkedBlockingDeque.addFirst("first");
        String s1 = linkedBlockingDeque.getFirst();
        System.out.println(poll+" "+s+" "+ s1+" "+linkedBlockingDeque.size());
        s1 = linkedBlockingDeque.pollFirst();
        System.out.println(poll+" "+s+" "+s1+" "+linkedBlockingDeque.size());
    }

    public static void main(String[] args) {
        test1();
    }
}
