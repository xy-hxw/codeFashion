package common.design.memento;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 11:29
 * @Description 备忘录模式
 */
public class Test {
    public static void test() {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("on");
        caretaker.saveMemento(originator.createMenento());
        originator.setState("off");
        originator.restoreMenento(caretaker.retrieveMemento());
        System.out.println(originator.getState());
    }

    public static void main(String[] args) {
        test();
    }
}
