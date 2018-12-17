package common.design.visitor;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 15:57
 * @Description 访问者实现类
 */
public class VisitorImpl implements VisitorI {
    @Override
    public void visitor(ComputerElementImpl computerElement) {
        computerElement.doSomething();
    }

    @Override
    public void visitor(PhoneElementImpl phoneElement) {
        phoneElement.doSomething();
    }
}
