package common.design.command;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 10:46
 * @Description 命令模式
 */
public class Test {
    public static void test() {
        Recevier recevier = new Recevier();
        Command command = new ConcreteCommand(recevier);
        Invoker invoker = new Invoker(command);
        invoker.executeCommand();
    }

    public static void main(String[] args) {
        test();
    }
}
