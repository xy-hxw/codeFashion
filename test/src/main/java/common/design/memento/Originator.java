package common.design.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 11:43
 * @Description 发起人角色
 */
public class Originator {
    @Getter
    @Setter
    private String state;

    // 工厂模式-创建一个备忘录对象
    public Memento createMenento() {
        return new Memento(state);
    }
    // 将发起人恢复到备忘录对象所记载的状态
    public void restoreMenento(Memento memento) {
        this.state = memento.getState();
    }
}
