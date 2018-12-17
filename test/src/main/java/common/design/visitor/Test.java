package common.design.visitor;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 15:26
 * @Description 访问者模式
 */
public class Test {
    public static void test1(){
        ElementI computerElement = new ComputerElementImpl();
        computerElement.accept(new VisitorImpl());
        PhoneElementImpl phoneElement = new PhoneElementImpl();
        phoneElement.accept(new VisitorImpl());
    }

    public static void main(String[] args) {
        test1();
    }
}
