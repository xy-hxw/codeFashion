package common.jdk8.lambda;

import common.pojo.Product;
import one.util.streamex.EntryStream;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huoxianwei
 * @date 2019/2/18 14:38
 * 合并两个map
 */
public class TestHashMap {

    private static Map<String, Product> map1;
    private static Map<String, Product> map2;
    private static Map<String, Product> map3;

    static {
        Product product1 = new Product(1 , "巧克力");
        Product product2 = new Product(2 , "蛋糕");
        Product product3 = new Product(3 , "面包");
        map1 = new HashMap<>(6);
        map1.put(product1.getName(), product1);
        map1.put(product2.getName(), product2);
        map1.put(product3.getName(), product3);

        Product product4 = new Product(4 , "网线");
        Product product5 = new Product(5 , "显卡");
        Product product6 = new Product(6 , "面包");
        map2 = new HashMap<>(6);
        map2.put(product4.getName(), product4);
        map2.put(product5.getName(), product5);
        map2.put(product6.getName(), product6);
        map3 = new HashMap<>(map1);
    }

    /**
     * lambda merge() 合并map
     */
    public static void test1 () {
        map2.forEach((key, value) -> map3.merge(key, value, (v1, v2) -> new Product(v2.getPrice(), v2.getName())));
        map3.forEach((key, value) -> System.out.println(key + "--" + value));
    }

    /**
     * lambda concat() 合并map
     */
    public static void test2 () {
        Stream<Map.Entry<String, Product>> concat = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());
        Map<String, Product> map = concat.collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (v1, v2) -> new Product(v1.getPrice(), v2.getName())));
        map.forEach((key, value) -> System.out.println(key + "--" + value));
    }

    /**
     * lambda Stream.of() 合并
     */
    private static void test3 () {
        Map<String, Product> collect = Stream.of(TestHashMap.map1, map2)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> new Product(v1.getPrice(), v2.getName())));
        collect.forEach((key, value) -> System.out.println(key + "--" + value));
    }

    /**
     * lambda stream 借用管道流进行合并
     */
    private static void test4 () {
        HashMap<String, Product> collect = map1.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (v1, v2) -> new Product(v1.getPrice(), v2.getName()),
                () -> new HashMap<>(map2)));
        collect.forEach((key, value) -> System.out.println(key + "--" + value));
    }

    /**
     * lambda StreamEx
     * 需要添加jar
     */
    private static void test5 () {
        Map<String, Product> map = EntryStream.of(map1).append(map2)
                .toMap((v1, v2) -> new Product(v1.getPrice(), v2.getName()));
        map.forEach((key, value) -> System.out.println(key + "--" + value));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
