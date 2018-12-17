package common.design.visitor;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 15:53
 * @Description 访问者模式
 */
public interface ElementI {
    void accept(VisitorI visitorI);
    void doSomething();
}
