package common.design.visitor;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 15:55
 * @Description
 */
public class ComputerElementImpl implements ElementI {
    @Override
    public void accept(VisitorI visitorI) {
        visitorI.visitor(this);
    }

    @Override
    public void doSomething() {
        System.out.println("访问->电脑");
    }
}
