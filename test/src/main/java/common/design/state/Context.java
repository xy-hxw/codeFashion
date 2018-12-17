package common.design.state;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author huoxianwei
 * @Date 2018/12/17 14:56
 * @Description 带有某个状态的类
 */
public class Context {
    @Getter
    @Setter
    private StateI stateI;

    public Context() {
        this.stateI = null;
    }
}
