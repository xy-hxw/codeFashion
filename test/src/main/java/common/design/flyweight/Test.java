package common.design.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huoxianwei
 * @Date 2018/12/12 16:08
 * @Description 享元模式
 *
 * jdk 中Integer(缓存)，String使用的享元模式
 *  1：享元模式包含内蕴状态和外蕴状态
 *  2：享元工厂确保合理的共享享元对象
 * 优点：
 *  1：减少系统中内存中对象的个数
 *  2：享元对象使用了外部状态，外部状态相对独立，不会影响到内部状态，使得享元对象能够在不同的环境被共享
 * 缺点：
 *  1：区分内外部状态，使系统更加复杂
 *  2：读取外部状态使运行时间变长
 *
 * 享元模式和单例模式区别
 *  1：单例模式是类级别的为一个类只有一个实例，享元模式是对象级别一个类可以有多个对象实例
 *  2：单例模式主要为了共享数据，享元模式主要为了节约内存空间
 */
public class Test {
    /**
     * 单纯享元模式
     */
    public static void test() {
        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
        FlyWeightI a = flyWeightFactory.factory('a');
        a.operation("first test");
        FlyWeightI b = flyWeightFactory.factory('b');
        b.operation("second test");
        FlyWeightI c = flyWeightFactory.factory('a');
        c.operation("three test");
    }

    /**
     * 复合享元模式
     */
    private static void test1() {
        List<Character> states = new ArrayList<>();
        states.add('a');
        states.add('b');
        states.add('c');
        states.add('a');
        states.add('b');

        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeightI factory1 = factory.factory(states);
        FlyWeightI factory2 = factory.factory(states);
        factory1.operation("factory1 test");
        System.out.println("我是分隔符-----------------");
        System.out.println("复合享元模式对象是否相等="+(factory1 == factory2));

        Character a = 'a';
        FlyWeightI factory3 = factory.factory(a);
        FlyWeightI factory4 = factory.factory(a);
        System.out.println("单纯享元模式是否相等="+(factory3 == factory4));
    }
    public static void main(String[] args) {
        test();
        test1();
    }
}
