package common.jdk8.lambda;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author huoxianwei
 * @Date 2018/12/21 16:35
 * @Description CAS
 */
public class TestAtomic {
    public static void test1() {
        // CAS
        AtomicLong atomicLong = new AtomicLong();
        atomicLong.set(10L);
        System.out.println(atomicLong.doubleValue());

        // fail-fast
        LongAdder longAdder = new LongAdder();
        longAdder.add(10);
        System.out.println(longAdder.longValue());
    }

    public static void main(String[] args) {
        test1();
    }
}
