package common.design.mediator;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 17:05
 * @Description Person
 */
@Getter
@Setter
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
