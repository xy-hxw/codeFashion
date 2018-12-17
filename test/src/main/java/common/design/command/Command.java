package common.design.command;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 11:12
 * @Description 命令抽象类
 */
public abstract class Command {
    // 持有一个接受者对象
    protected Recevier recevier;

    // 构造器进行接受者init
    public Command(Recevier recevier) {
        this.recevier = recevier;
    }

    // 执行命令
    public abstract void execute();
}
