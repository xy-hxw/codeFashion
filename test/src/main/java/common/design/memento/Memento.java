package common.design.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 11:44
 * @Description 备忘录角色
 */
public class Memento {

    @Getter
    @Setter
    private String state;

    public Memento(String state) {
        this.state = state;
    }
}
