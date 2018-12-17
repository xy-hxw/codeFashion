package common.design.mediator;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 16:42
 * @Description 中介者模式
 */
public class Test {
    public static void test1() {
        ConcreteMediator mediator = new ConcreteMediator();
        // 出租的和租房的各自只需知道中介机构就可以了
        HouseOwner houseOwner = new HouseOwner("张三", mediator);
        Tenant tenant = new Tenant("李四", mediator);
        // 中介需要知道房主和租房的人
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);
        // 通过中介开始沟通
        houseOwner.constact("张三要出租房子");
        tenant.constact("李四要租房子");
    }

    public static void main(String[] args) {
        test1();
    }
}
