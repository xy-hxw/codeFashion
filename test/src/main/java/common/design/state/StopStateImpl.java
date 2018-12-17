package common.design.state;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 14:55
 * @Description 状态接口实体类
 */
public class StopStateImpl implements StateI {
    @Override
    public void doAction(Context context) {
        System.out.println("stop state");
        context.setStateI(this);
    }

    @Override
    public String toString() {
        return "stop";
    }
}
