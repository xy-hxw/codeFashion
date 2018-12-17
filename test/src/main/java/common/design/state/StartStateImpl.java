package common.design.state;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 14:54
 * @Description 状态接口实体类
 */
public class StartStateImpl implements StateI {
    @Override
    public void doAction(Context context) {
        System.out.println("start state");
        context.setStateI(this);
    }

    @Override
    public String toString() {
        return "start";
    }
}
