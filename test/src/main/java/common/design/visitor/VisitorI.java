package common.design.visitor;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 15:56
 * @Description VisitorI
 */
public interface VisitorI {
    void visitor(ComputerElementImpl computerElement);
    void visitor(PhoneElementImpl phoneElement);
}
