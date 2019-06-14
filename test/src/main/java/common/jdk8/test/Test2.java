package common.jdk8.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import common.pojo.Order;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huoxianwei
 * @date 2019/6/13 21:03
 */
public class Test2 {
    public static Character test (String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        int base = 97;
        char[] chars = str.toCharArray();
        int[] ints = new int[26];
        for (char ascii : chars) {
            int a = ascii - base;
            ints[a] = ints[a]+1;
        }
        System.out.println(JSON.toJSONString(ints));
        int max = 0;
        int i = 0;
        for (int j = 1; j < ints.length; j++) {
            if (ints[j] > max) {
                max = ints[j];
                i = j;
            }
        }
        char maxChar = (char) (i+base);
        System.out.println(maxChar);
        return maxChar;
    }
    public static void test1 () {
        List<Order> list = Lists.newArrayList();
        Order order = new Order();
        order.setId(1);
        order.setName("张三");
        list.add(order);
        Order order1 = new Order();
        order1.setId(1);
        order1.setName("李四");
        list.add(order1);
        Map<Integer, String> collect = list.stream().collect(Collectors.toMap(Order::getId, Order::getName));
        System.out.println(JSON.toJSONString(collect));
    }
    public static void main(String[] args) {
//        String str = "abcdabcdddzzzzzz";
//        test(str);
        test1();
    }
}
