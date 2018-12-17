package common.design.mediator;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 17:06
 * @Description 出租方
 */
public class HouseOwner extends Person{
    HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 与中介联系
    public void constact(String message) {
        mediator.contact(message, this);
    }

    // 获取信息
    public void getMessage(String message) {
        System.out.println("name="+name+", 信息="+message);
    }
}
