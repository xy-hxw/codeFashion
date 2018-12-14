package common.design.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author huoxianwei
 * @Date 2018/12/14 11:38
 * @Description 迭代子模式
 */
public class Test {

    private  static Object[] objectArray;

    static {
        objectArray = new Object[]{"one", "two", "three", "four", "five"};
    }

    /**
     * 白箱聚集   外禀迭代子
     * createIterarorI 创建一个外禀迭代子对象
     *
     */
    public static void test() {
        IteratorI iterarorI = new ConcreteAggregateImpl(objectArray).createIterarorI();
        while (!iterarorI.isDone()) {
            Object next = iterarorI.next();
            System.out.println(next);
        }
    }

    /**
     *  黑箱聚集    内禀迭代子
     *  聚集对象内部列实现迭代子接口
     */
    public static void test1() {
        IteratorI innerIterarorI = new ConcreteAggregateImpl(objectArray).createInnerIterarorI();
        while (!innerIterarorI.isDone()) {
            Object next = innerIterarorI.next();
            System.out.println(next);
        }
    }

    /**
     * jdk  iterator 遍历枚举
     *
     * 黑箱聚集->ArrayList 中 Itr内部类
     * private class Itr implements Iterator<E>
     */
    public static void test2() {
        List<Object> objects = Arrays.asList(objectArray);
        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
    public static void main(String[] args) {
        test();
        System.out.println("...............");
        test1();
    }
}
