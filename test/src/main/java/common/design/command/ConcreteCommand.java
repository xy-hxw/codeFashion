package common.design.command;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 11:16
 * @Description ConcreteCommand
 */
public class ConcreteCommand extends Command {

    public ConcreteCommand(Recevier recevier) {
        super(recevier);
    }

    @Override
    public void execute() {
        recevier.action();
        System.out.println("执行请求");
    }
}
