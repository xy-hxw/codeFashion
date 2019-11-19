package common.system;

import java.util.UUID;

/**
 * @author huoxianwei
 * @date 2019/11/18 9:54
 */
public class Test1 {
    public static void test () {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        long id = Thread.currentThread().getId();
        System.out.println(id);
        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace);
    }

    public static void main(String[] args) {
        test();
    }
}
