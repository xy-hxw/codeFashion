package common.jdk8.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author huoxianwei
 * @date 2019/6/4 20:00
 */
public class Test1 {
    public static void main(String[] args) {
        String str = "62.234.164.231,111.202.36.10,124.127.99.32";
        List<String> list = Arrays.asList(str.split(","));
        for (String s : list) {
            System.out.println(s);
        }
    }
}
