package common.jdk8.lambda.function;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author huoxianwei
 * @date 2019/2/1 15:52
 */
public class FunctionTest {

    /**
     * Predicate 返回布尔值
     * @param predicate 函数
     * @return 返回值
     */
    public static boolean test1 (Predicate<String> predicate) {
        return predicate.test("abc");
    }

    /**
     * Consumer 无返回值
     * @param list 参数
     * @param consumer 函数
     */
    private static void test2(List<String> list, Consumer<String> consumer) {
        list.forEach(consumer);
        consumer.accept(JSON.toJSONString(list));
    }

    /**
     * Function
     * @param list  参数
     * @param function 函数
     * @param <T> 入参类型
     * @param <R> 返回值类型
     * @return 返回值
     */
    private static <T, R> List<R> test3 (List<T> list, Function<T, R> function) {
        List<R> rlist = new ArrayList<>();
        for (T t:list) {
            rlist.add(function.apply(t));
        }
        return rlist;
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> list = new ArrayList<>();
        list.add("key");
        list.add("value");
        // predicate
        boolean b = test1(str::equals);
        System.out.println(b);
        // consumser
        test2(list, key->System.out.println(key));
        // function
        List<Integer> integerList = test3(list, s -> s.indexOf("a"));
        System.out.println(integerList);
    }
}
