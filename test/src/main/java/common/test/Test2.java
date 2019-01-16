package common.test;

import java.util.Arrays;

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

    public static void main(String[] args) {
        sortTest();
    }

    /**
     * a > b 返回 1 升序；返回 -1 降序
     */
    private static int compare(Integer a, Integer b) {
        return a >= b ? 1 : -1;
    }
}
