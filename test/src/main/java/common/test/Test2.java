package common.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

/**
 * @author huoxianwei
 * @date 2019/1/16 14:34
 */
public class Test2 {
    private static void sortTest() {
        Integer[] arrays = {4, 1, 3, 2};
        Arrays.sort(arrays, Test2::compare);
        Arrays.stream(arrays).forEach(System.out::println);
    }

    /**
     * 队列同步器 AQS
     * 信号凭证
     */
    private static void semaphoreTest() {
        Semaphore semaphore = new Semaphore(0);
        boolean b = semaphore.tryAcquire();
        System.out.println(b);
        // 增加一个凭证
        semaphore.release();
        // 使用一个凭证（AQS）
        b = semaphore.tryAcquire();
        System.out.println(b);
    }

    public static void main(String[] args) {
//        sortTest();
//        semaphoreTest();
        HashMap<String, String> map = new HashMap<>();
        map.put("abc", "abc");
        System.out.println(map.size());
    }

    /**
     * a > b 返回 1 升序；返回 -1 降序
     */
    private static int compare(Integer a, Integer b) {
        return a >= b ? 1 : -1;
    }
}
