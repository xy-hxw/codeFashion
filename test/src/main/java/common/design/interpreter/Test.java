package common.design.interpreter;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 17:58
 * @Description 解释器模式
 */
public class Test {
    public static void test1() {
        String str = "3 * 2 * 5";
        Calculator calculator = new Calculator();
        calculator.build(str);
        int result = calculator.compure();
        System.out.println(result);
    }

    public static void main(String[] args) {
        test1();
    }
}
