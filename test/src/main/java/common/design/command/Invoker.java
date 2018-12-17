package common.design.command;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 11:20
 * @Description 调用命令的具体执行者
 */
public class Invoker {
    public Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        System.out.println("调用命令实现者");
        command.execute();
    }
}
