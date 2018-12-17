package common.design.state;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 14:25
 * @Description 状态模式
 */
public class Test {
    public static void test() {
        Context context = new Context();
        StateI startState = new StartStateImpl();
        startState.doAction(context);
        System.out.println(context.getStateI().toString());
        StateI stopState = new StopStateImpl();
        stopState.doAction(context);
        System.out.println(context.getStateI().toString());
    }

    public static void main(String[] args) {
        test();
    }
}
