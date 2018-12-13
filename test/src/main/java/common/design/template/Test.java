package common.design.template;

/**
 * @Author huoxianwei
 * @Date 2018/12/13 15:12
 * @Description Test
 */
public class Test {
    public static void test() {
        AbstaractTemplate abstaractTemplate = new SuperEatTemplate();
        abstaractTemplate.eatMethod();
        System.out.println("----------------------------");
        AbstaractTemplate abstaractTemplate1 = new CustomizeEatTemplate();
        abstaractTemplate1.eatMethod();
    }

    public static void main(String[] args) {
        test();
    }
}
