package common.design.mediator;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 16:58
 * @Description 具体中介者
 */
@Getter
@Setter
public class ConcreteMediator extends Mediator{
    private HouseOwner houseOwner;
    private Tenant tenant;

    @Override
    public void contact(String message, Person person) {
        if (person == houseOwner) {
            tenant.getMessage(message);
        } else {
            houseOwner.getMessage(message);
        }
    }
}
