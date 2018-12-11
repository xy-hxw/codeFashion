package common.test;

import common.pojo.Order;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

public class Test1 {

    private static void test1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("aaa"+i);
        }
        Collections.sort(list);
        list.forEach(System.out::println);
        System.out.println();
    }

    /**
     *  jdk8 以上map和list迭代方式
     */
    private static void test2() {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.forEach((key, value)->{
            map.put(key, "11");
            System.out.println(key+"="+value);
        });
        map.forEach((key, value)->System.out.println(key+"="+value));
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("b");
        list.add("c");
        list.forEach(System.out::println);
    }

    /**
     *  jdk 1.8 时间处理
     *  阅读方便
     */
    private static void test3() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String format = formatter.format(now);
        System.out.println(now);
        System.out.println(format);
    }
    /**
     *  jdk1.8 获取当前时间
     *  方便机器使用
     */
    private static void test7() {
        // 默认为美国时区
        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);
        // 时间相互转化
        // Date转换为LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime);
        // LocalDateTime转换为Date
        Date from = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(from);
    }
    /**
     *  jdk 1.8 随机数
     */
    private static void test4() {
        Random random = new Random(1000);
        for (int i = 0; i < 3; i++) {
            System.out.println(random.nextInt());
        }
        Random random1= new Random(1000);
        for (int i = 0; i < 3; i++) {
            System.out.println(random1.nextInt());
        }
        int i = ThreadLocalRandom.current().nextInt(10);
        System.out.println(i);
    }
    private static void test5() {
        List<Order> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Order order = new Order(i, "订单"+i, "第"+i+"个订单");
            list.add(order);
        }
        StringBuilder sb = new StringBuilder();
        list.parallelStream().forEach(key->sb.append(key.getName()));
        System.out.println(sb.toString());
    }

    /**
     *  jdk1.8 计数统计
     */
    private static void test6() {
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        System.out.println(longAdder);
    }
    /**
     *  jdk1.8 IO流处理不用关闭流
     */
    private static void test8() {
        try (FileInputStream fileInputStream = new FileInputStream("D:/wy.png"))
        {
            fileInputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
}
