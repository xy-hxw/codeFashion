package common.design.strategy;


import java.util.TreeSet;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 10:45
 * @Description 策略模式
 */
public class Test {
    public static void test() {
        new TreeSet<>(String::compareTo);
    }
    private static void test1() {
        StrategyI strategyI = new StrategySum();
        Environment environment = new Environment(strategyI);
        int calculate = environment.calculate(5, 10);
        System.out.println(calculate);
        System.out.println("------------------");
        StrategyI strategyI1 = new StrategySub();
        Environment environment1 = new Environment(strategyI1);
        int calculate1 = environment1.calculate(5, 10);
        System.out.println(calculate1);
    }
    public static void main(String[] args) {
        test();
        test1();
    }
}
