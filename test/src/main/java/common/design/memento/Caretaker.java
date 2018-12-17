package common.design.memento;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 11:48
 * @Description 负责人角色类
 *
 * 负责保存备忘录对象，但从不修改和查看对象
 */
public class Caretaker {
    private Memento memento;

    // 备忘录取值方法
    public Memento retrieveMemento() {
        return this.memento;
    }

    // 备忘录赋值方法
    public void saveMemento(Memento memento) {
        this.memento = memento;
    }
}
